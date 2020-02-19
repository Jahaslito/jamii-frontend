package com.tabibu.desktop.report;

import com.dlsc.workbenchfx.model.WorkbenchModule;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.scene.Node;

public class DiseasesFrequencyView extends WorkbenchModule {
    private ReportsView view;

    public DiseasesFrequencyView(ReportsView view) {
        super("Disease Frequency Analysis", FontAwesomeIcon.PIE_CHART);
        this.view = view;
    }

    @Override
    public Node activate() {
        return view.getPieChart();
    }
}
