/*
 -----------------------------------------------------------------------------------
 Lab          : 01
 File         : Bouncers.java
 Authors      : Lange Yanik, Mario Tomic
 Date         : 16/03/2022
 -----------------------------------------------------------------------------------
 */

import GameObjects.Entities.Enemy.Grunt;
import GameObjects.Entities.Enemy.Sniper;
import GameObjects.Entities.Player.Direction;
import GameObjects.Entities.Entity;
import GameObjects.Entities.Player.Player;
import GameObjects.Weapons.Projectile;
import View.GameDisplay;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;


public class Controller {

    private static final LinkedList<Entity> entities = new LinkedList<>();
    private static final LinkedList<Projectile> projectiles = new LinkedList<>();
    private static final int REFRESH_TIME = 1000 / 60;
    private final GameDisplay gameDisplay;
    private final Player p;
    private final int WIDTH = 500;
    private final int HEIGHT = 500;

    /**
     * Initialises the class and adds a key
     */
    public Controller() {


        // Display
        gameDisplay = GameDisplay.getInstance();
        gameDisplay.setTitle("Not A Space Invader");
        gameDisplay.setPanelSize(new Dimension(WIDTH, HEIGHT));

        p = new Player(WIDTH/2, HEIGHT / 2);
        entities.add(p);
        entities.add(new Grunt(0,0,p));
        entities.add(new Sniper(300, 300, p));


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
                    case KeyEvent.VK_E:
                        p.equipNextWeapon();
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
            if(gameDisplay.isClick()){
                Projectile[] proj = p.attack();
                for(Projectile p: proj){
                    projectiles.add(p);
                }
            }
            for(Entity b : entities) {
                b.move();
                correctPosition(b);
                b.draw(gameDisplay);
            }
            for(Projectile p : projectiles) {
                p.move();
                p.draw(gameDisplay);
            }
        };
        Timer timer = new Timer(REFRESH_TIME, al);
        timer.start();
    }

    private void correctPosition(Entity e){
        if(e.getX() >= WIDTH - e.getSize() || e.getX() <= 0) {
            e.setX(e.getX() <= 0 ? 0 : WIDTH - e.getSize());
        }
        if(e.getY() >= HEIGHT - e.getSize() || e.getY() <= 0) {
            e.setY(e.getY() <= 0 ? 0 : HEIGHT - e.getSize());
        }
    }

    public static void main(String ... args) {
        new Controller().run();
    }

}
