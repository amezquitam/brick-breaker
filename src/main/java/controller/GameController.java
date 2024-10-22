package controller;

import config.GameConfig;

public class GameController {
    private SceneController sceneController;
    private BarController barController;
    private BackgroundController backgroundController;
    private BallController ballController;
    private BrickController brickController;

    public GameController(GameConfig gameConfig) {
        sceneController = new SceneController(gameConfig);
        backgroundController = new BackgroundController(sceneController);
        ballController = new BallController(sceneController);
        barController = new BarController(sceneController, ballController);
        brickController = new BrickController(sceneController, ballController);
    }

    public void reset() {
        sceneController = new SceneController(GameConfig.newConfig());
        backgroundController = new BackgroundController(sceneController);
        ballController = new BallController(sceneController);
        barController = new BarController(sceneController, ballController);
        brickController = new BrickController(sceneController, ballController);
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

    public BallController getBallController() {
        return ballController;
    }

    public BrickController getBrickController() {
        return brickController;
    }
}
