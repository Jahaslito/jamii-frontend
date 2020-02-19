package com.tabibu.desktop.report;

import com.dlsc.workbenchfx.model.WorkbenchModule;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.scene.Node;

public class LineChart extends WorkbenchModule {
    private ReportsView view;
    protected LineChart() {
        super("Line chart analysis",FontAwesomeIcon.LINE_CHART);
        view=new ReportsView();
    }

    @Override
    public Node activate() {
        return view.displayLineChartAnalytics();
    }
}
