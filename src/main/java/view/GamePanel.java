package view;

import controller.GameController;
import javazoom.jl.player.advanced.AdvancedPlayer;
import view.events.KeyL;
import view.events.MouseL;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.util.*;
import java.util.List;
import java.util.Timer;

public class GamePanel extends JPanel {
    public static final Integer width = 800;
    public static final Integer height = 600;
    public static final Integer FPS = 60;
    private List<View> views;
    private Thread soundPlayer;

    public GamePanel(GameController gameController) {
        init(gameController);
    }

    public void init(GameController gameController) {
        MouseL mouseL = new MouseL();
        KeyL keyL = new KeyL();
        this.setPreferredSize(new Dimension(width, height));
        this.setDoubleBuffered(true);
        this.addMouseMotionListener(mouseL);
        this.addKeyListener(keyL);

        if (soundPlayer != null) {
            soundPlayer.interrupt();
        }

        soundPlayer = new Thread(() -> {
            try {
                FileInputStream fileInputStream = new FileInputStream(
                        Objects.requireNonNull(getClass().getResource("/soundtracks/eien-no-akuruhi.mp3"))
                                .getFile());
                AdvancedPlayer player = new AdvancedPlayer(fileInputStream);
                player.play(1850, 5000);

            } catch (Exception e) {
                System.out.println("Error al reproducir el archivo MP3.");
            }
        });


        soundPlayer.start();

        this.views = new ArrayList<>(List.of(
                new BackgroundView(mouseL, keyL, gameController.getBackgroundController()),
                new BallView(mouseL, keyL, gameController.getBallController()),
                new BarView(mouseL, keyL, gameController.getBarController()),
                new BrickView(mouseL, keyL, gameController.getBrickController())));

        this.views.add(new GameView(mouseL, keyL, this, gameController, List.copyOf(this.views)));
    }

    public void exec() {
        Timer timer = new Timer();
        GamePanel thisGame = this;
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                thisGame.update();
            }
        }, 0, 1_000 / FPS);
    }

    public void update() {
        updateComponents();
        repaint();
    }

    public void updateComponents() {
        for (View view : views) {
            view.update();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        for (View view : views) {
            view.render(g2d);
        }
        g2d.dispose();
    }
}
