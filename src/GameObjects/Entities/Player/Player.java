/*
 -----------------------------------------------------------------------------------
 Lab          : 01
 File         : BounceableItem.java
 Authors      : Lange Yanik, Mario Tomic
 Date         : 16/03/2022
 -----------------------------------------------------------------------------------
 */

package GameObjects.Entities.Player;

import GameObjects.Entities.Entity;
import GameObjects.Entities.EntityRenderer;
import GameObjects.Weapons.*;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Player extends Entity {
    private static final int SIZE = 10;
    protected int moves = 2;
    protected int mouseX;
    protected int mouseY;
    protected boolean mouseClicked;
    protected int[] activeDirections;

    public Player(int x, int y) {
        super(x, y, SIZE, 150, new EntityRenderer());
        weapons = new Weapon[]{ new Rifle(this), new Shotgun(this), new Flamethrower(this), new RocketLauncher(this)};
        mouseClicked = false;
        activeDirections = new int[Direction.values().length];
    }


    @Override
    public void move() {
        x += activeDirections[Direction.RIGHT.ordinal()] - activeDirections[Direction.LEFT.ordinal()];
        y += activeDirections[Direction.DOWN.ordinal()] - activeDirections[Direction.UP.ordinal()];
        weapons[currentWeaponIndex].nextFrame();
        setAngle(Math.atan2(mouseY - y, mouseX - x));
    }

    public void setMouseClicked(boolean clicked){
        this.mouseClicked = clicked;
    }

    public void setDirection(Direction d){
        activeDirections[d.ordinal()] = moves;
    }

    public void unsetDirection(Direction d){
        activeDirections[d.ordinal()] = 0;
    }

    @Override
    public Color getColor() {
        return Color.CYAN;
    }

    @Override
    public Shape getShape() {
        return new Rectangle2D.Double(x, y, size, size);
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public void equipNextWeapon(){
        currentWeaponIndex++;
        if(currentWeaponIndex >= weapons.length){
            currentWeaponIndex = 0;
        }
    }

    @Override
    public Projectile[] attack() {
        if(mouseClicked) {
            return weapons[currentWeaponIndex].fire(x, y, mouseX, mouseY);
        }

        return null;
    }

    public void setMousePosition(int x, int y){
        this.mouseX = x;
        this.mouseY = y;
    }

    @Override
    public int getPointsWhenKilled(){
        return 0;
    }

}
