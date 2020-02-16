package com.tabibu.desktop.report;

import com.tabibu.desktop.death.Death;
import io.reactivex.Single;
import retrofit2.Call;

import java.util.List;
import java.util.Map;

public interface IReportRepository {
    Single<ReportViewModel> getReport(int year,int diseaseId);
}
