package gametemplate.graphics;

import javafx.scene.canvas.GraphicsContext;

public class Rectangle extends Figure {
    public Rectangle() {
        super();
    }

    public Rectangle(Rect rect) {
        super(rect);
    }

    public void draw(GraphicsContext gc) {
        gc.setFill(this.color);
        gc.fillRect(this.rect.getX(), this.rect.getY(), this.rect.getW(), this.rect.getH());
    }
}
