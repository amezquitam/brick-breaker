package config;
import java.util.List;

import model.Background;
import model.Ball;
import model.Bar;
import model.Brick;
import model.Level;
import model.extra.Image;
import model.extra.Transform;
import model.extra.Vector2;

public class GameConfig {
    private final List<Level> levels;
    private final Integer lives;

    private static final GameConfig INSTANCE;

    static {
        
        Level firstLevel = new Level(
            List.of(new Brick(new Transform(new Vector2(10, 10), new Vector2(1, 1)), null)), 
            new Bar(new Transform(new Vector2(0, 0), new Vector2(0, 0)), null), 
            new Ball(new Image("balls/epic.png"), new Transform(new Vector2(0, 0), new Vector2(0, 0))),
            new Background(new Image("backgrounds/redbg.jpg"))
        );

        List<Level> levels = List.of(firstLevel);

        INSTANCE = new GameConfig(levels, 3);
    }

    public static GameConfig get() {
        return INSTANCE;
    }

    private GameConfig(List<Level> levels, Integer lives) {
        this.levels = levels;
        this.lives = lives;
    }

    public List<Level> getLevels() {
        return levels;
    }

    public Integer getLives() {
        return lives;
    }
}
