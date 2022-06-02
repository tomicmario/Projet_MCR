package GameObjects.Entities.Enemy;

import GameObjects.Entities.Enemy.Behaviour.Behaviour;
import GameObjects.Entities.Player.Player;
import GameObjects.Entities.Player.PlayerRenderer;
import GameObjects.Entities.Entity;
import GameObjects.Weapons.*;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public abstract class Enemy extends Entity {
    private static final int SIZE = 30;
    protected final Player p;
    protected Behaviour b;

    protected boolean canShoot;
    protected final int points;

    protected Enemy(int x, int y, int maxHealth, int points, Player p) {
        super(x, y, SIZE, maxHealth, new PlayerRenderer());
        this.p = p;
        this.canShoot = true;
        this.points = points;
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
        if(canShoot) {
            return currentWeapon.fire(x, y, p.getX(), p.getY());
        }

        return null;
    }

    public void setCanShoot(boolean canShoot){
        this.canShoot = canShoot;
    }

    @Override
    public int getPoints(){
        return points;
    }
}
