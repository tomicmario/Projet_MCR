package Entities;

import View.GameDisplay;

import java.awt.*;
import java.awt.Shape;

public abstract class Entity {
    protected GameDisplay view;
    protected Renderer renderer;

    protected Entity(Renderer r){
        view = GameDisplay.getInstance();
        renderer = r;
    }

    public void draw() {
        renderer.display(view.getGraphics(), this);
    }

    public abstract void move();
    public abstract Color getColor();
    public abstract Shape getShape();
    public abstract double getAngle();
    public abstract int getY();
    public abstract int getX();
}
