package model;

import model.extra.Image;
import model.extra.Sound;
import model.extra.Transform;

public record Brick(Transform transform, Sound sound, Image image, BrickState state) {

    public static BrickBuilder builder() {
        return new BrickBuilder();
    }

    public static final class BrickBuilder {
        private Transform transform;
        private Image image;
        private Sound sound;
        private BrickState state;

        private BrickBuilder() {
            state = new BrickState(2, 0);
        }

        public BrickBuilder transform(Transform transform) {
            this.transform = transform;
            this.transform.setFreezeX(Boolean.TRUE);
            this.transform.setFreezeY(Boolean.TRUE);
            return this;
        }

        public BrickBuilder sound(Sound sound) {
            this.sound = sound;
            return this;
        }

        public BrickBuilder image(Image image) {
            this.image = image;
            return this;
        }

        public BrickBuilder state(Integer maxCollisionTimes) {
            this.state = new BrickState(maxCollisionTimes, 0);
            return this;
        }


        public Brick build() {
            return new Brick(transform, sound, image, state);
        }
    }
}
