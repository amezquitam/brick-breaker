package controller;

import config.GameConfig;
import model.Level;

import java.util.List;

public class SceneController {
    private final List<Level> levels;
    private final Integer lives;
    private Integer currentLevel;
    private Integer usedLives;
    
    public SceneController(GameConfig gameConfig) {
        this.levels = gameConfig.levels();
        this.lives = gameConfig.lives();
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

    public Integer getRemainingLives() {
        return lives - usedLives;
    }

    public Integer getCurrentLevel() {
        return currentLevel;
    }

    public void lose() {
        usedLives++;
    }

    public Boolean isLoser() {
        return usedLives.equals(lives);
    }

    public Boolean isWinner() {
        return currentLevel.equals(levels.size());
    }
}
