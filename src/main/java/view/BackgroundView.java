package view;

import controller.BackgroundController;
import model.extra.Image;
import view.events.KeyL;
import view.events.MouseL;

import java.awt.*;

public class BackgroundView extends View {
    private final BackgroundController backgroundController;

    public BackgroundView(MouseL mouseL, KeyL keyL, BackgroundController backgroundController) {
        super(mouseL, keyL);
        this.backgroundController = backgroundController;
    }

    @Override
    void update() {

    }

    @Override
    void render(Graphics2D g2d) {
        Image image = backgroundController.getImage();
        g2d.drawImage(image.getImage(), 0, 0, GamePanel.width, GamePanel.height, null);
    }
}
