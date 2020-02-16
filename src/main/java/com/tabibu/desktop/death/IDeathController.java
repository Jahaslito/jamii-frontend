package com.tabibu.desktop.death;

public interface IDeathController {
    void getAllDeaths();
    public void addDeath( int corpseAge,String diseaseName,String providerName,String deathDate);
}
