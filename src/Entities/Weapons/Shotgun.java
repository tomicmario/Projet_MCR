package Entities.Weapons;

import Entities.Entity;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Shotgun extends Weapon{
    private static int SIZE = 3;
    private static int pellets = 6;
    public Shotgun(Entity entity) {
        super(new PistolRenderer(), entity, SIZE);
    }

    @Override
    public Projectile[] fire(int currentX, int currentY, int targetX, int targetY) {
        if(counter == FIRE_RATE){
            counter = 0;
            System.out.println("fire at " + targetX + "," + targetY);
            double angle = Math.atan2(targetY - currentY, targetX - currentX);
            Projectile[] projectiles = new Projectile[pellets];
            for(int i = 0; i < pellets; ++ i){
                projectiles[i] = new Projectile(e.getX(), e.getY(), angle - i * Math.PI / 12 , 20, 10);
            }
            return projectiles;
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
