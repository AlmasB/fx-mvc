package com.almasb.fx.mvc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.Optional;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
public class FXMVC {

    public static void start(Application fxApp, Stage stage, Config config) {
        var app = new App(stage);

        Arrays.stream(config.getViewNames())
                .forEach(viewName -> {
                    app.registerView(viewName, buildView(viewName, fxApp, app, config));
                });

        stage.setScene(new Scene(app.getView(config.getViewNames()[0])));
        stage.show();
    }

    private static Parent buildView(ViewName viewName, Application fxApp, App app, Config config) {
        try {
            var loader = new FXMLLoader(fxApp.getClass().getResource(viewName.getName()));
            Parent view = loader.load();
            ControllerWithView<?> controller = loader.getController();

            getFieldByName("app", controller).ifPresent(field -> {

                field.setAccessible(true);

                try {
                    field.set(controller, app);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            });

            controller.onViewInitialized();

            if (controller instanceof ControllerWithModelView) {
                ParameterizedType genericSuperclass = (ParameterizedType) controller.getClass().getGenericSuperclass();
                Class<?> modelClass = (Class<?>) genericSuperclass.getActualTypeArguments()[0];

                var instance = config.getModel(modelClass);

                getFieldByName("model", controller).ifPresent(field -> {

                    field.setAccessible(true);

                    try {
                        field.set(controller, instance);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });

                ((ControllerWithModelView<?, ?>) controller).onModelInitialized();
            }

            return view;

        } catch (Exception e) {
            throw new RuntimeException("Failed to build view for: " + viewName.getName());
        }
    }

    private static Optional<Field> getFieldByName(String name, Object instance) {
        Class<?> typeClass = instance.getClass();
        while (typeClass != null && typeClass != Object.class) {
            for (Field f : typeClass.getDeclaredFields()) {
                if (f.getName().equals(name)) {
                    return Optional.of(f);
                }
            }
            typeClass = typeClass.getSuperclass();
        }

        return Optional.empty();
    }
}
