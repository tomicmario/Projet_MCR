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

    protected Projectile(int posX, int posY, double angle, int speed, int size, int damage, Entity e) {
        this.x = posX;
        this.y = posY;
        this.size = size;
        this.SPEED = speed;
        this.angle = angle;
        speedX = (int)(SPEED * Math.cos(angle) - SPEED * Math.sin(angle));
        speedY = (int)(SPEED * Math.sin(angle) + SPEED * Math.cos(angle));
        this.damage = damage;
        isActive = true;
        this.shooter = e;
    }

    public void move() {
        x += speedX;
        y += speedY;
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
}
