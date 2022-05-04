/*
 -----------------------------------------------------------------------------------
 Lab          : 01
 File         : BounceableItem.java
 Authors      : Lange Yanik, Mario Tomic
 Date         : 16/03/2022
 -----------------------------------------------------------------------------------
 */

package Entities;

import View.GameDisplay;
import View.Renderer;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Abstract class that will be used to implement different bounceables, with their own shapes and colors
 */
public class Player implements Entity {

    protected int x;
    protected int y;
    protected int size;
    protected int moves = 2;
    protected Direction directionX;
    protected Direction directionY;
    protected GameDisplay view; // Important for when the window resizes
    protected Renderer renderer;

    /**
     * Implements a new bounceable with random values
     * @param renderer Determines the render of the bouncer
     */
    public Player(Renderer renderer) {
        this.renderer = renderer;
        view = GameDisplay.getInstance();
        this.x = view.getWidth() / 2;
        this.y = view.getHeight() / 2;
        this.size = 10;
        this.directionX = Direction.STILL;
        this.directionY = Direction.STILL;
    }

    @Override
    public void draw() {
        renderer.display(view.getGraphics(), this);
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
        checkBounds();
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

}
