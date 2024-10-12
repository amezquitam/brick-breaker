package controller;

import config.GameConfig;

public class GameController {
    private final SceneController sceneController;
    private final BarController barController;
    private final BackgroundController backgroundController;
    
    public GameController(GameConfig gameConfig) {
        sceneController = new SceneController(gameConfig);
        backgroundController = new BackgroundController(sceneController);
        barController = new BarController(sceneController);
    }

    public SceneController getSceneController() {
        return sceneController;
    }

    public BarController getBarController() {
        return barController;
    }

    public BackgroundController getBackgroundController() {
        return backgroundController;
    }
    
}
