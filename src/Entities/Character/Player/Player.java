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
    private static final int SIZE = 10;
    protected int moves = 2;
    protected Direction directionX;
    protected Direction directionY;
    protected int mouseX;
    protected int mouseY;

    public Player(int x, int y) {
        super(x, y, SIZE, new PlayerRenderer());
        this.directionX = Direction.STILL;
        this.directionY = Direction.STILL;
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
        w.move( maxWidth, maxHeight);
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

    /**
     * Checks if the bounceable has reached the minimum/maximum width/height and corrects
     * the position and movement vector if needed
     */
    private void checkBounds(int maxWidth, int maxHeight) {
        // Width check
        if(x >= maxWidth - size || x <= 0) {
            x = x <= 0 ? 0 : maxWidth - size;
        }
        // Height check
        if(y >= maxHeight - size || y <= 0) {
            y = y <= 0 ? 0 : maxHeight - size;
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

}
