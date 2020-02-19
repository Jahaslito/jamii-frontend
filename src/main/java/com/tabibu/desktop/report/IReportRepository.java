package com.tabibu.desktop.report;

import io.reactivex.Single;

public interface IReportRepository {
    Single<ReportViewModel> getReport(int year, int diseaseId);
}
