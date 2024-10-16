package gametemplate.gameobject;

import gametemplate.graphics.Drawable;
import gametemplate.graphics.Rect;
import gametemplate.graphics.Vector2;
import javafx.scene.canvas.GraphicsContext;

public class GameObject implements Drawable {
    private static class ObjectList {
        static int MAX_OBJECTS = 100;
        static int INVALID_ID = -1;
        int lastID = 0;
        GameObject[] gameObjects = null;

        ObjectList() {
            gameObjects = new GameObject[ObjectList.MAX_OBJECTS];
        }

        int addObject(GameObject o) throws MaxObjectsException {
            o.myID = ObjectList.INVALID_ID;
            for (int i = 0; i < gameObjects.length; i++) {
                if (gameObjects[i] == null) {
                    gameObjects[i] = o;
                    o.myID = lastID++;
                    break;
                }
            }

            if (o.myID == ObjectList.INVALID_ID) {
                throw new MaxObjectsException();
            }

            return o.myID;
        }

        int removeObject(GameObject o) {
            for (int i = 0; i < gameObjects.length; i++) {
                // compare references, not content
                if (gameObjects[i] == o) { 
                    gameObjects[i] = null;
                }
            }
            return o.myID;
        }
    }

    int myID = -1;
    static ObjectList objects = null;
    Vector2 getPosition() { return null; }
    Rect bounding = null;

    public static void initialize() {
        objects = new ObjectList();
    }

    public static void updateAll() {
        for (int i = 0; i < objects.gameObjects.length; i++) {
            if (objects.gameObjects[i] != null) {
                objects.gameObjects[i].update();
            }
        }
    }

    public static void drawAll(GraphicsContext gc) {
        for (int i = 0; i < objects.gameObjects.length; i++) {
            if (objects.gameObjects[i] != null) {
                objects.gameObjects[i].draw(gc);
            }
        }
    }

    public GameObject() throws MaxObjectsException {
        if (objects.addObject(this) == ObjectList.INVALID_ID) {
            throw new MaxObjectsException();
        }
    }

    protected GameObject findCollision() {
        if (this.bounding == null) return null;

        GameObject otherObject = null;
        boolean collides = false;

        for (int i = 0; i < objects.gameObjects.length; i++) {
            // only compare to valid objects that aren't us!
            otherObject = objects.gameObjects[i];
            if (otherObject != null 
                && otherObject != this
                && otherObject.bounding != null) {
                collides = this.bounding.doesCollide(otherObject.bounding);
                if (collides) {
                    return otherObject;
                }
            }
        }

        return null;
    }

    public void update() {
        // for future classes to Override
    }
    
    public void draw(GraphicsContext gc) {
        // for future classes to Override
    }
}
