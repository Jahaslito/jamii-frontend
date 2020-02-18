package com.tabibu.desktop.report;

import com.tabibu.desktop.diseases.DiseaseRepository;
import com.tabibu.desktop.diseases.IDiseaseRepository;
import io.reactivex.schedulers.Schedulers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ReportsController implements IReportController {
    private IReportRepository reportRepository;
    private IReportView reportView;

    public ReportsController(IReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public void getAllReports() {
        HashMap<String, Integer> pieChartData = new HashMap<>();
        HashMap<String, HashMap<String, Integer>> lineChartData = new HashMap<>();

        DiseaseRepository diseaseRepository = new DiseaseRepository();
        diseaseRepository.getAllDiseases().subscribe(diseases -> {
            diseases.forEach(disease -> {
                reportRepository.getReport(2019, disease.getId())
                        .subscribe(report -> {
                            int totalCasesInAYear = report.getCases()
                                    .stream().map(CaseViewModel::getTotalCases)
                                    .mapToInt(Integer::intValue)
                                    .sum();
                            pieChartData.put(disease.getName(), totalCasesInAYear);

                            HashMap<String, Integer> monthlyCases = new HashMap<>();
                            report.getCases().forEach(caseViewModel -> {
                                monthlyCases.put(caseViewModel.getMonth(), caseViewModel.getTotalCases());
                            });
                            lineChartData.put(disease.getName(), monthlyCases);
                        });
            });
        });
        reportView.displayPieChartAnalytics(pieChartData);
        reportView.displayLineChartAnalytics(lineChartData);
    }

    public void setView(IReportView view) {
        this.reportView = view;
    }
}


