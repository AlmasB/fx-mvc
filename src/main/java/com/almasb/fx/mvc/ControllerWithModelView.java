package com.almasb.fx.mvc;

import javafx.scene.Parent;

public abstract class ControllerWithModelView<M, V extends Parent> extends ControllerWithView<V> {

    private M model;

    public final M getModel() {
        return model;
    }
}
