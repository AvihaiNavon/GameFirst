package inputs;

import main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInputs implements KeyListener {
    private GamePanel panel;

    public KeyboardInputs(GamePanel panel) {
        this.panel=panel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){

            case KeyEvent.VK_A :
                panel.changeXDelta(-5);
                break;

            case KeyEvent.VK_D :
                panel.changeXDelta(5);
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
