package model;

import model.extra.Image;
import model.extra.Transform;
import model.extra.Vector2;

public class Ball {
    private final Image image;
    private final Transform transform;
    private Float velocity;
    private Vector2 direction;

    public Ball(Image image, Transform transform, Float velocity) {
        this.image = image;
        this.transform = transform;
        this.velocity = velocity;
        direction = new Vector2(1, -1).normalize();
    }

    public Image getImage() {
        return image;
    }

    public Transform getTransform() {
        return transform;
    }

    public Float getVelocity() {
        return velocity;
    }

    public void setVelocity(Float velocity) {
        this.velocity = velocity;
    }

    public Vector2 getDirection() {
        return (Vector2) direction.clone();
    }

    public void setDirection(Vector2 direction) {
        this.direction = direction;
    }

    public static BallBuilder builder() {
        return new BallBuilder();
    }

    public static final class BallBuilder {
        private Image image;
        private Transform transform;
        private Float velocity;
        private Vector2 direction;

        private BallBuilder() {
        }

        public static BallBuilder aBall() {
            return new BallBuilder();
        }

        public BallBuilder image(Image image) {
            this.image = image;
            return this;
        }

        public BallBuilder transform(Transform transform) {
            this.transform = transform;
            return this;
        }

        public BallBuilder velocity(Float velocity) {
            this.velocity = velocity;
            return this;
        }

        public BallBuilder direction(Vector2 direction) {
            this.direction = direction;
            return this;
        }

        public Ball build() {
            Ball ball = new Ball(image, transform, velocity);
            ball.setDirection(direction);
            return ball;
        }
    }
}
