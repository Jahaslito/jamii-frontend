package com.tabibu.desktop.death;

import com.tabibu.desktop.diseases.IDiseaseRepository;
import com.tabibu.desktop.diseases.IDiseaseView;
import io.reactivex.functions.Consumer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;
import java.util.stream.Collectors;


public class DeathController implements IDeathController {
    IDeathRepository deathRepository;
    IDeathView deathView;

    public DeathController(IDeathRepository deathRepository) {
        this.deathRepository = deathRepository;
    }

    @Override
    public void getAllDeaths() {
        deathRepository.getAllDeaths().subscribe( deathList -> {
            List<DeathViewModel> deathViewModels = deathList.stream().map(death -> new DeathViewModel(death.getCorpseAge(),
                    death.getDisease().getName(),
                    death.getHealthCareProvider().getName(),
                    death.getDeathDate())).collect(Collectors.toList());
            this.deathView.displayDeaths(deathViewModels);

        });
    }
    public void addDeath( int corpseAge,String diseaseName,String providerName,String deathDate){
        DeathViewModel death=new DeathViewModel(corpseAge,diseaseName,providerName,deathDate);
        deathRepository.createPost(death).enqueue(new Callback<DeathViewModel>() {

            @Override
            public void onResponse(Call<DeathViewModel> call, Response<DeathViewModel> response) {
                if(response.isSuccessful()) {
                    if (!response.isSuccessful()) {
                        System.out.println("couldnt post on death");
                        return;
                    }
                    System.out.println("posted");
                }
            }

            @Override
            public void onFailure(Call<DeathViewModel> call, Throwable t) {
              System.out.println("successfully posted on death");
            }


        });
    }

    public void setView(IDeathView view) {
        this.deathView = view;
    }
}
