package Entities;

import View.Displayer;

import java.awt.*;
import java.awt.Shape;

public abstract class Entity {
    protected Renderer renderer;

    protected Entity(Renderer r){
        renderer = r;
    }

    public void draw(Displayer view) {
        renderer.display(view.getGraphics(), this);
    }

    public abstract void move(int maxWidth, int maxHeight);
    public abstract Color getColor();
    public abstract Shape getShape();
    public abstract double getAngle();
    public abstract int getY();
    public abstract int getX();
}
