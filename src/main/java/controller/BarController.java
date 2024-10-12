package controller;

import model.Bar;
import model.extra.Vector2;

public class BarController {
    private SceneController sceneController;

    public BarController(SceneController sceneController) {
        this.sceneController = sceneController;
    }

    public void setBarPos(Float x) {
        Bar bar = sceneController.getLevel().getBar();
        Vector2 oldPosition = bar.getTransform().getPosition();
        oldPosition.setX(x);
    }
}
