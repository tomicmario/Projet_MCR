package GameObjects.Weapons;

import GameObjects.Entities.Entity;
import View.Displayer;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Projectile {
    protected final int SPEED;
    protected int speedX;
    protected int speedY;
    protected int x;
    protected int y;
    protected int size;
    protected double angle;
    protected boolean isActive;
    protected int damage;
    protected final Entity shooter;
    protected boolean persistent;
    protected int timeToLive;

    public Projectile(double angle, int speed, int size, int damage, boolean persistent, Entity e, int timeToLive) {
        this.x = e.getX();
        this.y = e.getY();
        this.size = size;
        this.SPEED = speed;
        this.angle = angle;
        speedX = (int)(SPEED * Math.cos(angle) - SPEED * Math.sin(angle));
        speedY = (int)(SPEED * Math.sin(angle) + SPEED * Math.cos(angle));
        this.damage = damage;
        isActive = true;
        this.shooter = e;
        this.persistent = persistent;
        this.timeToLive = timeToLive;
    }

    public Projectile(double angle, int speed, int size, int damage, boolean persistent, Entity e) {
        this.x = e.getX();
        this.y = e.getY();
        this.size = size;
        this.SPEED = speed;
        this.angle = angle;
        speedX = (int)(SPEED * Math.cos(angle) - SPEED * Math.sin(angle));
        speedY = (int)(SPEED * Math.sin(angle) + SPEED * Math.cos(angle));
        this.damage = damage;
        isActive = true;
        this.shooter = e;
        this.persistent = persistent;
        this.timeToLive = 300;
    }

    public void move() {
        x += speedX;
        y += speedY;
        timeToLive--;
        if(timeToLive <= 0){
            isActive = false;
        }
    }

    public Color getColor() {
        return Color.BLACK;
    }

    public Shape getShape() {
        return new Ellipse2D.Double(x, y, size, size);
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
    public void setActive(boolean isActive){
        this.isActive = isActive;
    }

    public boolean isActive(){
        return isActive;
    }

    public int getSize(){
        return size;
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
