package gametemplate.graphics;

import javafx.scene.canvas.GraphicsContext;

public class Circle extends Figure {
    public Circle() {
        super();
    }

    public Circle(Rect rect) {
        super(rect);
    }

    public void draw(GraphicsContext gc) {
        gc.setFill(this.color);
        gc.fillOval(this.rect.getX(), this.rect.getY(), this.rect.getW(), this.rect.getH());
    }
}
