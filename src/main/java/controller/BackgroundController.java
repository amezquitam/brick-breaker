package controller;

import model.extra.Image;

public class BackgroundController {
    private final SceneController scene;

    public BackgroundController(SceneController scene) {
        this.scene = scene;
    }

    public Image getImage() {
        return scene.getLevel().getBackground().getImage();
    }
}
