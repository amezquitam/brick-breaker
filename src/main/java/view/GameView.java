package view;

import controller.GameController;
import controller.SceneController;
import view.events.KeyL;
import view.events.MouseL;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class GameView extends View {
    private final List<View> otherViews;
    private final GameController gameController;
    private final SceneController sceneController;
    private final GamePanel gamePanel;
    private Boolean paused;

    public GameView(MouseL mouseL, KeyL keyL, GamePanel gamePanel, GameController gameController, List<View> otherViews) {
        super(mouseL, keyL);
        this.otherViews = otherViews;
        this.gameController = gameController;
        this.sceneController = gameController.getSceneController();
        this.gamePanel = gamePanel;
        this.paused = false;
        keyL.addKeyListener(
                KeyEvent.VK_SPACE,
                v -> setPaused(!isPaused()));
    }

    @Override
    void update() {
        super.update();
        boolean paused = false;

        while (isPaused()) {
            paused = true;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        if (paused) {
            for (var view : otherViews) {
                view.resetTimer();
            }
        }

        if (sceneController.isLoser()) {
            gameController.reset();
            gamePanel.init(gameController);
        }
    }

    @Override
    void render(Graphics2D g2d) {
        var sceneController = gameController.getSceneController();
        Integer level = sceneController.getCurrentLevel() + 1;
        Integer lives = sceneController.getRemainingLives();
        int left = GamePanel.width - 80;
        g2d.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 16));
        g2d.setColor(new Color(255, 255, 255));
        g2d.drawString("Level: %d".formatted(level), left, 30);
        g2d.drawString("Lives: %d".formatted(lives), left, 50);
    }

    public Boolean isPaused() {
        return paused;
    }

    public void setPaused(Boolean paused) {
        this.paused = paused;
    }
}
