package com.tabibu.desktop.diagnosis;

import com.dlsc.workbenchfx.model.WorkbenchModule;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import javafx.scene.Node;

public class DiagnosisModule extends WorkbenchModule {

    DiagnosisView diagnosisView;

    public DiagnosisModule(DiagnosisView diagnosisView) {
        super("Diagnosis Records", MaterialDesignIcon.THERMOMETER);
        this.diagnosisView = diagnosisView;
    }

    @Override
    public Node activate() {
        return diagnosisView;
    }
}

