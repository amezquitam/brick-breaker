package view;

import java.time.Duration;
import javax.swing.JPanel;

public abstract class View {
    protected final Duration elapsed;
    
    public View() {
        elapsed = Duration.ZERO;
    }

    abstract void update(JPanel frame);
}
