package Entities;

import View.Displayer;

import java.awt.*;
import java.awt.Shape;

public abstract class Entity {

    protected int x;
    protected int y;
    protected int size;
    protected double angle = 0;


    protected Renderer renderer;

    protected Entity(int x, int y, int size, Renderer r){
        this.x = x;
        this.y = y;
        this.size = size;
        renderer = r;
    }

    public void draw(Displayer view) {
        renderer.display(view.getGraphics(), this);
    }

    public abstract void move(int maxWidth, int maxHeight);
    public abstract Color getColor();
    public abstract Shape getShape();

    public double getAngle(){
        return angle;
    }
    public int getY(){
        return y;
    };
    public int getX(){
        return x;
    };
}
