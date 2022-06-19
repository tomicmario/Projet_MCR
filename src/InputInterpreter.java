/*
 -----------------------------------------------------------------------------------
 Lab          : 03 (Projet)
 File         : InputInterpreter.java
 Authors      : Janis Chiffelle, Yanik Lange, Mario Tomic
 Date         : 18/06/2022
 -----------------------------------------------------------------------------------
 */

import GameObjects.Entities.Player.Direction;
import GameObjects.Entities.Player.Player;
import View.Displayer;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;


/**
 * InputInterpreter class. Used to handle all the inputs of the game.
 */
public class InputInterpreter {
    private final Displayer gameDisplay;
    private final Player p;

    /**
     * InputInterpreter Constructor. Used to instanciate an InputInterpreter.
     *
     * @param p : The player on which we apply the modifications depending on the inputs.
     * @param d : The display on which we apply the modifications depending on the inputs.
     */
    public InputInterpreter(Player p, Displayer d){
        this.p = p;
        this.gameDisplay = d;
    }

    /**
     * Initialise the input listener for every input needed. // TODO
     */
    public void InitialiseInputListeners(){

        /**
         * Listens of the movement of the mouse.
         */
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

        /**
         *  Listens if a keyboard key is pressed.
         */
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

        /**
         * Listens  if a keyboard key is released.
         */
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
