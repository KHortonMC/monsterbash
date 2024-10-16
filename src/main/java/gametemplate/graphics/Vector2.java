package gametemplate.graphics;

public final class Vector2 {
    double x = 0.0;
    double y = 0.0;
    
    public Vector2() {

    }

    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }
    public double getX() { return this.x; }
    public double getY() { return this.y; }

    // chatGPT was used to generate these basic math methods
    public Vector2 add(Vector2 other) { return new Vector2(this.x + other.x, this.y + other.y); }
    public Vector2 subtract(Vector2 other) { return new Vector2(this.x - other.x, this.y - other.y); }
    public Vector2 scale(double scalar) { return new Vector2(this.x * scalar, this.y * scalar); }
    public double magnitude() { return Math.sqrt(x * x + y * y); }
    public Vector2 normalize() {
        double mag = magnitude();
        if (mag == 0) {
            return new Vector2(0, 0); // return 0 instead of divide by 0
        }
        return new Vector2(x / mag, y / mag);
    }

    // chatGPT generated this toString
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
