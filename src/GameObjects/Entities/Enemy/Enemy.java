package GameObjects.Entities.Enemy;

import GameObjects.Coordinates;
import GameObjects.Entities.Enemy.Behaviour.Behaviour;
import GameObjects.Entities.EntityRenderer;
import GameObjects.Entities.Entity;
import GameObjects.Weapons.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Abstract class defining the Enemies of the game. Inherits of Entity.
 *
 * @author Janis Chiffelle, Yanik Lange, Mario Tomic
 * @date 19.05.2022
 * @version Java 11
 */
public abstract class Enemy extends Entity {
    private static final int RADIUS = 15;
    protected final Coordinates target;
    protected boolean canShoot;
    protected final int points;
    protected Behaviour[] behaviours;
    protected int currentBehaviourIndex = 0;
    protected Behaviour behaviour = null;

    /**
     * Enemy Constructor. Used to initialize common values of all
     * classes that inherits of Enemy.
     *
     * @param x : Position x of the enemy.
     * @param y : Position y of the enemy.
     * @param maxHealth : Maximum health of the enemy.
     * @param points : Value of points of the enemy the player gets when killed.
     * @param target : The coordinates of the target on which the enemy will focus his attacks.
     */
    protected Enemy(int x, int y, int maxHealth, int points, Coordinates target){
        super(x, y, RADIUS, maxHealth, new EntityRenderer());
        this.target = target;
        this.canShoot = true;
        this.points = points;
        defineBehaviours();
        if(behaviour == null){
            throw new RuntimeException("An enemy must have a behaviour");
        }
    }

    /**
     * Defines an array containing all the possible behaviours of the enemy
     */
    protected abstract void defineBehaviours();


    /**
     *
     * @param x : The x position of the enemy to be set.
     * @param y : The y position of the enemy to be set.
     */
    public void setCoordinates(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     *
     * @return The speed of the enemy.
     */
    public int getSpeed(){
        return speed;
    }

    /**
     *
     * @param x : The position x of the enemy we want to set.
     */
    public void setX(int x){
        this.x = x;
    }

    /**
     *
     * @param y : The position y of the enemy we want to set.
     */
    public void setY(int y){
        this.y = y;
    }

    /**
     * Sets if an enemy can shoot or not.
     *
     * @param canShoot : the boolean value to set if the enemy can shoot or not.
     */
    public void setCanShoot(boolean canShoot){
        this.canShoot = canShoot;
    }

    /**
     * Sets the angle for the entity used to move to (used in move()).
     */
    protected void setAngle(){
        angle = Math.atan2(target.getY() - y, target.getX() - x);
    }

    @Override
    public Projectile[] attack(){
        if(canShoot) {
            return weapon.fire(x, y, target.getX(), target.getY());
        }

        return null;
    }

    @Override
    public void move(){
        checkBehaviourChanged();
        setAngle();
        weapon.nextFrame();
        behaviour.move();
    }

    @Override
    public Shape getShape(){
        return new Ellipse2D.Double(x, y, radius * 2, radius * 2);
    }

    @Override
    public int getPointsWhenKilled(){
        return points;
    }

    /**
     * Function Redefined in the classes that inherits of Enemy.
     * Checks the current behaviour of the enemy depending of his health.
     * For example if the sniper has not full health, he will have a distant behaviour,
     * if the tank has less than half his healt, he will get coward, and then heal himself.
     *
     */
    protected abstract void checkBehaviourChanged();
}
