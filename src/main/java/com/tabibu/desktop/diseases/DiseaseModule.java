package com.tabibu.desktop.view;

import com.dlsc.workbenchfx.Workbench;
import com.dlsc.workbenchfx.model.WorkbenchModule;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import javafx.scene.Node;
import javafx.scene.control.Label;

public class Diseasemodule extends WorkbenchModule {
    public Diseasemodule() {
        super("Disease module", MaterialDesignIcon.THUMB_UP); // a name and an icon is required

    }


    @Override
    public Node activate() {
        // provider=new HealthCareProviderView();
        return  new Label("hello") ;
    }
}
