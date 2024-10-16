package monsterbash;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import monsterbash.gameobject.GameObject;
import monsterbash.graphics.Rect;

public class MonsterCard extends GameObject {
    MonsterStats stats = null;
    String name = null;
    Image image = null;

    // TODO: add a superpower label!
    static final double borderPadding = 8;

    double rotation = 0;

    public void setRotation(double rotation) {this.rotation = rotation;}
    public double getRotation() {return rotation;}

    public MonsterCard(String name, MonsterStats stats) {
        super();
        this.name = name;
        this.stats = stats;
        setBounding(new Rect(0, 0, MonsterBash.cardWidth, MonsterBash.cardHeight));
        image = new Image("file:img/" + name + ".png");
        this.setVisible(true);
        this.setActive(true);
    }

    public void update() {
        super.update();
    }

    public void draw(GraphicsContext gc) {
        super.draw(gc);

        gc.save();

        gc.translate(this.getPosition().getX(), this.getPosition().getY());
        gc.rotate(this.rotation);
        //gc.translate(getBounding().getCenterX(), getBounding().getCenterY());



        gc.setFill(Color.GREEN);
        gc.fillRect(0, 0, getBounding().getW(), getBounding().getH());
        gc.drawImage(image, borderPadding, borderPadding, MonsterBash.cardWidth - (borderPadding*2), MonsterBash.cardHeight - (borderPadding*2));
        gc.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, MonsterBash.fontSize));
        gc.setFill(Color.RED);
        gc.fillText(name, 0, 0 + getBounding().getH());
        gc.fillText(stats.toString(), MonsterBash.fontSize, MonsterBash.fontSize);

        gc.restore();
    }
}
