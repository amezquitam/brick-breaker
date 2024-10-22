package controller;

import config.GameConfig;
import model.Brick;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class BrickController {
    private final SceneController sceneController;
    private final BallController ballController;

    public BrickController(SceneController sceneController, BallController ballController) {
        this.sceneController = sceneController;
        this.ballController = ballController;
    }

    public List<Brick> getBricks() {
        return sceneController.getLevel().bricks();
    }

    public void checkCollisions() {
        var ballPos = ballController.getPosition();
        var ballScl = ballController.getScale().times(0.5F);
        var ballDir = ballController.getDirection();

        float ballTop = ballPos.getY() - ballScl.getY();
        float ballBottom = ballPos.getY() + ballScl.getY();
        float ballLeft = ballPos.getX() - ballScl.getX();
        float ballRight = ballPos.getX() + ballScl.getX();

        getCollisionalBricks().forEach(brick -> {
            var brickTransform = brick.transform();
            var brickPos = brickTransform.getPosition();
            var brickScl = brickTransform.getScale();

            float brickTop = brickPos.getY();
            float brickBottom = brickPos.getY() + brickScl.getY();
            float brickLeft = brickPos.getX();
            float brickRight = brickPos.getX() + brickScl.getX();

            float dTop = brickTop - ballBottom;
            float dBottom = ballTop - brickBottom;
            float dRight = ballLeft - brickRight;
            float dLeft = brickLeft - ballRight;

            var deltas = List.of(dTop, dBottom, dRight, dLeft);

            if (deltas.stream().allMatch(d -> d < 0)) {
                brick.state().increment();
                float minDelta = deltas.stream().max(Comparator.naturalOrder()).orElseThrow();
                if (minDelta == dTop) {
                    ballPos.setY(ballPos.getY() + dTop);
                    ballDir.setY(-Math.abs(ballDir.getY()));
                } else if (minDelta == dBottom) {
                    ballPos.setY(ballPos.getY() - dBottom);
                    ballDir.setY(Math.abs(ballDir.getY()));
                } else if (minDelta == dLeft) {
                    ballPos.setX(ballPos.getX() + dLeft);
                    ballDir.setX(-Math.abs(ballDir.getX()));
                } else {
                    ballPos.setX(ballPos.getX() - dRight);
                    ballDir.setX(Math.abs(ballDir.getX()));
                }
            }

            ballController.setPosition(ballPos);
            ballController.setDirection(ballDir);
        });

    }

    public void updatePositions(float dt) {
        getBrokenBricks().forEach(brick -> {
            var transform = brick.transform();
            var pos = transform.getPosition();

            brick.state().accelerateY(GameConfig.get().gravity() * dt);

            pos.setY(pos.getY() + brick.state().getVelocity() * dt);
            transform.setPosition(pos);
        });
    }

    public Stream<Brick> getDrawableBricks(Integer winHeight) {
        return getBricks().stream()
                .filter(b -> !b.state().isBroken() || b.transform().getPosition().getY() < winHeight);
    }

    private Stream<Brick> getCollisionalBricks() {
        return getBricks().stream().filter(b -> !b.state().isBroken());
    }

    private Stream<Brick> getBrokenBricks() {
        return getBricks().stream().filter(b -> b.state().isBroken());
    }
}
