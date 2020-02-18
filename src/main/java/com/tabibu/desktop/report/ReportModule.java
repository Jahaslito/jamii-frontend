package com.tabibu.desktop.report;

import com.dlsc.workbenchfx.model.WorkbenchModule;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.scene.Node;

public class ReportModule extends WorkbenchModule {
    ReportsView reportView;

    public ReportModule(ReportsView reportView){
        super("Reports", FontAwesomeIcon.LINE_CHART);
        this.reportView = reportView;
    };

    @Override
    public Node activate() {
        return reportView;
    }
}
