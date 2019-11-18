package com.almasb.fx.mvc.demo;

import com.almasb.fx.mvc.ViewName;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
public enum Views implements ViewName {

    MAIN("main.fxml"),
    VIEW1("view1.fxml"),
    VIEW2("view2.fxml");

    private String viewName;

    Views(String viewName) {
        this.viewName = viewName;
    }

    @Override
    public String getName() {
        return viewName;
    }
}
