package com.tabibu.desktop.model;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;



public interface tabibuPlaceholderAPI {
    @GET("/phpmyadmin/tbl_structure.php?db=123125_tabibu&table=health_care_provider&token=dc863ebc2dc5d656c987b43eeab12455")
    Call<List<HealthCareProvider>> gethcp();
}
