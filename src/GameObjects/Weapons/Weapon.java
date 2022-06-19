/*
 -----------------------------------------------------------------------------------
 Lab          : 03 (Projet)
 File         : Weapon.java
 Authors      : Janis Chiffelle, Yanik Lange, Mario Tomic
 Date         : 18/06/2022
 -----------------------------------------------------------------------------------
 */

package GameObjects.Weapons;

import GameObjects.Entities.Entity;
import java.awt.*;

/**
 * Weapon abstract class, serving as the basis of all the weapons. Stores the different attributes of a weapon, such
 * as the fire rate, the size and damage of the projectiles. Handles the fire rate of the weapon. If a weapon can
 * shoot, the weapon will return an array of projectiles that will be handled by the controller.
 *
 * @author Mario Tomic
 * @date 04.05.2022
 * @version Java 11
 */
public abstract class Weapon{
    protected Entity e;
    protected int counter;
    protected int projectileSize;
    protected int fireRate;
    protected int projectileSpeed;
    protected int projectileTimeToLive;
    protected boolean persistentProjectile;
    protected int damage;

    /**
     * Constructor of the class
     * @param e Owner of the weapon
     */
    protected Weapon(Entity e){
        this.e = e;
        fireRate = 20;
        projectileSize = 4;
        projectileSpeed = 5;
        damage = 25;
        persistentProjectile = false;
        projectileTimeToLive = 300;
    }

    /**
     * Decrements the counter for the fire rate. Used to avoid being able to shoot weapons instantly if switched to.
     */
    public void nextFrame() {
        if(counter > 0){
            counter--;
        }
    }

    /**
     * Generates an array of projectiles if the weapon can shoot
     * @param currentX X coordinate of the shooter
     * @param currentY Y coordinate of the shooter
     * @param targetX X coordinate of the target
     * @param targetY Y coordinate of the target
     * @return Array of projectile if the weapon can shoot, null otherwise
     */
    public Projectile[] fire(int currentX, int currentY, int targetX, int targetY){
        if(counter == 0){
            counter = fireRate;
            double angle = Math.atan2(targetY - currentY, targetX - currentX) - Math.PI / 4;
            return generateProjectiles(angle);
        }
        return null;
    }

    /**
     * Sets an additional delay for a weapon to shoot. Used for enemies when they spawn.
     * @param delay Amount of ticks delaying the shot
     */
    public void setDelay(int delay){
        counter += delay;
    }

    /**
     * Generates the projectiles for when the weapon shoots
     * @param angle Angle of the shooter
     * @return new array of projectiles
     */
    protected Projectile[] generateProjectiles(double angle){
        return new Projectile[] { generateSingleProjectile(angle) };
    }

    /**
     * Generates a projectile
     * @param angle Angle of the entity shooting
     * @return new Projectile
     */
    protected Projectile generateSingleProjectile(double angle){
        return new Projectile(angle, projectileSpeed, projectileSize, damage, persistentProjectile, e, projectileTimeToLive);
    }

    /**
     * Returns the color of the weapon
     * @return color of the weapon
     */
    public abstract Color getColor();
}
