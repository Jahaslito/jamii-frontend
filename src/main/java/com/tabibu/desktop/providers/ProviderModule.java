package com.tabibu.desktop.view;

import com.dlsc.workbenchfx.model.WorkbenchModule;
import com.tabibu.desktop.providers.HealthCareProviderView;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import javafx.scene.Node;

public class ProviderModule extends WorkbenchModule {
    HealthCareProviderView provider;

    public ProviderModule(HealthCareProviderView view) {
        super("HealthCare Providers", MaterialDesignIcon.THUMB_UP); // a name and an icon is required
        provider = view;
    }

    @Override
    public Node activate() {
        provider = new HealthCareProviderView();
        return provider;
    }
}

