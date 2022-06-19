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


/**
 * Controller class. Creates a controller that manages all the game (all game objects, the displayer,  the score ...)
 *
 * @author Janis Chiffelle, Yanik Lange, Mario Tomic
 * @date 04.05.2022
 * @version Java 11
 */
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
    private final int TICKS_UNTIL_END = 120;
    private int endCounter = TICKS_UNTIL_END;

    /**
     * Controller constructor. Initializing the game display/window, the player , the spawnDirector managing
     * the enemy spawn, the inputInterpreter managing the inputs of the game
     */
    public Controller() {
        gameDisplay = GameDisplay.getInstance();
        gameDisplay.setTitle("Not A Space Invader");
        gameDisplay.setPanelSize(new Dimension(WIDTH, HEIGHT));

        p = new Player(WIDTH/2, HEIGHT / 2);
        sd = new SpawnDirector(entities, new EnemyFactory(0, 0, WIDTH, HEIGHT, p.getCoordinates()));
        entities.add(p);
        new InputInterpreter(p, gameDisplay).InitialiseInputListeners();
    }

    /**
     * Run method. Runs the game.
     */
    public void run() {
        ActionListener al = event -> {
            gameDisplay.repaint();
            entitiesNextTick();
            projectilesNextTick();
            removeDeadObjects();
            gameDisplay.getGraphics().drawString("Score : " + score, WIDTH - 100, HEIGHT - 10);
            sd.nextTick();
            if(!p.isAlive()){
                endGame(event);
            }
        };

        Timer timer = new Timer(REFRESH_TIME, al);
        timer.start();

    }

    /**
     * Sets the end of the game once the player lost.
     *
     * @param event : Event we stop once the game has ended.
     */
    private void endGame(ActionEvent event){
        if(endCounter > 0){
            endCounter--;
            gameDisplay.getGraphics().drawString("GAME OVER", WIDTH / 2 - 50, HEIGHT / 2 - 10);
        } else {
            new GameOverScreen(score);
            ((Timer) event.getSource()).stop();
            gameDisplay.close();
        }
    }

    /**
     * Draws the entities on the next frame  after they moved on the display/window.
     */
    private void entitiesNextTick(){
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

    /**
     *  Draws the projectile next frame after they moved.
     */
    private void projectilesNextTick(){
        for(Projectile p : projectiles) {
            p.move();
            p.draw(gameDisplay);
            manageProjectileCollisions(p);
        }
    }

    /**
     * Checks if a projectile is in colision with an entity, deals the damage on the entity
     * and deactivate the projectile if it is not persisten.
     *
     * @param p : The projectile we want to check on colisions
     */
    private void manageProjectileCollisions(Projectile p){
        for (Entity e : entities) {
            if(e != p.getShooter() && checkCollision(p, e)) {
                e.damage(p.getDamage());
                if(!p.isPersistent()) {
                    p.setInactive();
                    break;
                }
            }
        }
    }

    /**
     * Adds the score for the dead entities and remove them from the display/window.
     */
    private void removeDeadObjects(){
        Iterator<Entity> it = entities.iterator();
        while (it.hasNext()) {
            Entity entity = it.next();
            if (!entity.isAlive()) {
                if(p.isAlive()) {
                    score += entity.getPointsWhenKilled();
                }
                it.remove();
            }
        }

        projectiles.removeIf(projectile -> !projectile.isActive());
    }

    /**
     * Check collisions between projectiles and entities.
     *
     * @param p : The projectile that is supposed to collide the entity.
     * @param e : The entity to check if it is collided by a projectile.
     * @return True if the projectile collided an entity, False if not.
     */
    private boolean checkCollision(Projectile p, Entity e){
        int x1 = p.getX() + p.getRadius();
        int y1 = p.getY() + p.getRadius();
        int x2 = e.getX() + e.getRadius();
        int y2 = e.getY() + e.getRadius();
        double distance = Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));

        return distance < p.getRadius() + e.getRadius();
    }

    /**
     * Corrects the position of an entity so it doesn't go out the display/window.
     *
     * @param e : The entity we are checking the position on.
     */
    private void correctPosition(Entity e){
        if(e.getX() < 0) {
            e.setX(0);
        } else if (e.getX() >= WIDTH - 2 * e.getRadius()){
            e.setX(WIDTH - 2 * e.getRadius());
        }
        if(e.getY() < 0) {
            e.setY(0);
        } else if (e.getY() >= HEIGHT - 2 * e.getRadius()){
            e.setY(HEIGHT - 2 * e.getRadius());
        }
    }

    public static void main(String ... args) {
        new Controller().run();
    }

}
