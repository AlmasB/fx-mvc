package com.almasb.fx.mvc.demo;

import com.almasb.fx.mvc.Config;
import com.almasb.fx.mvc.FXMVC;
import javafx.application.Application;
import javafx.stage.Stage;

public class DemoApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        var config = new Config();
        config.addModel(CalculatorModel.class, new CalculatorModel());
        config.setViewNames(Views.values());

        FXMVC.start(this, stage, config);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
