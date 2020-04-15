package com.almasb.fx.mvc.demo;

import com.almasb.fx.mvc.ControllerWithModelView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class Controller2 extends ControllerWithModelView<CalculatorModel, VBox> {

    @FXML
    private Button btn;

    @Override
    public void onModelInitialized() {
        btn.textProperty().bind(getModel().lastResultProperty().asString());
    }

    public void openMainView() {
        switchViewTo(Views.MAIN);
    }

    public void randomize() {
        getModel().setLastResult((int)(Math.random() * 1000));
    }
}
