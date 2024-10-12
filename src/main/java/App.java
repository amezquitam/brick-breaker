
import config.GameConfig;
import controller.GameController;
import view.GameView;

public class App {
    public static void main(String[] args) throws Exception {
        GameController gameController = new GameController(GameConfig.get());
        GameView gameView = new GameView(gameController);
        gameView.run();
    }
}
