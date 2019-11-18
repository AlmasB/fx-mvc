package com.almasb.fx.mvc;

import javafx.scene.Parent;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
public class App {

    private Map<ViewName, Parent> views = new HashMap<>();
    private Stage stage;

    public App(Stage stage) {
        this.stage = stage;
    }

    void registerView(ViewName viewName, Parent view) {
        views.put(viewName, view);
    }

    Parent getView(ViewName viewName) {
        return views.get(viewName);
    }

    public final void switchViewTo(ViewName viewName) {
        Parent view = views.get(viewName);
        stage.getScene().setRoot(view);
    }

    public final void switchViewTo(ViewName viewName, Bundle bundle) {

    }
}
