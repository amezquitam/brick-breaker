package view;

import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.GameController;

public class GameView {
    private static GraphicsDevice gDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
    private final JFrame window;
    private final List<View> views;
    private final BackgroundView backgroundView;

    public GameView(GameController gameController) {
        this.window = new JFrame();
        this.views = List.of();
        this.backgroundView = new BackgroundView(gameController.getBackgroundController());
    }

    public void run() {
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        //gDevice.setFullScreenWindow(window);

        JPanel gamePanel = new JPanel();

        gamePanel.setPreferredSize(new Dimension(500, 500));

        window.add(gamePanel);
        
        window.pack();

        while (window.isVisible()) {
            backgroundView.update(gamePanel);
            
            for (var view : views) {
                view.update(gamePanel);
            }

            try {
                Thread.sleep(34);
            } catch (InterruptedException err) {
                err.printStackTrace();
            }
        }
    }
    
}
