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
    private final LineChart<String, Number> diseaseTrendLineChart = new LineChart<>(xAxisLineChart, yAxisLineChart);

    private final PieChart diseaseFrequencyPieChart = new PieChart();
    private final PieChart diseaseDeathTollPieChart = new PieChart();

    public void loadData() {
        this.controller.getAllReports();
    }

    public void setController(IReportController controller) {
        this.controller = controller;
    }

    @Override
    public void displayPieChartAnalytics(HashMap<String, Integer> reportCases,
                                         HashMap<String, Integer> deathToll) {
        List<PieChart.Data> diseaseFrequencyData = new ArrayList<>();
        List<PieChart.Data> diseaseDeathTollData = new ArrayList<>();

        reportCases.forEach((disease, totalCases) -> {
            diseaseFrequencyData.add(new PieChart.Data(disease, Double.valueOf(totalCases)));
        });
        deathToll.forEach((disease, totalDeaths) -> {
            diseaseDeathTollData.add(new PieChart.Data(disease, Double.valueOf(totalDeaths)));
        });

        ObservableList<PieChart.Data> frequencyData =
                FXCollections.observableArrayList(diseaseFrequencyData);
        ObservableList<PieChart.Data> tollData =
                FXCollections.observableArrayList(diseaseDeathTollData);

        diseaseFrequencyPieChart.setData(frequencyData);
        diseaseFrequencyPieChart.setTitle("Reported Cases of Diseases in 2019");

        diseaseDeathTollPieChart.setData(tollData);
        diseaseDeathTollPieChart.setTitle("Diseases Death Toll in 2019");

        this.getChildren().add(diseaseFrequencyPieChart);
        this.getChildren().add(diseaseDeathTollPieChart);
    }

    @Override
    public void displayLineChartAnalytics(HashMap<String, HashMap<String, Integer>> reportedCases) {
        diseaseTrendLineChart.setTitle("Diagnoses, 2019");
        xAxisLineChart.setLabel("Month");

        reportedCases.forEach((disease, diseaseData) -> {
            XYChart.Series series = new XYChart.Series();
            series.setName(disease);
            diseaseData.forEach((month, totalCases) -> {
                series.getData().add(new XYChart.Data(month, totalCases));
            });
            diseaseTrendLineChart.getData().add(series);
        });
        this.getChildren().add(diseaseTrendLineChart);
    }

    public LineChart<String, Number> getDiseaseTrendLineChart() {
        return this.diseaseTrendLineChart;
    }

    public PieChart getDiseaseFrequencyPieChart() {
        return this.diseaseFrequencyPieChart;
    }

    public PieChart getDiseaseDeathTollPieChart() {
        return diseaseDeathTollPieChart;
    }
}
