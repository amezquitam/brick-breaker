package model.extra;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Image {
    private final BufferedImage image;
    public Image(String image) {
        try {
            this.image = ImageIO.read(new File(getClass().getClassLoader().getResource(image).getFile()));
        } catch (IOException err) {
            err.printStackTrace();
            throw new RuntimeException("Error while reading image: " + image);
        }
    }

    public BufferedImage getImage() {
        return image;
    }
}
