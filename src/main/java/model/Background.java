package model;

import model.extra.Image;

public class Background {
    private Image image;

    public Background(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
