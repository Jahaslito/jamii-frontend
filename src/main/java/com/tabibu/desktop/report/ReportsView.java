package com.tabibu.desktop.report;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.*;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ReportsView extends VBox implements IReportView {
    IReportController controller;

    public void loadData() {
        this.controller.getAllReports();
    }

    public void setController(IReportController controller) {
        this.controller = controller;
    }

    @Override
    public void displayPieChartAnalytics(HashMap<String, Integer> reportCases) {
        List<PieChart.Data> data = new ArrayList<>();
        reportCases.forEach((disease, totalCases) -> {
            data.add(new PieChart.Data(disease, Double.valueOf(totalCases)));
        });
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(data);

        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle(" Reported Cases of Diseases in 2019");
        this.getChildren().add(chart);
    }

    @Override
    public void displayLineChartAnalytics(HashMap<String, HashMap<String, Integer>> reportedCases) {
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Month");
        final LineChart<String, Number> lineChart =
                new LineChart<>(xAxis, yAxis);

        lineChart.setTitle("Diagnoses, 2019");
        reportedCases.forEach((disease, diseaseData) -> {
            XYChart.Series series = new XYChart.Series();
            series.setName(disease);
            diseaseData.forEach((month, totalCases) -> {
                series.getData().add(new XYChart.Data(month, totalCases));
            });
            lineChart.getData().add(series);
        });
        this.getChildren().add(lineChart);
    }
}
