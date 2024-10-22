package view.events;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseL implements MouseMotionListener {
    private int mouseX;
    private int mouseY;

    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }
}
