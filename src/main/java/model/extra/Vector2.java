package model.extra;

public class Vector2 {

    public static Vector2 add(Vector2 o1, Vector2 o2) {
        return new Vector2(o1.x + o2.x, o1.y + o2.y);
    }

    public static Vector2 substract(Vector2 o1, Vector2 o2) {
        return new Vector2(o1.x - o2.x, o1.y - o2.y);
    }
    
    private float x, y;
    
    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2 add(Vector2 o) {
        x += o.x;
        y += o.y;
        return this;
    }

    public Vector2 minus(Vector2 o) {
        x -= o.x;
        y -= o.y;
        return this;
    }

    public Float dot(Vector2 o) {
        return x * o.x + y * o.y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    
}
