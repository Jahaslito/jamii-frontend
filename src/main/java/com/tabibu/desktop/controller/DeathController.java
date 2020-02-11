package com.tabibu.desktop.controller;

import com.tabibu.desktop.repository.DeathRepository;
import com.tabibu.desktop.repository.IDeathRepository;
import com.tabibu.desktop.repository.IProviderRepository;
import com.tabibu.desktop.view.IDeathView;
import com.tabibu.desktop.view.IHealthCareProviderView;

public class DeathController implements IDeathController {
    private IDeathView DeathView;
    private IDeathRepository deathRepository;

    public DeathController(IDeathRepository deathRepository) {
     this.deathRepository=deathRepository;
    }

    @Override
    public void getAllDeaths() {
      DeathView.displayDeath(deathRepository.getAllDeaths());
    }

    public void setView(IDeathView view) {
        this.DeathView = view;
    }
}
