package view.events;

import java.util.function.Consumer;

public class KL {
    final private int key;
    final private Consumer<Void> func;

    public KL(int key, Consumer<Void> func) {
        this.key = key;
        this.func = func;
    }

    public int getKey() {
        return key;
    }

    public Consumer<Void> getFunc() {
        return func;
    }
}
