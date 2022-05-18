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
import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Abstract class that will be used to implement different bounceables, with their own shapes and colors
 */
public class Player extends Being {

    protected int x;
    protected int y;
    protected int size;
    protected double angle = 0;
    protected int moves = 2;
    protected Direction directionX;
    protected Direction directionY;
    protected int mouseX;
    protected int mouseY;

    public Player() {
        super(new PlayerRenderer());
        this.x = view.getWidth() / 2;
        this.y = view.getHeight() / 2;
        this.size = 10;
        this.directionX = Direction.STILL;
        this.directionY = Direction.STILL;
    }


    @Override
    public void move() {
        switch (directionX){
            case LEFT -> {
                x -= moves;
            }
            case RIGHT -> {
                x += moves;
            }
        }
        switch (directionY){
            case UP -> {
                y -= moves;
            }
            case DOWN -> {
                y += moves;
            }
        }
        w.move();
        checkBounds();
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

    /**
     * Checks if the bounceable has reached the minimum/maximum width/height and corrects
     * the position and movement vector if needed
     */
    private void checkBounds() {
        // Width check
        if(x >= view.getWidth() - size || x <= 0) {
            x = x <= 0 ? 0 : view.getWidth() - size;
        }
        // Height check
        if(y >= view.getHeight() - size || y <= 0) {
            y = y <= 0 ? 0 : view.getHeight() - size;
        }
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    @Override
    public void attack() {
        w.fire(x, y, mouseX, mouseY);
    }

    public void setMousePosition(int x, int y){
        this.mouseX = x;
        this.mouseY = y;
    }

    public double getAngle() {
        return angle;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
