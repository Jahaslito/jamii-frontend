package com.tabibu.desktop.death;

import com.dlsc.workbenchfx.Workbench;
import com.dlsc.workbenchfx.model.WorkbenchModule;
import com.tabibu.desktop.providers.HealthCareProviderView;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import javafx.scene.Group;
import javafx.scene.Node;

public class DeathModule extends WorkbenchModule {
   DeathView deaths;

    public DeathModule(DeathView deaths) {
        super("Death", MaterialDesignIcon.BRIEFCASE); // a name and an icon is required
       this.deaths=deaths;
    }

    @Override
    public Node activate() {
        return deaths;
    }
}
