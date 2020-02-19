package com.tabibu.desktop.report;

import com.tabibu.desktop.common.BaseRepository;
import io.reactivex.Single;

public class ReportRepository implements BaseRepository<ReportViewModel>, IReportRepository {
    public Single<ReportViewModel> getReport(int year, int diseaseId) {
        return apiService.getReport(year, diseaseId);
    }
}
