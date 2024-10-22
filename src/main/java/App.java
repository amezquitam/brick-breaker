import config.GameConfig;
import controller.GameController;
import view.GameWindow;

public class App {
    public static void main(String[] args) throws Exception {
        GameController gameController = new GameController(GameConfig.newConfig());
        GameWindow gameWindow = new GameWindow(gameController);
        gameWindow.start();
    }
}
