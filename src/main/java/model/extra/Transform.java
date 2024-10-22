package model.extra;

public class Transform {
    private Vector2 position;
    private Vector2 scale;
    private Boolean freezeX;
    private Boolean freezeY;

    public Transform(Vector2 position, Vector2 scale) {
        this.position = position;
        this.scale = scale;
        this.freezeX = Boolean.FALSE;
        this.freezeY = Boolean.FALSE;
    }

    public Boolean getFreezeX() {
        return freezeX;
    }

    public void setFreezeX(Boolean freezeX) {
        this.freezeX = freezeX;
    }

    public Boolean isFreezeY() {
        return freezeY;
    }

    public void setFreezeY(Boolean freezeY) {
        this.freezeY = freezeY;
    }

    public Vector2 getPosition() {
        return (Vector2) position.clone();
    }

    public void setPosition(Vector2 position) {
        if (freezeX) position.setX(position.getX());
        if (freezeY) position.setY(position.getY());
        this.position = position;
    }

    public Vector2 getScale() {
        return (Vector2) scale.clone();
    }

    public void setScale(Vector2 scale) {
        this.scale = scale;
    }

    public static TransformBuilder builder() {
        return new TransformBuilder();
    }

    public static final class TransformBuilder {
        private Vector2 position;
        private Vector2 scale;
        private Boolean freezeX;
        private Boolean freezeY;

        private TransformBuilder() {
        }

        public static TransformBuilder aTransform() {
            return new TransformBuilder();
        }

        public TransformBuilder position(Vector2 position) {
            this.position = position;
            return this;
        }

        public TransformBuilder scale(Vector2 scale) {
            this.scale = scale;
            return this;
        }

        public TransformBuilder freezeX(Boolean freezeX) {
            this.freezeX = freezeX;
            return this;
        }

        public TransformBuilder freezeY(Boolean freezeY) {
            this.freezeY = freezeY;
            return this;
        }

        public Transform build() {
            Transform transform = new Transform(position, scale);
            transform.setFreezeX(freezeX == null || Boolean.FALSE);
            transform.setFreezeY(freezeY == null || Boolean.FALSE);
            return transform;
        }
    }
}
