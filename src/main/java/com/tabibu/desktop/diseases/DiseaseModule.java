package com.tabibu.desktop.diseases;

import com.dlsc.workbenchfx.Workbench;
import com.dlsc.workbenchfx.model.WorkbenchModule;
import com.tabibu.desktop.providers.HealthCareProviderView;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import javafx.scene.Node;
import javafx.scene.control.Label;

public class DiseaseModule extends WorkbenchModule {
    DiseaseView diseaseView;

    public DiseaseModule(DiseaseView view) {
        super("Disease Records", FontAwesomeIcon.BUG);
        diseaseView = view;
    }

    @Override
    public Node activate() {
        return diseaseView;
    }
}
