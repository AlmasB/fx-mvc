package com.almasb.fx.mvc;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
public final class Config {

    private Map<Class<?>, Object> models = new HashMap<>();
    private ViewName[] viewNames = new ViewName[0];

    public <T> void addModel(Class<T> modelClass, T model) {
        models.put(modelClass, model);
    }

    public <T> T getModel(Class<T> modelClass) {
        return (T) models.get(modelClass);
    }

    public void setViewNames(ViewName[] viewNames) {
        this.viewNames = viewNames;
    }

    Map<Class<?>, Object> getModels() {
        return models;
    }

    ViewName[] getViewNames() {
        return viewNames;
    }
}
