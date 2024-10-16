package gametemplate.graphics;

import javafx.scene.paint.Color;

public abstract class Figure implements Drawable {
    protected Rect rect = null;
    protected Color color = Color.WHITE;

    protected Figure() {
        this.rect = new Rect(0,0,0,0);
    }

    protected Figure(Rect rect) {
        this.rect = rect;
    }

    public void setPosition(Vector2 position) { rect.setPosition(position); }
    public Vector2 getPosition() { return rect.getPosition(); }
    public void setSize(Vector2 size) { rect.setSize(size); }
    public Vector2 getSize() { return rect.getSize(); }
    public void setColor(Color color) { this.color = color; }
    public Color getColor() { return this.color; }

    public String toString() {
        return this.rect.toString();
    }

    // where's our abstract method? guess what, it's from the interface!
}
