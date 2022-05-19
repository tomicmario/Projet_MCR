package Entities.Weapons;

import Entities.Character.Player.PlayerRenderer;
import Entities.Entity;
import Entities.Renderer;
import View.Displayer;

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
            return new Projectile[]{new Projectile(e.getX(), e.getY(), e.getAngle(), 10, 10)};
        }
        return new Projectile[0];
    }

    @Override
    public void draw(Displayer view) {
        r.display(view.getGraphics(), this);
    }

    @Override
    public void move(int maxWidth, int maxHeight) {
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
