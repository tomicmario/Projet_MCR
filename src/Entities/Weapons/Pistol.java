package Entities.Weapons;

import Entities.Entity;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Pistol extends Weapon{
    private static int SIZE = 3;
    public Pistol(Entity entity) {
        super(new PistolRenderer(), entity, SIZE);
    }

    @Override
    public Projectile[] fire(int currentX, int currentY, int targetX, int targetY) {
        if(counter == FIRE_RATE){
            counter = 0;
            System.out.println("fire at " + targetX + "," + targetY);
            double angle = Math.atan2(targetY - currentY, targetX - currentX) - Math.PI / 4;
            return new Projectile[]{new Projectile(e.getX(), e.getY(), angle , 20, 10)};
        }
        return new Projectile[0];
    }

    @Override
    public Color getColor() {
        return Color.DARK_GRAY;
    }

    @Override
    public Shape getShape() {
        return new Rectangle2D.Double(getX(), getY(), width, height);
    }

    @Override
    public double getAngle() {
        return e.getAngle();
    }

    @Override
    public int getY() {
        return e.getY();
    }

    @Override
    public int getX() {
        return e.getX();
    }
}
