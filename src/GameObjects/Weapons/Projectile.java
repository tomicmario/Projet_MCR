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
    protected final Entity shooter;
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
    public Projectile(double angle, int speed, int radius, int damage, boolean persistent, Entity e, int timeToLive) {
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


    public void setInactive(){
        timeToLive = 0;
    }

    public boolean isActive(){
        return timeToLive > 0;
    }

    public int getDamage(){
        return damage;
    }

    public Entity getShooter(){
        return shooter;
    }

    public boolean isPersistent() {
        return persistent;
    }
}
