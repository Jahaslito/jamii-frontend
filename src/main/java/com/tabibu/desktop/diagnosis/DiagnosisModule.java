package com.tabibu.desktop.diagnosis;

import com.dlsc.workbenchfx.model.WorkbenchModule;
import com.tabibu.desktop.death.DeathView;
import com.tabibu.desktop.diseases.DiseaseView;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import javafx.scene.Node;

public class DiagnosisModule extends WorkbenchModule {

    DiagnosisView diagnosis;

    public DiagnosisModule(DiagnosisView diagnosis) {
        super("Diagnosis Records", MaterialDesignIcon.THERMOMETER);
        this.diagnosis=diagnosis;
    }

    @Override
    public Node activate() {
        return diagnosis;
    }
}

