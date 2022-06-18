package GameObjects.Weapons;

import GameObjects.Entities.Entity;
import View.Displayer;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * It's what the weapons shoot. All projectile has an owner attached to them, in order to avoid the projectile to
 * collide immediately with the shooter, leading to the shooter killing itself.
 *
 * @author Mario Tomic
 */
public class Projectile {
    protected final int SPEED;
    protected int speedX;
    protected int speedY;
    protected int x;
    protected int y;
    protected int radius;
    protected double angle;
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
        this.x = e.getX() + e.getRadius();
        this.y = e.getY() + e.getRadius();
        this.radius = radius;
        this.SPEED = speed;
        this.angle = angle;
        speedX = (int)(SPEED * Math.cos(angle) - SPEED * Math.sin(angle));
        speedY = (int)(SPEED * Math.sin(angle) + SPEED * Math.cos(angle));
        this.damage = damage;
        this.shooter = e;
        this.persistent = persistent;
        this.timeToLive = timeToLive;
    }

    public void nextFrame() {
        x += speedX;
        y += speedY;
        timeToLive--;
    }

    public Color getColor() {
        return Color.BLACK;
    }

    public Shape getShape() {
        return new Ellipse2D.Double(x, y, radius, radius);
    }

    public void draw(Displayer view) {
        display(view.getGraphics());
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    private void display(Graphics2D g) {
        g.setColor(getColor());
        g.fill(getShape());
        g.draw(getShape());
    }
    public void setInactive(){
        timeToLive = 0;
    }

    public boolean isActive(){
        return timeToLive > 0;
    }

    public int getRadius(){
        return radius;
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
