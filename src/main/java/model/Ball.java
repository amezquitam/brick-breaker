package model;

import model.extra.Image;
import model.extra.Transform;

public class Ball {
    private final Image image;
    private final Transform transform;
    
    public Ball(Image image, Transform transform) {
        this.image = image;
        this.transform = transform;
    }

    public Image getImage() {
        return image;
    }

    public Transform getTransform() {
        return transform;
    }
}
