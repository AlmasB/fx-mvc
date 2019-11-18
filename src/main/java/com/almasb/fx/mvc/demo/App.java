package com.almasb.fx.mvc.demo;

import com.almasb.fx.mvc.Controller;
import com.almasb.fx.mvc.Model;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        var modelContext = Map.of(
                CalculatorModel.class, new CalculatorModel()
        );


        List<String> views = List.of("main.fxml", "view1.fxml", "view2.fxml");

        var actualViews = views.stream().map(viewName -> {
            try {
                var loader = new FXMLLoader(getClass().getResource(viewName));
                Parent view = loader.load();
                Controller<?, ?> controller = loader.getController();

                Class<?> modelClass = controller.getClass().getDeclaredAnnotation(Model.class).value();
                var instance = modelContext.get(modelClass);

                getFieldByName("model", controller).ifPresent(field -> {
                    field.setAccessible(true);


                    try {
                        field.set(controller, instance);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });

                if (controller instanceof MainController) {
                    ((MainController) controller).runSomething();
                }

                return view;
            } catch (Exception e) {
                //e.printStackTrace();
                return new VBox();
            }
        }).collect(Collectors.toList());


//        var viewsMap = Map.of(
//
//        )


        var scene = new Scene(actualViews.get(0));

        stage.setScene(scene);
        stage.show();
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

    public static void main(String[] args) {
        launch(args);
    }
}
