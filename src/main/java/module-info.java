module com.gametemplate.gametemplate {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens gametemplate to javafx.fxml;
    exports gametemplate;
}