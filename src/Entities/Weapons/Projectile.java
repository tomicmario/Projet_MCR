package Entities.Weapons;

import Entities.Entity;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Projectile extends Entity {
    protected final int SPEED;
    protected int speedX;
    protected int speedY;

    protected Projectile(int posX, int posY, double angle, int speed, int size) {
        super(posX, posY, size, new ProjectileRenderer());
        this.SPEED = speed;
        speedX = (int)(SPEED * Math.cos(angle) - SPEED * Math.sin(angle));
        speedY = (int)(SPEED * Math.sin(angle) + SPEED * Math.cos(angle));
    }

    @Override
    public void move(int maxWidth, int maxHeight) {
        x += speedX;
        y += speedY;
    }

    @Override
    public Color getColor() {
        return Color.BLACK;
    }

    @Override
    public Shape getShape() {
        return new Ellipse2D.Double(x, y, size, size);
    }
}
