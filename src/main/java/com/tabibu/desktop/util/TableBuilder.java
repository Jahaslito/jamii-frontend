package com.tabibu.desktop.util;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class TableBuilder {
    private List<TableColumn> columns = new ArrayList<>();
    private ObservableList tableData;
    private int tableMinHeight = 500, tableMinWidth = 1000;


    private TableBuilder() {}

    public static TableBuilder createTable() {
        return new TableBuilder();
    }

    public TableBuilder withColumns(List<TableColumn> columns) {
        this.columns.addAll(columns);
        return this;
    }

    public TableBuilder withProperties(List<PropertyValueFactory<?, ?>> props) {
        this.columns.forEach( column -> {
             column.setCellValueFactory(props.get(columns.indexOf(column)));
        });
        return this;
    }

    public TableBuilder withMinimumHeightOf(int minHeight) {
        this.tableMinHeight = minHeight;
        return this;
    }

    public TableBuilder withMinimumWidthOf(int minWidth) {
        this.tableMinWidth = minWidth;
        return this;
    }

    public TableBuilder withData(ObservableList tableData) {
        this.tableData = tableData;
        return this;
    }

    public TableView build() {
        TableView table = new TableView();
        table.setEditable(true);
        table.setItems(tableData);
        table.getColumns().addAll(columns);
        return table;
    }
}
