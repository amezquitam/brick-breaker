package model.extra;

import java.lang.reflect.InvocationTargetException;

public class Transform {
    public static Transform extractFrom(Object object) {
        Class<?> clazz = object.getClass();
        for (var method : clazz.getMethods()) {
            if (method.getReturnType().equals(Transform.class)) {
                try {
                    return (Transform) method.invoke(object);
                } catch (InvocationTargetException | IllegalAccessException err) {
                    err.printStackTrace();
                }
            }
        }
        return null;
    }

    private Vector2 position;
    private Vector2 scale;
    private Boolean freezeX;
    private Boolean freezeY;

    public Transform(Vector2 position, Vector2 scale) {
        this.position = position;
        this.scale = scale;
        this.freezeX = false;
        this.freezeY = false;
    }

    public Boolean getFreezeX() {
        return freezeX;
    }

    public void setFreezeX(Boolean freezeX) {
        this.freezeX = freezeX;
    }

    public Boolean getFreezeY() {
        return freezeY;
    }

    public void setFreezeY(Boolean freezeY) {
        this.freezeY = freezeY;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public Vector2 getScale() {
        return scale;
    }

    public void setScale(Vector2 scale) {
        this.scale = scale;
    }
}
