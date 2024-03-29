package GameObjects.Entities;

import GameObjects.Coordinates;
import GameObjects.GameObject;
import GameObjects.Renderer;
import GameObjects.Weapons.Projectile;
import GameObjects.Weapons.Weapon;
import View.Displayer;

/**
 *  Abstract Entity class. Defining all entities of our game.
 *
 * @author Janis Chiffelle, Yanik Lange, Mario Tomic
 * @date 24.05.2022
 * @version Java 11
 */
public abstract class Entity extends GameObject {
    protected Renderer renderer;
    protected int health;
    protected final int maxHealth;
    protected Weapon[] weapons;
    protected int currentWeaponIndex = 0;
    protected Weapon weapon;

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
        super(x, y, size);
        this.maxHealth = maxHealth;
        renderer = r;
        health = this.maxHealth;
        defineWeapons();
        if(weapon == null){
            throw new RuntimeException("An entity must have a weapon");
        }
    }

    /**
     * Defines an array containing all the possible weapons of the enemy
     */
    protected abstract void defineWeapons();

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

    @Override
    public void draw(Displayer view){
        renderer.display(view.getGraphics(), this);
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
        return (double)health / (double) maxHealth;
    }

    /**
     *
     * @return True if the entity alive and False if death.
     */
    public boolean isAlive(){
        return health > 0;
    }

    /**
     *
     * @return the current weapon used by the entity.
     */
    public Weapon getCurrentWeapon(){
        return weapon;
    }

    /**
     * Attack method redefined in the classes that inherits of Entity.
     *
     * @return An array containing all the projectiles used during the attack.
     */
    public abstract Projectile[] attack();

    /**
     *  get point method redefined in the classes that inherits of Entity.
     *
     * @return The value of points of the entity when killed.
     */
    public abstract int getPointsWhenKilled();

    /**
     * Returns the coordinates of the entity created via an anonymous class that implements the interface Coordinates.
     *
     * @return the coordinates of the entity.
     */
    public Coordinates getCoordinates(){
        return new Coordinates() {
            @Override
            public int getX() {
                return x;
            }

            @Override
            public int getY() {
                return y;
            }
        };
    }

}
