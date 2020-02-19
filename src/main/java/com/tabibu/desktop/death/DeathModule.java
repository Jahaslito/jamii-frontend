package com.tabibu.desktop.death;

import com.dlsc.workbenchfx.Workbench;
import com.dlsc.workbenchfx.model.WorkbenchModule;
import com.tabibu.desktop.providers.HealthCareProviderView;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import javafx.scene.Group;
import javafx.scene.Node;

public class DeathModule extends WorkbenchModule {
   DeathView deaths;

    public DeathModule(DeathView deaths) {
        super("Death Records", FontAwesomeIcon.USER_TIMES);
       this.deaths=deaths;
    }

    @Override
    public Node activate() {
        return deaths;
    }
}
