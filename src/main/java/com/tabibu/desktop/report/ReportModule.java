package com.tabibu.desktop.report;

import com.dlsc.workbenchfx.model.WorkbenchModule;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.scene.Node;

public class ReportModule extends WorkbenchModule {
    public ReportModule(){
        super("Reports", FontAwesomeIcon.LINE_CHART);
    };
    @Override
    public Node activate() {

        return  new ReportsView();
    }
}
