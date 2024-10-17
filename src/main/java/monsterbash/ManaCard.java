package monsterbash;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class ManaCard extends GameCard {
    public enum Suit {
        WILD,
        HEART,
        SHIELD,
        SWORD,
        MAGIC,
    }

    Suit suit = Suit.WILD;
    int value = 1;

    public ManaCard(int value, Suit suit) {
        super();
        this.suit = suit;
        this.value = value;
    }

    @Override
    public String toString() {
        String suit = null;
        String value = null;

        suit = switch (this.suit) {
            case Suit.MAGIC -> "᳃";
            case Suit.HEART -> "♥";
            case Suit.SHIELD -> "⛨";
            case Suit.SWORD -> "⚔";
            default -> "☽";
        };

        value = switch (this.value) {
            case 1 -> "A";
            case 11 -> "J";
            case 12 -> "Q";
            case 13 -> "K";
            default -> "" + this.value;
        };

        return suit + value;
    }

    @Override
    void fillContents(GraphicsContext gc) {
        gc.setFill(Color.GREEN);
        gc.fillRect(0, 0, getBounding().getW(), getBounding().getH());
        gc.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, MonsterBash.fontSize));
        gc.setFill(Color.BLUE);
        gc.fillText(this.toString(), getBounding().getW() / 2, getBounding().getH() / 2);
    }
}
