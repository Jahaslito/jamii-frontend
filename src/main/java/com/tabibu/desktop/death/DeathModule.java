package com.tabibu.desktop.death;

import com.dlsc.workbenchfx.model.WorkbenchModule;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.scene.Node;

public class DeathModule extends WorkbenchModule {
    private DeathView deathView;

    public DeathModule(DeathView deathView) {
        super("Death Records", FontAwesomeIcon.USER_TIMES);
        this.deathView = deathView;
    }

    @Override
    public Node activate() {
        return deathView;
    }
}
