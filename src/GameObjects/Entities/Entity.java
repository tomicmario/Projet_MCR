package GameObjects.Entities;

import GameObjects.Renderer;
import GameObjects.Weapons.Projectile;
import GameObjects.Weapons.BaseWeapon;
import View.Displayer;
import java.awt.*;
import java.awt.Shape;

/**
 *  Abstract Entity class. Defining all entities of our game.
 */
public abstract class Entity {

    protected int x;
    protected int y;
    protected int size;
    protected double angle = 0;
    protected Renderer renderer;
    protected int health;
    protected final int MAX_HEALTH;
    protected int speed;
    protected BaseWeapon currentWeapon;

    /**
     * Entity Constructor. Used to initialize common values of all
     * classes that inherits of Entity.
     * @param x : Position x of the entity.
     * @param y : Position y of the entity.
     * @param size : Size of the entity.
     * @param maxHealth : Maximum health of the entity.
     * @param r : Renderer used to render the entity on the game.
     */
    protected Entity(int x, int y, int size, int maxHealth, Renderer r){
        this.x = x;
        this.y = y;
        this.size = size;
        this.MAX_HEALTH = maxHealth;
        renderer = r;
        health = MAX_HEALTH;
        speed = 2;
    }

    /**
     *  Displays the entity on the game.
     * @param view
     */
    public void draw(Displayer view) {
        renderer.display(view.getGraphics(), this);
    }

    /**
     *
     * @return The size of the entity.
     */
    public int getSize(){
        return size;
    }

    /**
     *
     * @return The angle of the speed vector of the entity.
     */
    public double getAngle(){
        return angle;
    }

    /**
     *
     * @return The position y of the entity.
     */
    public int getY(){
        return y;
    }

    /**
     *
     * @return The position x of the entity.
     */
    public int getX(){
        return x;
    }

    /**
     *
     * @param x : The position x of the entity we want to set.
     */
    public void setX(int x){
        this.x = x;
    }

    /**
     *
     * @param y : The position y of the entity we want to set.
     */
    public void setY(int y){
        this.y = y;
    }

    /**
     * Does damage on the entity, reducing his health by the damage
     * given as argument on the method.
     *
     * @param damage : The damage dealt to the entity.
     */
    public void damage(int damage){
        this.health -= damage;
    }

    /**
     *
     * @return The ratio of health of the entity.
     */
    public double getHealthRatio(){
        return (double)health / MAX_HEALTH;
    }

    /**
     *
     * @return True if the entity alive and False if death.
     */
    public boolean isAlive(){
        return health > 0;
    }

    /**
     * Attack function redefined in the classes that inherits of Entity.
     *
     * @return An array containing all the projectiles used during the attack.
     */
    public abstract Projectile[] attack();

    /**
     * Move function redefined in the classes that inherits of Entity.
     * Moves the current entity on the game.
     */
    public abstract void move();

    /**
     * Getter of color used in the classes that inherits of Entity.
     *
     * @return The color of the entity.
     */
    public abstract Color getColor();

    /**
     * Getter of shape used in the classes that inherits of Entity.
     *
     * @return The shape of the entity.
     */
    public abstract Shape getShape();

    /**
     * Returns the number of points the entity is valued when killed
     *
     * @return The value of points of the entity when killed.
     */
    public abstract int getPointsWhenKilled();
}
