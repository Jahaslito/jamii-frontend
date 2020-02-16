package com.tabibu.desktop.report;

import com.tabibu.desktop.TabibuApplication;
import com.tabibu.desktop.data.TabibuApiService;
import com.tabibu.desktop.death.Death;
import com.tabibu.desktop.death.DeathViewModel;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Query;

import java.util.List;
import java.util.Map;

public class ReportRepository implements IReportRepository{
    TabibuApiService apiServicee= TabibuApplication.getApiService();


    public Single <ReportViewModel> getReport( int year,int diseaseId){return apiServicee.getReport(year,diseaseId);}
}
