package com.tabibu.desktop.diseases;

import com.dlsc.workbenchfx.Workbench;
import com.dlsc.workbenchfx.model.WorkbenchModule;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import javafx.scene.Node;
import javafx.scene.control.Label;

public class DiseaseModule extends WorkbenchModule {
    public DiseaseModule() {
        super("Disease module", MaterialDesignIcon.THUMB_UP); // a name and an icon is required

    }


    @Override
    public Node activate() {
        // provider=new HealthCareProviderView();
        return  new Label("hello") ;
    }
}
