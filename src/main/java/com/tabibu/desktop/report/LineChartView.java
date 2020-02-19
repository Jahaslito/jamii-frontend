package com.tabibu.desktop.report;

import com.dlsc.workbenchfx.model.WorkbenchModule;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.scene.Node;
import javafx.scene.control.Label;

public class LineChartView extends WorkbenchModule {
    private ReportsView view;
    public LineChartView(ReportsView view) {
        super("Line chart analysis",FontAwesomeIcon.LINE_CHART);
        this.view=view;
    }


    @Override
    public Node activate() {
   return view.getChart();
    }
}
