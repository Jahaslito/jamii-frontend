package com.tabibu.desktop.death;

import com.tabibu.desktop.diseases.DiseaseRepository;
import com.tabibu.desktop.providers.HealthCareProviderRepository;
import io.reactivex.schedulers.Schedulers;

import java.util.ArrayList;
import java.util.List;

public class DeathController implements IDeathController {
    private IDeathView deathView;
    private IDeathRepository deathRepository;

    public DeathController(IDeathRepository deathRepository) {
     this.deathRepository = deathRepository;
    }

    @Override
    public void getAllDeaths() {
        deathRepository.getAllDeaths().subscribe(deathList -> {
            List<DeathViewModel> deathViewModels = new ArrayList<>();
            deathList.stream().forEach(death -> {
                DeathViewModel deathViewModel = new DeathViewModel();
                deathViewModel.setCorpseAge(death.getCorpseAge());
                deathViewModel.setDeathDate(death.getDeathDate());

                // TODO: Implement dependency injection using Dagger2
                HealthCareProviderRepository providerRepo = new HealthCareProviderRepository();
                DiseaseRepository diseaseRepo = new DiseaseRepository();

                providerRepo.getProvider(death.getHealthCareProvider())
                        .subscribeOn(Schedulers.io())
                        .subscribe(healthCareProvider -> {
                            deathViewModel.setProviderName(healthCareProvider.getName());
                        });

                diseaseRepo.getDisease(death.getDisease())
                        .subscribeOn(Schedulers.io())
                        .subscribe(disease -> {
                            deathViewModel.setDiseaseName(disease.getName());
                        });

                deathViewModels.add(deathViewModel);
                deathView.displayDeaths(deathViewModels);
            });
        });
    }

    public void setView(IDeathView view) {
        this.deathView = view;
    }
}
