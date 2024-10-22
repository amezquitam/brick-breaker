package view.events;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class KeyL implements KeyListener {
    private final Map<Integer, List<Consumer<Void>>> kls;

    public KeyL() {
        kls = new HashMap<>();
    }

    public void addKeyListener(Integer key, Consumer<Void> consumer) {
        var prevListeners = kls.computeIfAbsent(key, k -> new ArrayList<>());
        prevListeners.add(consumer);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        var actions = kls.get(e.getKeyCode());
        if (actions != null)
            actions.forEach(action -> action.accept(null));
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
        System.out.println(KeyEvent.VK_SPACE);

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
