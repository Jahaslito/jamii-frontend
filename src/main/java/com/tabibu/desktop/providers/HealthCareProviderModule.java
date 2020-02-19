package com.tabibu.desktop.providers;

import com.dlsc.workbenchfx.model.WorkbenchModule;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.scene.Node;

public class HealthCareProviderModule extends WorkbenchModule {
    private HealthCareProviderView healthCareProviderView;

    public HealthCareProviderModule(HealthCareProviderView view) {
        super("Registered Healthcare Providers", FontAwesomeIcon.H_SQUARE);
        healthCareProviderView = view;
    }

    @Override
    public Node activate() {
        return healthCareProviderView;
    }
}

