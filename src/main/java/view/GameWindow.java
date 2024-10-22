package view;

import controller.GameController;
import javazoom.jl.player.advanced.AdvancedPlayer;

import javax.swing.*;
import java.io.FileInputStream;
import java.util.Objects;

public class GameWindow extends JFrame {
    private final GamePanel gamePanel;

    public GameWindow(GameController gameController) {
        gamePanel = new GamePanel(gameController);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setUndecorated(true);
        this.setResizable(false);
        this.setTitle("Brick Breaker");
        this.add(gamePanel);
        this.pack();
    }

    public void start() {
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        gamePanel.exec();
    }
}
