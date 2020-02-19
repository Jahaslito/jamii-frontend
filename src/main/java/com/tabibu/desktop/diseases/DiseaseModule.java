package com.tabibu.desktop.diseases;

import com.dlsc.workbenchfx.model.WorkbenchModule;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.scene.Node;

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
