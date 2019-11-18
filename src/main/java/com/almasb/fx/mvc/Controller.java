package com.almasb.fx.mvc;

import javafx.scene.Parent;

public abstract class Controller<M, V extends Parent> {

    private M model;
    private V view;

    public final M getModel() {
        return model;
    }

    public final V getView() {
        return view;
    }
}
