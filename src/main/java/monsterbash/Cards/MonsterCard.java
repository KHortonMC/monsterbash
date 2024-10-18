package monsterbash.Cards;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import monsterbash.Board.MonsterBash;
import monsterbash.Board.MonsterStats;

public class MonsterCard extends GameCard {
    MonsterStats stats;
    String name;
    Image image;

    // TODO: add a superpower label!
    static final double borderPadding = 8;

    public MonsterCard(String name, MonsterStats stats) {
        super();
        this.name = name;
        this.stats = stats;
        image = new Image("file:img/" + name + ".png");
        this.setVisible(true);
        this.setActive(true);
    }

    public void update() {
        super.update();
    }

    public MonsterStats getStats() {return stats;}

    void fillContents(GraphicsContext gc) {
        gc.setFill(Color.GREEN);
        gc.fillRect(0, 0, getBounding().getW(), getBounding().getH());
        gc.drawImage(image, borderPadding, borderPadding, GameCard.cardWidth - (borderPadding*2), GameCard.cardHeight - (borderPadding*2));
        gc.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, MonsterBash.fontSize));
        gc.setFill(Color.RED);
        gc.fillText(name, 0, 0 + getBounding().getH());
        gc.fillText(stats.toString(), MonsterBash.fontSize, MonsterBash.fontSize);
    }
}
