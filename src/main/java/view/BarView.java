package view;

import config.GameConfig;
import controller.BarController;
import model.extra.Vector2;
import view.events.KeyL;
import view.events.MouseL;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BarView extends View {
    private final BarController barController;

    public BarView(MouseL mouseL, KeyL keyL, BarController barController) {
        super(mouseL, keyL);
        this.barController = barController;
        this.barController.setBarPosY((float) GamePanel.height - GameConfig.barPos);
    }

    @Override
    void update() {
        int w = (int) (float) barController.getBarWidth();
        int midW = w / 2;
        int pos = Math.clamp(mouseL.getMouseX(), midW, GamePanel.width - midW);
        barController.setBarPos((float) pos);
        barController.checkCollisions();
    }

    @Override
    void render(Graphics2D g2d) {
        Vector2 pos = barController.getBarPos();
        BufferedImage image = barController.getImage().getImage();
        int w = (int) (float) barController.getBarWidth();
        int h = (int) (float) barController.getBarHeight();
        int midW = w / 2;
        int midH = h / 2;
        g2d.drawImage(image, (int) pos.getX() - midW, (int) pos.getY() - midH, w, h, null);
    }
}
