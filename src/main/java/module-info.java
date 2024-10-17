module com.monsterbash.monsterbash {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.smartcardio;

    opens monsterbash to javafx.fxml;
    exports monsterbash;
    exports monsterbash.Cards;
    opens monsterbash.Cards to javafx.fxml;
    exports monsterbash.Board;
    opens monsterbash.Board to javafx.fxml;
}