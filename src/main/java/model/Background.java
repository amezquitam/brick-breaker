package model;

import model.extra.Image;

public record Background(Image image) {

    public static BackgroundBuilder builder() {
        return new BackgroundBuilder();
    }

    public static final class BackgroundBuilder {
        private Image image;

        private BackgroundBuilder() {
        }

        public static BackgroundBuilder aBackground() {
            return new BackgroundBuilder();
        }

        public BackgroundBuilder image(Image image) {
            this.image = image;
            return this;
        }

        public Background build() {
            return new Background(image);
        }
    }
}
