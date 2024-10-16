package gametemplate.gameobject;

import gametemplate.Main;
import gametemplate.graphics.Rect;
import gametemplate.graphics.Rectangle;
import gametemplate.graphics.Vector2;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class StaticBrick extends GameObject {
    Rectangle brick = null;

    public StaticBrick() throws MaxObjectsException {
        super();
        brick = new Rectangle();
    }

    public StaticBrick(Rect rect) throws MaxObjectsException {
        super();
        bounding = rect;
        brick = new Rectangle(rect);
        brick.setColor(Color.CORNFLOWERBLUE);
    }
    
    @Override
    public void update() {
        brick.setPosition(brick.getPosition().add(Main.getScreenDelta()));
        this.bounding.setPosition(brick.getPosition());

        GameObject collisionObject = findCollision();
        if (collisionObject instanceof BouncingBall 
            && Main.getScreenDelta().magnitude() > 0.0) {

            Rect.Collision collision = this.bounding.collisionSide(collisionObject.bounding);
            Vector2 direction = null;

            switch (collision)
            {
                case Rect.Collision.TOP: direction = new Vector2(0,-5); break;
                case Rect.Collision.BOTTOM: direction = new Vector2(0,5); break;
                case Rect.Collision.LEFT: direction = new Vector2(-5,0); break;
                case Rect.Collision.RIGHT: direction = new Vector2(5,0); break;
                default: break;
            }

            ((BouncingBall)collisionObject).bump(direction);
        }
    }

    @Override
    public void draw(GraphicsContext gc) {
        brick.draw(gc);
    }

    @Override
    public String toString() {
        return brick.toString();
    }
}
