package view;

import java.awt.Graphics2D;
import javax.swing.JPanel;

import controller.BackgroundController;
import model.extra.Image;

public class BackgroundView extends View {
    private final BackgroundController backgroundController;
    private Image drawedImage;

    public BackgroundView(BackgroundController backgroundController) {
        this.backgroundController = backgroundController;
    }

    @Override
    void update(JPanel panel) {
        Image image = backgroundController.getImage();
        if (drawedImage != image) {
            Graphics2D g2d = (Graphics2D) panel.getGraphics();
            g2d.drawImage(image.getImage(), 0, 0, panel.getWidth(), panel.getWidth(), null);
            drawedImage = image;
        }
    }
}
