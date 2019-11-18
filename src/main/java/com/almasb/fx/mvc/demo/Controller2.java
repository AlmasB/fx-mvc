package com.almasb.fx.mvc.demo;

import com.almasb.fx.mvc.ControllerWithModelView;
import javafx.scene.layout.VBox;

public class Controller2 extends ControllerWithModelView<CalculatorModel, VBox> {

    public void openMainView() {
        switchViewTo(Views.MAIN);
    }
}
