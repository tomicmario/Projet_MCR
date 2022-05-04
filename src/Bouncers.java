/*
 -----------------------------------------------------------------------------------
 Lab          : 01
 File         : Bouncers.java
 Authors      : Lange Yanik, Mario Tomic
 Date         : 16/03/2022
 -----------------------------------------------------------------------------------
 */

import Entities.Direction;
import Entities.Entity;
import Entities.Player;
import View.GameDisplay;
import View.FullRenderer;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;


public class Bouncers {

    private static final LinkedList<Entity> entities = new LinkedList<>();
    private static final int REFRESH_TIME = 1000 / 60;
    private final GameDisplay gameDisplay;
    private final Player p;

    /**
     * Initialises the class and adds a key
     */
    public Bouncers() {


        // Display
        gameDisplay = GameDisplay.getInstance();
        gameDisplay.setTitle("Not A Space Invader");

        p = new Player(new FullRenderer());
        entities.add(p);
        // Key handling
        gameDisplay.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()){
                    case KeyEvent.VK_Q: // Q
                        System.exit(0);
                        break;
                    case KeyEvent.VK_W: // W
                        p.setYDirection(Direction.UP);
                        break;
                    case KeyEvent.VK_A: // A
                        p.setXDirection(Direction.LEFT);
                        break;
                    case KeyEvent.VK_S: // S
                        p.setYDirection(Direction.DOWN);
                        break;
                    case KeyEvent.VK_D: // D
                        p.setXDirection(Direction.RIGHT);
                        break;
                }
            }
        });

        gameDisplay.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()){
                    case KeyEvent.VK_W: // W
                    case KeyEvent.VK_S: // S
                        p.setYDirection(Direction.STILL);
                        break;
                    case KeyEvent.VK_A: // A
                    case KeyEvent.VK_D: // D
                        p.setXDirection(Direction.STILL);
                        break;
                }
            }
        });
    }

    /**
     * Moves the state of the bouncers and displays them
     */
    public void run() {
        ActionListener al = event -> {
            gameDisplay.repaint();
            for(Entity b : entities) {
                b.move();
                b.draw();
            }
        };
        Timer timer = new Timer(REFRESH_TIME, al);
        timer.start();
    }

    public static void main(String ... args) {
        new Bouncers().run();
    }

}
