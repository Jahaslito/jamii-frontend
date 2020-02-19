package com.tabibu.desktop.report;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.*;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ReportsView extends VBox implements IReportView {
    private IReportController controller;

    private final CategoryAxis xAxisLineChart = new CategoryAxis();
    private final NumberAxis yAxisLineChart = new NumberAxis();
    private final LineChart<String, Number> lineChart = new LineChart<>(xAxisLineChart, yAxisLineChart);

    private final PieChart pieChart = new PieChart();

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

        pieChart.setData(pieChartData);
        pieChart.setTitle(" Reported Cases of Diseases in 2019");
        this.getChildren().add(pieChart);
    }

    @Override
    public void displayLineChartAnalytics(HashMap<String, HashMap<String, Integer>> reportedCases) {
        lineChart.setTitle("Diagnoses, 2019");
        xAxisLineChart.setLabel("Month");

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

    public LineChart<String, Number> getLineChart() {
        return this.lineChart;
    }

    public PieChart getPieChart() {
        return this.pieChart;
    }
}
