package view;

import controller.BrickController;
import view.events.KeyL;
import view.events.MouseL;

import java.awt.*;

public class BrickView extends View {
    private final BrickController brickController;

    public BrickView(MouseL mouseL, KeyL keyL, BrickController brickController) {
        super(mouseL, keyL);
        this.brickController = brickController;
    }

    @Override
    void update() {
        super.update();
        brickController.checkCollisions();
        brickController.updatePositions(getDelta());
    }

    @Override
    void render(Graphics2D g2d) {
        brickController.getDrawableBricks(GamePanel.height).forEach(brick -> {
            var transform = brick.transform();
            var position = transform.getPosition();
            var scale = transform.getScale();
            var image = brick.image();
            g2d.drawImage(
                    image.getImage(),
                    (int) position.getX(),
                    (int) position.getY(),
                    (int) scale.getX(),
                    (int) scale.getY(),
                    null);

            if (brick.state().getCollisionTimes() > 0) {
                int alpha = (int) ((float) brick.state().getCollisionTimes() / brick.state().getMaxCollisionTimes() * 200);
                g2d.setColor(new Color(255, 65, 75, alpha));
                g2d.fillRect(
                        (int) position.getX(),
                        (int) position.getY(),
                        (int) scale.getX(),
                        (int) scale.getY());
            }
        });
    }
}
