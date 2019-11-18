package com.almasb.fx.mvc.demo;

import com.almasb.fx.mvc.ControllerWithView;
import javafx.scene.layout.BorderPane;

public class MainController extends ControllerWithView<BorderPane> {

    public void openView1() {
        switchViewTo(Views.VIEW1);
    }

    public void openView2() {
        switchViewTo(Views.VIEW2);
    }
}
