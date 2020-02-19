package com.tabibu.desktop.report;

import com.dlsc.workbenchfx.model.WorkbenchModule;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.scene.Node;

public class DiseasesTrendView extends WorkbenchModule {
    private ReportsView reportsView;

    public DiseasesTrendView(ReportsView reportsView) {
        super("Disease Trend Analysis", FontAwesomeIcon.LINE_CHART);
        this.reportsView = reportsView;
    }

    @Override
    public Node activate() {
        return reportsView.getDiseaseTrendLineChart();
    }
}
