package Entities.Weapons;

import Entities.Character.Player.PlayerRenderer;
import Entities.Entity;
import Entities.Renderer;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Pistol extends Weapon{
    public Pistol(Entity entity) {
        super(new PistolRenderer(), entity);
    }

    @Override
    public Projectile[] fire(int currentX, int currentY, int targetX, int targetY) {
        if(counter == FIRE_RATE){
            counter = 0;
            System.out.println("fire at " + targetX + "," + targetY);
            // Create projectiles
        }
        return new Projectile[0];
    }

    @Override
    public void draw() {
        r.display(view.getGraphics(), this);
    }

    @Override
    public void move() {
        if(counter < FIRE_RATE){
            counter++;
        }
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
