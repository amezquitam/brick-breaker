package view;

import view.events.KeyL;
import view.events.MouseL;

import java.awt.*;

public abstract class View {
    private long elapsed;
    private long lastTime;
    protected final MouseL mouseL;
    protected final KeyL keyL;

    public View(MouseL mouseL, KeyL keyL) {
        this.keyL = keyL;
        this.mouseL = mouseL;
        lastTime = System.nanoTime();
    }

    void update() {
        elapsed = System.nanoTime() - lastTime;
        lastTime = System.nanoTime();
    }

    abstract void render(Graphics2D g2d);

    // time elapsed since last update in nano seconds
    public long getElapsed() {
        return elapsed;
    }

    public float getDelta() {
        return (float) getElapsed() / 1_000_000_000;
    }

    protected void resetTimer() {
        lastTime = System.nanoTime();
    }
}
