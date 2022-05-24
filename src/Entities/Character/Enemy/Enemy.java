package Entities.Character.Enemy;

import Entities.Character.Being;
import Entities.Character.Enemy.Behaviour.Behaviour;
import Entities.Character.Player.Player;
import Entities.Character.Player.PlayerRenderer;
import Entities.Weapons.*;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public abstract class Enemy extends Being {
    private static final int SIZE = 10;
    protected final Player p;
    protected Behaviour b;
    protected int speed = 2;

    public Enemy(int x, int y, Player p) {
        super(x, y, SIZE, new PlayerRenderer());
        this.p = p;
    }

    @Override
    public void move(int maxWidth, int maxHeight) {
        currentWeapon.move(maxWidth, maxHeight);
        b.move();
        checkBounds(maxWidth,maxHeight);
    }


    @Override
    public Color getColor() {
        return Color.ORANGE;
    }

    @Override
    public Shape getShape() {
        return new Rectangle2D.Double(x, y, size, size);
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
