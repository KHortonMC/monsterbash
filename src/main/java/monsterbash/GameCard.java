package monsterbash;

import javafx.scene.canvas.GraphicsContext;
import monsterbash.gameobject.GameObject;
import monsterbash.graphics.Rect;

public abstract class GameCard extends GameObject {
    double rotation = 0;
    public void setRotation(double rotation) {this.rotation = rotation;}
    public double getRotation() {return rotation;}

    abstract void fillContents(GraphicsContext gc);

    protected GameCard() {
        setBounding(new Rect(0, 0, MonsterBash.cardWidth, MonsterBash.cardHeight));
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
