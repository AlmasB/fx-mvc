module com.almasb.fx.mvc {

    requires javafx.controls;
    requires javafx.fxml;

    exports com.almasb.fx.mvc.demo to javafx.graphics, javafx.fxml;

    opens com.almasb.fx.mvc to javafx.fxml;
    opens com.almasb.fx.mvc.demo to javafx.fxml;
}