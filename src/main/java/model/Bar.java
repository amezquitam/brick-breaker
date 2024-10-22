package model;

import model.extra.Image;
import model.extra.Sound;
import model.extra.Transform;

public record Bar(Transform transform, Sound sound, Image image) {

    public static BarBuilder builder() {
        return new BarBuilder();
    }

    public static final class BarBuilder {
        private Transform transform;
        private Sound sound;
        private Image image;

        public BarBuilder() {
        }

        public static BarBuilder aBar() {
            return new BarBuilder();
        }

        public BarBuilder transform(Transform transform) {
            this.transform = transform;
            return this;
        }

        public BarBuilder sound(Sound sound) {
            this.sound = sound;
            return this;
        }

        public BarBuilder image(Image image) {
            this.image = image;
            return this;
        }

        public Bar build() {
            return new Bar(transform, sound, image);
        }
    }
}
