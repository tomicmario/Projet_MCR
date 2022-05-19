package Entities.Weapons;

import Entities.Entity;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Projectile extends Entity {
    protected final int SPEED;
    protected int speedX;
    protected int speedY;
    protected int size;

    protected Projectile(int posX, int posY, double angle, int speed, int size) {
        super(posX, posY, size, new ProjectileRenderer());
        this.SPEED = speed;
        speedX = (int)(posY * Math.sin(angle) + posX * Math.cos(angle));
        speedY = (int)(posX * Math.sin(angle) + posY * Math.cos(angle));
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
