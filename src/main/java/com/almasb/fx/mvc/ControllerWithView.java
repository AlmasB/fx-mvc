package com.almasb.fx.mvc;

import javafx.scene.Parent;

public abstract class ControllerWithView<V extends Parent> {

    private V view;

    public final V getView() {
        return view;
    }

    public final void switchViewTo(ViewName viewName) {

    }

    public final void switchViewTo(ViewName viewName, Bundle bundle) {

    }
}
