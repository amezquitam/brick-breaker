package model;

import java.util.List;

public record Level(List<Brick> bricks, Bar bar, Ball ball, Background background) {
    public static LevelBuilder builder() {
        return new LevelBuilder();
    }
    public static final class LevelBuilder {
        private List<Brick> bricks;
        private Bar bar;
        private Ball ball;
        private Background background;

        public LevelBuilder() {
        }

        public static LevelBuilder aLevel() {
            return new LevelBuilder();
        }

        public LevelBuilder bricks(List<Brick> bricks) {
            this.bricks = bricks;
            return this;
        }

        public LevelBuilder bar(Bar bar) {
            this.bar = bar;
            return this;
        }

        public LevelBuilder ball(Ball ball) {
            this.ball = ball;
            return this;
        }

        public LevelBuilder background(Background background) {
            this.background = background;
            return this;
        }

        public Level build() {
            return new Level(bricks, bar, ball, background);
        }
    }
}
