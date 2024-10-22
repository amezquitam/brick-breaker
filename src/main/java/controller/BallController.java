package controller;

import model.Ball;
import model.extra.Image;
import model.extra.Vector2;

public class BallController {
    private final SceneController sceneController;

    public BallController(SceneController sceneController) {
        this.sceneController = sceneController;
    }

    private Ball getBall() {
        return sceneController.getLevel().ball();
    }
    public Vector2 getPosition() {
        return getBall().getTransform().getPosition();
    }
    public Vector2 getDirection() {
        return getBall().getDirection();
    }
    public Vector2 getScale() {
        return getBall().getTransform().getScale();
    }
    public Image getImage() { return getBall().getImage(); }
    public void setPosition(Vector2 pos) {
        getBall().getTransform().setPosition(pos);
    }
    public void setDirection(Vector2 dir) {
        getBall().setDirection(dir);
    }
    public void updatePosition(Float dt) {
        Vector2 pos = getPosition();
        Vector2 dir = getDirection();
        Float speed = getBall().getVelocity();
        getBall().setVelocity(speed + 1.0F * dt);
        pos.add(dir.times(speed * dt));
        setPosition(pos);
    }
    public void checkCollisions(Float top, Float bottom, Float left, Float right) {
        Vector2 pos = getPosition();
        Vector2 scl = getScale().times(0.5F);
        Vector2 dir = getDirection();

        top += scl.getY();
        bottom -= scl.getY();
        left += scl.getX();
        right -= scl.getX();

        if (pos.getX() < left || pos.getX() > right) {
            dir.setX(dir.getX() * -1);
        }

        if (pos.getY() < top || pos.getY() > bottom) {
            dir.setY(dir.getY() * -1);
        }

        if (pos.getY() > bottom) {
            sceneController.lose();
        }

        pos.setX(Math.clamp(pos.getX(), left, right));
        pos.setY(Math.clamp(pos.getY(), top, bottom));

        setPosition(pos);
        setDirection(dir);
    }

}
