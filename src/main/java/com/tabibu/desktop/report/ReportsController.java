package com.tabibu.desktop.report;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class ReportsController implements IReportController {
    IReportRepository reportRepository;
    private ObservableList<ReportViewModel> reportsList = FXCollections.observableArrayList();
    List<List<CaseViewModel>> cases = new ArrayList<List<CaseViewModel>>();
    List<Integer> totalcasesInAyear=new ArrayList<>();
    public List<List<CaseViewModel>> getCases() {
        return cases;
    }
    public List<ReportViewModel> getReportsList() {
        return reportsList;
    }


    public List<Integer> getTotalcasesInAyear() {
       return totalcasesInAyear;
    }

    public ReportsController(IReportRepository reportRepository) {
        this.reportRepository = reportRepository;
        getAllReports();

    }


    public void getAllReports() {


        for (int i = 1; i < 12; i++) {

            reportRepository.getReport(2019,i).subscribe(report-> {
                reportsList.addAll(report);
            });

        }
        for(int i=0;i<reportsList.size();i++)
        {
            int counter=0;
            for(int j=1;j<12;j++) {
                counter=counter+reportsList.get(i).getCases().get(j).getTotalcases();
                System.out.println(reportsList.get(i).getCases().get(j).getTotalcases());

            }
            System.out.println(counter);
            totalcasesInAyear.add(counter);
        }

    }
}


