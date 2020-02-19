package com.tabibu.desktop.report;

import com.dlsc.workbenchfx.model.WorkbenchModule;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.scene.Node;

public class DiseasesDeathTollView extends WorkbenchModule {
    private ReportsView view;

    public DiseasesDeathTollView(ReportsView view) {
        super("Diseases Death Toll", FontAwesomeIcon.HEARTBEAT);
        this.view = view;
    }

    @Override
    public Node activate() {
        return view.getDiseaseDeathTollPieChart();
    }
}
