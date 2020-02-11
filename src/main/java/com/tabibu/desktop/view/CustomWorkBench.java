package com.tabibu.desktop.view;

import com.dlsc.workbenchfx.model.WorkbenchModule;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import javafx.scene.Node;
import javafx.scene.control.Label;

public class CustomWorkBench extends WorkbenchModule {
    public CustomWorkBench() {
        super("My first Workbench module", MaterialDesignIcon.THUMB_UP); // a name and an icon is required

    }


    @Override
    public Node activate() {
        return new Label("Hello World");
    }
}

