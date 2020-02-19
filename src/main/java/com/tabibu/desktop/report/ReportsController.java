package com.tabibu.desktop.report;

import com.tabibu.desktop.diseases.DiseaseRepository;

import java.util.HashMap;

public class ReportsController implements IReportController {
    private IReportRepository reportRepository;
    private IReportView reportView;

    public ReportsController(IReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public void getAllReports() {
        HashMap<String, Integer> pieChartFrequencyData = new HashMap<>();
        HashMap<String, HashMap<String, Integer>> lineChartData = new HashMap<>();

        HashMap<String, Integer> pieChartTollData = new HashMap<>();

        DiseaseRepository diseaseRepository = new DiseaseRepository();
        diseaseRepository.getAllDiseases().subscribe(diseases -> {
            diseases.forEach(disease -> {
                reportRepository.getReport(2019, disease.getId())
                        .subscribe(report -> {
                            int totalCasesInAYear = report.getCases()
                                    .stream().map(CaseViewModel::getTotalCases)
                                    .mapToInt(Integer::intValue)
                                    .sum();
                            pieChartFrequencyData.put(disease.getName(), totalCasesInAYear);
                            pieChartTollData.put(disease.getName(), report.getTotalReportedDeaths());

                            HashMap<String, Integer> monthlyCases = new HashMap<>();
                            report.getCases().forEach(caseViewModel -> {
                                monthlyCases.put(caseViewModel.getMonth(), caseViewModel.getTotalCases());
                            });
                            lineChartData.put(disease.getName(), monthlyCases);
                        });
            });
        });
        reportView.displayPieChartAnalytics(pieChartFrequencyData, pieChartTollData);
        reportView.displayLineChartAnalytics(lineChartData);
    }

    public void setView(IReportView view) {
        this.reportView = view;
    }
}


