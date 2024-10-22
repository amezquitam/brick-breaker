package controller;

import model.Bar;
import model.extra.Image;
import model.extra.Vector2;

import java.util.Comparator;
import java.util.List;

public class BarController {
    private final SceneController sceneController;
    public final BallController ballController;

    public BarController(SceneController sceneController, BallController ballController) {
        this.sceneController = sceneController;
        this.ballController = ballController;
    }

    public void setBarPos(Float x) {
        Bar bar = getBar();
        Vector2 position = bar.transform().getPosition();
        position.setX(x);
        bar.transform().setPosition(position);
    }

    public void setBarPosY(Float y) {
        Bar bar = getBar();
        Vector2 position = bar.transform().getPosition();
        position.setY(y);
        bar.transform().setPosition(position);
    }

    public Image getImage() {
        return getBar().image();
    }

    public Vector2 getBarPos() {
        return getBar().transform().getPosition();
    }

    public Float getBarWidth() {
        return getBar().transform().getScale().getX();
    }

    public Float getBarHeight() {
        return getBar().transform().getScale().getY();
    }

    private Bar getBar() {
        return sceneController.getLevel().bar();
    }

    public void checkCollisions() {
        Vector2 ballPos = ballController.getPosition();
        Vector2 ballScl = ballController.getScale().times(0.5F);
        Vector2 ballDir = ballController.getDirection();

        Bar bar = getBar();
        Vector2 barPos = bar.transform().getPosition();
        Vector2 barScl = bar.transform().getScale().times(0.5F);

        float top    = barPos.getY() - barScl.getY() - ballScl.getY();
        float bottom = barPos.getY() + barScl.getY() + ballScl.getY();
        float right  = barPos.getX() + barScl.getX() + ballScl.getX();
        float left   = barPos.getX() - barScl.getX() - ballScl.getX();

        Float dTop = top - ballPos.getY();
        Float dBottom = ballPos.getY() - bottom;
        Float dLeft = left - ballPos.getX();
        Float dRight = ballPos.getX() - right;

        var disc = List.of(dTop, dBottom, dLeft, dRight);
        if (disc.stream().allMatch(d -> d < 0)) {
            Float side = disc.stream().max(Comparator.naturalOrder()).orElseThrow();
            if (side.equals(dTop)) {
                ballPos.setY(top);
                float midDistance = (dRight - dLeft) / (barScl.getX() * 2 + ballScl.getX() * 2);
                float angle = (float) Math.asin(midDistance);
                ballDir.setY(-(float) Math.cos(angle));
                ballDir.setX((float) Math.sin(angle));
                ballDir.normalize();
            } else if (side.equals(dBottom)) {
                ballPos.setY(bottom);
                ballDir.setY(Math.abs(ballDir.getY()));
            } else if (side.equals(dLeft)) {
                ballPos.setX(left);
                ballDir.setX(-Math.abs(ballDir.getX()));
            } else {
                ballPos.setX(right);
                ballDir.setX(Math.abs(ballDir.getX()));
            }
        }

        ballController.setDirection(ballDir);
        ballController.setPosition(ballPos);
    }
}
