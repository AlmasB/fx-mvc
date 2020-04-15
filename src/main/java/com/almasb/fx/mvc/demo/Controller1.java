package com.almasb.fx.mvc.demo;

import com.almasb.fx.mvc.ControllerWithModelView;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class Controller1 extends ControllerWithModelView<CalculatorModel, VBox> {

    @FXML
    private TextField fieldValue;

    @Override
    public void onModelInitialized() {
        fieldValue.textProperty().bind(getModel().lastResultProperty().asString("Value: %d"));
    }

    public void openMainView() {
        switchViewTo(Views.MAIN);
    }
}
