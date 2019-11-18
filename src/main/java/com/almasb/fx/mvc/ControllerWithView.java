package com.almasb.fx.mvc;

import javafx.scene.Parent;

public abstract class ControllerWithView<V extends Parent> {

    private App app;

    private V view;

    public final V getView() {
        return view;
    }

    public final void switchViewTo(ViewName viewName) {
        app.switchViewTo(viewName);
    }

    public final void switchViewTo(ViewName viewName, Bundle bundle) {

    }
}
