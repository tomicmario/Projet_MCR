/*
 -----------------------------------------------------------------------------------
 Lab          : 01
 File         : BounceableItem.java
 Authors      : Lange Yanik, Mario Tomic
 Date         : 16/03/2022
 -----------------------------------------------------------------------------------
 */

package Entities.Character.Player;

import Entities.Character.*;
import Entities.Weapons.*;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Abstract class that will be used to implement different bounceables, with their own shapes and colors
 */
public class Player extends Being {
    private static final int SIZE = 10;
    protected int moves = 2;
    protected Direction directionX;
    protected Direction directionY;
    protected int mouseX;
    protected int mouseY;

    protected int currentIndex;
    protected Weapon[] weapons;

    public Player(int x, int y) {
        super(x, y, SIZE, new PlayerRenderer());
        this.directionX = Direction.STILL;
        this.directionY = Direction.STILL;
        weapons = new Weapon[]{ new Pistol(this), new Shotgun(this), new Plasma(this)};
        currentIndex = 0;
        this.currentWeapon = weapons[currentIndex];
    }


    @Override
    public void move(int maxWidth, int maxHeight) {
        switch (directionX){
            case LEFT:
                x -= moves;
                break;
            case RIGHT:
                x += moves;
                break;
        }
        switch (directionY){
            case UP:
                y -= moves;
                break;
            case DOWN:
                y += moves;
                break;
        }
        currentWeapon.move( maxWidth, maxHeight);
        checkBounds(maxWidth,maxHeight);
        setAngle(Math.atan2(mouseY - y, mouseX - x));
    }

    public void setXDirection(Direction d){
        directionX = d;
    }

    public void setYDirection(Direction d){
        directionY = d;
    }

    @Override
    public Color getColor() {
        return Color.ORANGE;
    }

    @Override
    public Shape getShape() {
        return new Rectangle2D.Double(x, y, size, size);
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public void equipNextWeapon(){
        currentIndex++;
        if(currentIndex >= weapons.length){
            currentIndex = 0;
        }
        currentWeapon = weapons[currentIndex];
    }

    @Override
    public Projectile[] attack() {
        return currentWeapon.fire(x, y, mouseX, mouseY);
    }

    public void setMousePosition(int x, int y){
        this.mouseX = x;
        this.mouseY = y;
    }

}
