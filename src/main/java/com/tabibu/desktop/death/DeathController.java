package com.tabibu.desktop.death;

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
        deathRepository.getAllDeaths().subscribe(deathList -> {
            List<DeathViewModel> deathViewModels = deathList.stream().map(death -> new DeathViewModel(death.getCorpseAge(),
                    death.getDisease().getName(),
                    death.getHealthCareProvider().getName(),
                    death.getDeathDate())).collect(Collectors.toList());
            this.deathView.displayDeaths(deathViewModels);

        });
    }

    public void setView(IDeathView view) {
        this.deathView = view;
    }
}
