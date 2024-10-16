module com.monsterbash.monsterbash {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens monsterbash to javafx.fxml;
    exports monsterbash;
}