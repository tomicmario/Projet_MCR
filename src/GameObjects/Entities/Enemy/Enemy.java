package GameObjects.Entities.Enemy;

import GameObjects.Entities.Enemy.Behaviour.Behaviour;
import GameObjects.Entities.Player.Player;
import GameObjects.Entities.Player.PlayerRenderer;
import GameObjects.Entities.Entity;
import GameObjects.Weapons.*;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public abstract class Enemy extends Entity {
    private static final int SIZE = 30;
    protected final Player p;
    protected Behaviour b;
    protected int speed = 2;

    public Enemy(int x, int y, Player p) {
        super(x, y, SIZE, new PlayerRenderer());
        this.p = p;
    }

    @Override
    public void move() {
        currentWeapon.nextFrame();
        b.move();
    }


    @Override
    public Shape getShape() {
        return new Ellipse2D.Double(x, y, size, size);
    }

    public void setCoordinates(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getSpeed(){
        return speed;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    @Override
    public Projectile[] attack() {
        return currentWeapon.fire(x, y, p.getX(), p.getY());
    }

}
