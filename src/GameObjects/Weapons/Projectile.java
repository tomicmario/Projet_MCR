/*
 -----------------------------------------------------------------------------------
 Lab          : 03 (Projet)
 File         : Projectile.java
 Authors      : Janis Chiffelle, Yanik Lange, Mario Tomic
 Date         : 18/06/2022
 -----------------------------------------------------------------------------------
 */

package GameObjects.Weapons;

import GameObjects.Entities.Entity;
import GameObjects.GameObject;
import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * It's what the weapons shoot. All projectile has an owner attached to them, in order to avoid the projectile to
 * collide immediately with the shooter, leading to the shooter killing itself.
 *
 * @author Mario Tomic
 */
public class Projectile extends GameObject {
    protected int speedX;
    protected int speedY;
    protected int damage;
    protected final GameObject shooter;
    protected boolean persistent;
    protected int timeToLive;

    /**
     * Projectile Constructor
     * @param angle Angle of the projectile
     * @param speed Speed of the projectile in units per ticks
     * @param radius Radius of the projectile in units
     * @param damage Damage dealt by the projectile to an entity on collisions
     * @param persistent Flag determining if a projectile becomes inactive on collision or not
     * @param e Entity shooting the projectile
     * @param timeToLive Amount of ticks before the projectile becomes inactive
     */
    public Projectile(double angle, int speed, int radius, int damage, boolean persistent, GameObject e, int timeToLive) {
        super(e.getX() + e.getRadius(), e.getY() + e.getRadius(), radius);
        this.speed = speed;
        this.angle = angle;
        speedX = (int)(speed * Math.cos(angle) - speed * Math.sin(angle));
        speedY = (int)(speed * Math.sin(angle) + speed * Math.cos(angle));
        this.damage = damage;
        this.shooter = e;
        this.persistent = persistent;
        this.timeToLive = timeToLive;
    }

    @Override
    public void move() {
        x += speedX;
        y += speedY;
        timeToLive--;
    }

    @Override
    public Color getColor() {
        return Color.BLACK;
    }

    @Override
    public Shape getShape() {
        return new Ellipse2D.Double(x, y, radius, radius);
    }


    /**
     * Sets the time to live of the projectile to 0, deactivating the projectile.
     */
    public void setInactive(){
        timeToLive = 0;
    }

    /**
     *
     * @return True if the projectile is still alive, false if not.
     */
    public boolean isActive(){
        return timeToLive > 0;
    }

    /**
     *
     * @return The damage dealt with the projectile.
     */
    public int getDamage(){
        return damage;
    }

    /**
     *
     * @return The entity that shoots the projectile.
     */
    public GameObject getShooter(){
        return shooter;
    }

    /**
     *
     * @return True if the projectile is still active after a collision, False if not.
     */
    public boolean isPersistent() {
        return persistent;
    }
}
