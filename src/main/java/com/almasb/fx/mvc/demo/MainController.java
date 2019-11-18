package com.almasb.fx.mvc.demo;

import com.almasb.fx.mvc.Controller;
import com.almasb.fx.mvc.Model;
import javafx.scene.layout.BorderPane;

@Model(CalculatorModel.class)
public class MainController extends Controller<CalculatorModel, BorderPane> {


    public void runSomething() {
        System.out.println(getModel());
    }
}
