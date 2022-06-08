/*
 -----------------------------------------------------------------------------------
 Lab          : 01
 File         : Bouncers.java
 Authors      : Lange Yanik, Mario Tomic
 Date         : 16/03/2022
 -----------------------------------------------------------------------------------
 */

import GameObjects.Entities.Enemy.*;
import GameObjects.Entities.Entity;
import GameObjects.Entities.Player.Player;
import GameObjects.Weapons.Projectile;
import View.GameDisplay;
import View.GameOverScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;


public class Controller {

    private static final LinkedList<Entity> entities = new LinkedList<>();
    private static final LinkedList<Projectile> projectiles = new LinkedList<>();
    private static final int REFRESH_TIME = 1000 / 60;
    private final GameDisplay gameDisplay;
    private final Player p;
    public final static int WIDTH = 500;
    public final static int HEIGHT = 500;
    private final SpawnDirector sd;
    private int score = 0;


    public Controller() {
        gameDisplay = GameDisplay.getInstance();
        gameDisplay.setTitle("Not A Space Invader");
        gameDisplay.setPanelSize(new Dimension(WIDTH, HEIGHT));

        p = new Player(WIDTH/2, HEIGHT / 2);
        sd = new SpawnDirector(entities, new EnemyFactory(0, 0, WIDTH, HEIGHT, p));
        entities.add(p);

        new InputInterpereter(p, gameDisplay).InitialiseInputListeners();
    }

    public void run() {
        ActionListener al = event -> {
            gameDisplay.repaint();
            getEntitiesNextFrame();
            getProjectileNextFrame();
            removeDeadObjects();
            sd.nextFrame();
            if(!p.isAlive()){
                endGame(event);
            }
        };

        Timer timer = new Timer(REFRESH_TIME, al);
        timer.start();

    }

    private void endGame(ActionEvent event){
        new GameOverScreen(score);
        ((Timer)event.getSource()).stop();
        gameDisplay.close();
    }

    private void getEntitiesNextFrame(){
        p.setMouseClicked(gameDisplay.isMouseClicked());

        for(Entity e : entities) {
            e.move();
            correctPosition(e);
            e.draw(gameDisplay);
            Projectile[] p = e.attack();
            if(p != null){
                projectiles.addAll(Arrays.asList(p));
            }
        }
    }

    private void getProjectileNextFrame(){
        for(Projectile p : projectiles) {
            p.move();
            p.draw(gameDisplay);
            checkProjectileCollision(p);
        }
    }

    private void checkProjectileCollision(Projectile p){
        for (Entity e : entities) {
            if(e != p.getShooter() && checkCollision(p, e)) {
                e.damage(p.getDamage());
                if(!p.isPersistent()) {
                    p.setActive(false);
                    break;
                }
            }
        }
    }

    private void removeDeadObjects(){
        Iterator<Entity> it = entities.iterator();
        while (it.hasNext()) {
            Entity entity = it.next();
            if (!entity.isAlive()) {
                score += entity.getPointsWhenKilled();
                it.remove();
            }
        }

        projectiles.removeIf(projectile -> !projectile.isActive());
    }


    private boolean checkCollision(Projectile p, Entity e){
        int x1 = p.getX() + p.getSize() / 2;
        int y1 = p.getY() + p.getSize() / 2;
        int x2 = e.getX() + e.getSize() / 2;
        int y2 = e.getY() + e.getSize() / 2;
        double distance = Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));

        return distance < p.getSize() / 2.0 + e.getSize() / 2.0;
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
