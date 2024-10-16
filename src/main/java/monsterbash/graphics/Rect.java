package monsterbash.graphics;

public final class Rect {
    double x = 0.0;
    double y = 0.0;
    double w = 0.0;
    double h = 0.0;

    public Rect(double x, double y, double w, double h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public Rect(Vector2 position, Vector2 size) {
        this.x = position.getX();
        this.y = position.getY();
        this.w = size.getX();
        this.h = size.getY();
    }

    public double getX() {return x;}
    public double getY() {return y;}
    public double getW() {return w;}
    public double getH() {return h;}

    public Vector2 getPosition() { return new Vector2(x, y); }
    public Vector2 getSize() { return new Vector2(w, h); }

    public void setPosition(Vector2 position) { x = position.getX(); y = position.getY(); }
    public void setSize(Vector2 size) { x = size.getX(); y = size.getY(); }

    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }
    public void setW(double w) { this.w = w; }
    public void setH(double h) { this.h = h; }

    public double getCenterX() { return this.x + this.w/2; }
    public double getCenterY() { return this.y + this.h/2; }

    public enum Collision {
        NONE,
        TOP,
        BOTTOM,
        LEFT,
        RIGHT
    }

    public boolean doesCollide(Rect other) {
        return this.x <= other.x + other.w
            && this.x + this.w >= other.x
            && this.y <= other.y + other.h 
            && this.y + this.h >= other.y;
    }

    // chatGPT was used to solve for collisionSide
    public Collision collisionSide(Rect other) {
        if (!doesCollide(other)) return Collision.NONE;

        double leftCollision = Math.abs((this.x + this.w) - other.x);    // right
        double rightCollision = Math.abs(this.x - (other.x + other.w));  // left
        double topCollision = Math.abs((this.y + this.h) - other.y);     // bottom
        double bottomCollision = Math.abs(this.y - (other.y + other.h)); // top

        // Find the minimum distance
        double minDistance = Math.min(Math.min(leftCollision, rightCollision), 
                                        Math.min(topCollision, bottomCollision));

        // Determine which side caused the collision
        if (minDistance == leftCollision) {
            return Collision.RIGHT;
        } else if (minDistance == rightCollision) {
            return Collision.LEFT;
        } else if (minDistance == topCollision) {
            return Collision.BOTTOM;
        } else {
            return Collision.TOP;
        }
    }

    public String toString() {
        return "[" + x + "," + y + "," + w + "," + h + "]";
    }
}
