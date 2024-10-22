package config;

import model.*;
import model.extra.Image;
import model.extra.Transform;
import model.extra.Vector2;

import java.util.List;

public record GameConfig(List<Level> levels, Integer lives, Float gravity) {

    private static GameConfig INSTANCE;
    public static Integer barPos = 100;

    public static GameConfig newConfig() {
        Level firstLevel = Level.builder()
                .bricks(List.of(
                        Brick.builder()
                                .state(5)
                                .image(new Image("bricks/neon.png"))
                                .transform(
                                        Transform.builder()
                                                .position(new Vector2(20, 20))
                                                .scale(new Vector2(70, 30))
                                                .build())
                                .sound(null)
                                .build(),
                        Brick.builder()
                                .image(new Image("bricks/neon.png"))
                                .transform(Transform.builder()
                                        .position(new Vector2(150, 20))
                                        .scale(new Vector2(70, 30))
                                        .build())
                                .sound(null)
                                .build()))
                .bar(Bar.builder()
                        .transform(Transform.builder().position(new Vector2(0, 0)).scale(new Vector2(200, 20)).build())
                        .sound(null)
                        .image(new Image("bars/basic.png"))
                        .build())
                .ball(Ball.builder()
                        .image(new Image("balls/metal.png"))
                        .transform(Transform.builder().position(new Vector2(0, 0)).scale(new Vector2(20, 20)).build())
                        .velocity(350.F)
                        .direction(new Vector2(2, -3).normalize())
                        .build())
                .background(Background.builder().image(new Image("backgrounds/neon.jpg")).build())
                .build();

        List<Level> levels = List.of(firstLevel);

        INSTANCE = new GameConfigBuilder().lives(3).levels(levels).gravity(1800.0F).build();
        return INSTANCE;
    }

    public static GameConfig get() {
        return INSTANCE;
    }

    private static final class GameConfigBuilder {
        private List<Level> levels;
        private Integer lives;
        private Float gravity;

        private GameConfigBuilder() {
        }

        public GameConfigBuilder levels(List<Level> levels) {
            this.levels = levels;
            return this;
        }

        public GameConfigBuilder lives(Integer lives) {
            this.lives = lives;
            return this;
        }

        public GameConfigBuilder gravity(Float gravity) {
            this.gravity = gravity;
            return this;
        }

        public GameConfig build() {
            return new GameConfig(levels, lives, gravity);
        }
    }
}
