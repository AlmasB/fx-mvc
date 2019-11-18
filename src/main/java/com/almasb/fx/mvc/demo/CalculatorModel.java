package com.almasb.fx.mvc.demo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class CalculatorModel {

    private IntegerProperty lastResult = new SimpleIntegerProperty();

    public int getLastResult() {
        return lastResult.getValue();
    }

    public void setLastResult(int lastResult) {
        this.lastResult.setValue(lastResult);
    }

    public IntegerProperty lastResultProperty() {
        return lastResult;
    }
}
