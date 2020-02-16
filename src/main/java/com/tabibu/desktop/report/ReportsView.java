package com.tabibu.desktop.report;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;


public class ReportsView extends VBox {
    ReportRepository reportRepository=new ReportRepository();
    ReportsController controller=new ReportsController(reportRepository);
    List<Integer> totalcasesInAyear=new ArrayList<>();
   public ReportsView(){
        controller.getAllReports();
    piechart();

    }
    public void choice() {
        Button [] options=new Button[7];
        options[0]=new Button("line chart");
        options[1]=new Button("pie chart");
        ObservableList<Button> choices=
                FXCollections.observableArrayList(
                        options[0],options[1]

                );
        final ComboBox comboBox = new ComboBox(choices);
        options[0].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                lineChart();
            }
        });
        options[1].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                piechart();
            }
        });
        comboBox.setLayoutX(900);
        comboBox.setLayoutY(900);
        this.getChildren().add(comboBox);

    }
    public void lineChart(){
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Number of Month");
        //creating the chart
        final LineChart<Number,Number> lineChart =
                new LineChart<Number,Number>(xAxis,yAxis);

        lineChart.setTitle("Stock Monitoring, 2010");
        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("My portfolio");
        //populating the series with data
        List<ReportViewModel> reports=controller.getReportsList();
        List<PieChart.Data> data=new ArrayList<>();
        List<List<CaseViewModel>> cases=controller.getCases();
        for(int i=0;i<reports.size();i++){

            String name= reports.get(i).getDisease().getName();
            System.out.println("name "+ name);
            int number=0;
            for(int j=0;j<=12;j++)
            {
                number=number+cases.get(i).get(j).getTotalcases();
            }
            series.getData().add(new XYChart.Data(name,i));

        }

        lineChart.getData().add(series);
         this.getChildren().add(lineChart);

    }
    public void piechart(){
        List<ReportViewModel> reports=controller.getReportsList();
        System.out.println(controller.getReportsList().size());
        List<PieChart.Data> data=new ArrayList<>();
        List<List<CaseViewModel>> cases=controller.getCases();
        for(int i=0;i<reports.size();i++)
        {

                data.add(new PieChart.Data(reports.get(i).getDisease().getName(), controller.getTotalcasesInAyear().get(i)));

        }



        ObservableList<PieChart.Data> pieChartData =
               FXCollections.observableArrayList( data);


        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Table for diseases in 2019");
        this.getChildren().add(chart);

    }
}
