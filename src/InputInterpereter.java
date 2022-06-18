import GameObjects.Entities.Player.Direction;
import GameObjects.Entities.Player.Player;
import View.Displayer;

import javax.swing.event.MouseInputAdapter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class InputInterpereter {
    private final Displayer gameDisplay;
    private final Player p;

    public InputInterpereter(Player p, Displayer d){
        this.p = p;
        this.gameDisplay = d;
    }

    public void InitialiseInputListeners(){
        gameDisplay.addMouseMotionListener(new MouseInputAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                p.setMousePosition(e.getX(), e.getY());
            }

            @Override
            public void mouseDragged(MouseEvent e){
                p.setMousePosition(e.getX(), e.getY());
            }
        });

        gameDisplay.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()){
                    case KeyEvent.VK_Q: // Q
                        p.equipPreviousWeapon();
                        break;
                    case KeyEvent.VK_W: // W
                        p.setDirection(Direction.UP);
                        break;
                    case KeyEvent.VK_A: // A
                        p.setDirection(Direction.LEFT);
                        break;
                    case KeyEvent.VK_S: // S
                        p.setDirection(Direction.DOWN);
                        break;
                    case KeyEvent.VK_D: // D
                        p.setDirection(Direction.RIGHT);
                        break;
                    case KeyEvent.VK_E:
                        p.equipNextWeapon();
                        break;
                    case KeyEvent.VK_ESCAPE:
                        System.exit(0);
                        break;
                }
            }
        });

        gameDisplay.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()){
                    case KeyEvent.VK_W: // W
                        p.unsetDirection(Direction.UP);
                        break;
                    case KeyEvent.VK_A: // A
                        p.unsetDirection(Direction.LEFT);
                        break;
                    case KeyEvent.VK_S: // S
                        p.unsetDirection(Direction.DOWN);
                        break;
                    case KeyEvent.VK_D: // D
                        p.unsetDirection(Direction.RIGHT);
                        break;
                }
            }
        });
    }
}
