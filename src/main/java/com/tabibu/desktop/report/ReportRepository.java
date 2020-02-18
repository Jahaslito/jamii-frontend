package com.tabibu.desktop.report;

import com.tabibu.desktop.TabibuApplication;
import com.tabibu.desktop.data.TabibuApiService;
import io.reactivex.Single;

public class ReportRepository implements IReportRepository {
    TabibuApiService apiService = TabibuApplication.getApiService();

    public Single<ReportViewModel> getReport(int year, int diseaseId){
        return apiService.getReport(year, diseaseId);
    }
}
