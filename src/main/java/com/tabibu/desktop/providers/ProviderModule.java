package com.tabibu.desktop.providers;

import com.dlsc.workbenchfx.model.WorkbenchModule;
import com.tabibu.desktop.providers.HealthCareProviderView;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import javafx.scene.Node;

public class ProviderModule extends WorkbenchModule {
    HealthCareProviderView provider;

    public ProviderModule(HealthCareProviderView view) {
        super("Healthcare Providers", FontAwesomeIcon.H_SQUARE);
        provider = view;
    }

    @Override
    public Node activate() {
        return provider;
    }
}

