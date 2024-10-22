package view;

import config.GameConfig;
import controller.BallController;
import model.extra.Vector2;
import view.events.KeyL;
import view.events.MouseL;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BallView extends View {
    private final BallController ballController;

    public BallView(MouseL mouseL, KeyL keyL, BallController ballController) {
        super(mouseL, keyL);
        this.ballController = ballController;
        this.ballController.setPosition(
                new Vector2((float) GamePanel.width / 2, GamePanel.height - GameConfig.barPos - ballController.getScale().getY()));
    }

    @Override
    void update() {
        super.update();
        ballController.updatePosition(getDelta());
        ballController.checkCollisions(0.0F, (float) GamePanel.height, 0.0F, (float) GamePanel.width);
    }

    @Override
    void render(Graphics2D g2d) {
        Vector2 pos = ballController.getPosition();
        Vector2 scl = ballController.getScale();
        BufferedImage image = ballController.getImage().getImage();
        g2d.drawImage(
                image,
                (int) (pos.getX() - scl.getX() / 2),
                (int) (pos.getY() - scl.getY() / 2),
                (int) (scl.getX()),
                (int) (scl.getY()),
                null
        );
    }
}
