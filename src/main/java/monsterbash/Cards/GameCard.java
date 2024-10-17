package monsterbash.Cards;

import javafx.scene.canvas.GraphicsContext;
import monsterbash.Board.MonsterBash;
import monsterbash.gameobject.GameObject;
import monsterbash.graphics.Rect;

public abstract class GameCard extends GameObject {
    public static final double cardWidth = MonsterBash.boardWidth /10;
    public static final double cardHeight = cardWidth * 1.5;

    double rotation = 0;
    public void setRotation(double rotation) {this.rotation = rotation;}
    public double getRotation() {return rotation;}

    double scale = 1;
    public void setScale(double scale) {this.scale = scale;}
    public double getScale() {return scale;}

    abstract void fillContents(GraphicsContext gc);

    protected GameCard() {
        setBounding(new Rect(0, 0, cardWidth, cardHeight));
    }

    public void draw(GraphicsContext gc) {
        super.draw(gc);

        gc.save();

        gc.translate(this.getPosition().getX(), this.getPosition().getY());
        gc.rotate(this.rotation);

        fillContents(gc);

        gc.restore();
    }
}
