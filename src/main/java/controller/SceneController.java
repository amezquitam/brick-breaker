package controller;

import java.util.List;

import config.GameConfig;
import model.Level;

public class SceneController {
    private final List<Level> levels;
    private final Integer lives;
    private Integer currentLevel;
    private Integer usedLives;
    
    public SceneController(GameConfig gameConfig) {
        this.levels = gameConfig.getLevels();
        this.lives = gameConfig.getLives();
        this.currentLevel = 0;
        this.usedLives = 0;
    }

    public Level getLevel() {
        if (currentLevel >= levels.size())
            return null;
        return levels.get(currentLevel);
    }

    public void advance() {
        currentLevel++;
    }

    public Boolean gameOver() {
        return (isLoser() || isWinner());
    }

    public Boolean isLoser() {
        return usedLives == lives;
    }

    public Boolean isWinner() {
        return currentLevel == levels.size();
    }
}
