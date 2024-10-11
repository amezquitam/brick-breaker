package controller;

import model.Bar;
import model.extra.Vector2;

public class BarController {
    private Bar bar;

    public BarController(Bar bar) {
        this.bar = bar;
    }

    public void setBarPos(Float x) {
        Vector2 oldPosition = bar.getTransform().getPosition();
        oldPosition.setX(x);
    }
    
}
