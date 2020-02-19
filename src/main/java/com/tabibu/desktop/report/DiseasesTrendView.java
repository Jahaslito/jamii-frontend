package com.tabibu.desktop.report;

import com.dlsc.workbenchfx.model.WorkbenchModule;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.scene.Node;

public class DiseasesTrendView extends WorkbenchModule {
    private ReportsView view;

    public DiseasesTrendView(ReportsView view) {
        super("Disease Trend Analysis",FontAwesomeIcon.LINE_CHART);
        this.view = view;
    }

    @Override
    public Node activate() {
        return view.getDiseaseTrendLineChart();
    }
}
