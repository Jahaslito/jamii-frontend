package com.tabibu.desktop.report;

import com.tabibu.desktop.diseases.Disease;

import java.util.List;

public class ReportViewModel {
    private Disease disease;
    private int year;
    private int totalReportedDeaths;
    private List<CaseViewModel> cases;

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setCases(List<CaseViewModel> cases) {
        this.cases = cases;
    }

    public Disease getDisease() {
        return disease;
    }

    public int getYear() {
        return year;
    }

    public List<CaseViewModel> getCases() {
        return cases;
    }

    public int getTotalReportedDeaths() {
        return totalReportedDeaths;
    }

    public void setTotalReportedDeaths(int totalReportedDeaths) {
        this.totalReportedDeaths = totalReportedDeaths;
    }
}
