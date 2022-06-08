package GameObjects.Entities.Enemy;

import GameObjects.Entities.Enemy.Behaviour.Behaviour;
import GameObjects.Entities.Player.Player;
import GameObjects.Entities.EntityRenderer;
import GameObjects.Entities.Entity;
import GameObjects.Weapons.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;


/**
 * Abstract class defining the Enemies of the game. Inherits of Entity.
 */
public abstract class Enemy extends Entity {
    private static final int SIZE = 30;
    protected final Player p;
    protected boolean canShoot;
    protected final int points;
    protected Behaviour[] behaviours;
    protected int currentBehaviourIndex = 0;

    /**
     * Enemy Constructor. Used to initialize common values of all
     * classes that inherits of Enemy.
     * @param x : Position x of the enemy.
     * @param y : Position y of the enemy.
     * @param maxHealth : Maximum health of the enemy.
     * @param points : Value of points of the enemy the player gets when killed.
     * @param p : Player of the game used so the enemy will track it down TODO ??
     */
    protected Enemy(int x, int y, int maxHealth, int points, Player p) {
        super(x, y, SIZE, maxHealth, new EntityRenderer());
        this.p = p;
        this.canShoot = true;
        this.points = points;
    }


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

    protected void setAngle(){
        angle = Math.atan2(p.getY() - y, p.getX() - x);
    }

    @Override
    public void move() {
        checkBehaviourChanged();
        setAngle();
        currentWeapon.nextFrame();
        behaviours[currentBehaviourIndex].move();
    }

    protected abstract void checkBehaviourChanged();

    @Override
    public Shape getShape() {
        return new Ellipse2D.Double(x, y, size, size);
    }

    @Override
    public Projectile[] attack() {
        if(canShoot) {
            return currentWeapon.fire(x, y, p.getX(), p.getY());
        }

        return null;
    }

    @Override
    public int getPointsWhenKilled(){
        return points;
    }

}
