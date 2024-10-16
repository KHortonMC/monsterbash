package gametemplate.gameobject;

import gametemplate.graphics.Vector2;
import javafx.scene.canvas.GraphicsContext;
import gametemplate.Main;
import gametemplate.graphics.Circle;
import gametemplate.graphics.Rect;
import javafx.scene.paint.Color;

public class BouncingBall extends GameObject {
    Vector2 velocity = null;
    Circle ball = null;

    public BouncingBall() throws MaxObjectsException {
        super();

        velocity = new Vector2(3, 3);
        bounding = new Rect(50,50,30,30);

        ball = new Circle(bounding);
        ball.setColor(Color.ORANGE);
    }

    public void bump(Vector2 velocity) {
        ball.setPosition(ball.getPosition().add(velocity));
        this.bounding.setPosition(ball.getPosition());
    }

    @Override
    public void update() {
        bump(velocity);

        GameObject collisionObject = findCollision();
        Rect.Collision collision = Rect.Collision.NONE;
        if (collisionObject != null) {
            collision = bounding.collisionSide(collisionObject.bounding);
        }

        if (collisionObject != null) {          
            this.bounding.collisionSide(collisionObject.bounding);
        }

        // chatGPT generated the original bouncing ball logic, which is now long refactored away
        if (bounding.getX() < 0 || bounding.getX() + bounding.getW() > Main.getWindowWidth()) {
            collision = Rect.Collision.LEFT;
        }

        if (collision == Rect.Collision.LEFT || collision == Rect.Collision.RIGHT) {
            velocity.setX(velocity.getX() * -1);
        }

        if (bounding.getY() < 0 || bounding.getY() + bounding.getH() > Main.getWindowHeight()) {
            collision = Rect.Collision.BOTTOM;
        }

        if (collision == Rect.Collision.TOP || collision == Rect.Collision.BOTTOM) {
            velocity.setY(velocity.getY() * -1);
        }
    }

    @Override
    public void draw(GraphicsContext gc) {
        ball.draw(gc);
    }
}
