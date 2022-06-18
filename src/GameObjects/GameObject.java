/*
 -----------------------------------------------------------------------------------
 Lab          : 03 (Projet)
 File         : GameObject.java
 Authors      : Janis Chiffelle, Yanik Lange, Mario Tomic
 Date         : 18/06/2022
 -----------------------------------------------------------------------------------
 */

package GameObjects;

import View.Displayer;
import java.awt.*;

/**
 *  Abstract game object class. used by the classes that inherits of it.
 *  In our case Projectile and Entity of the game.
 */
public abstract class GameObject {
    protected int x;
    protected int y;
    protected int radius;
    protected double angle;
    protected int speed;

    /**
     * GameObject constructor. Used to initialize common values of all classes that
     * inherits of GameObject.
     *
     * @param x : The position x of the projectile.
     * @param y : The position y of the projectile.
     * @param radius : The radius of the projectile.
     */
    protected GameObject(int x, int y, int radius){
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.speed = 2;
    }

    /**
     * Displays the game object on the game.
     *
     * @param view : the view on which we want to draw the game object.
     */
    public void draw(Displayer view){
        Graphics2D g = view.getGraphics();
        g.setColor(this.getColor());
        g.fill(this.getShape());
        g.draw(this.getShape());
    }

    /**
     * Getter of color used in the classes that inherits of GameObject.
     *
     * @return The color of the game object.
     */
    public abstract Color getColor();

    /**
     * Getter of shape used in the classes that inherits of GameObject.
     *
     * @return The shape of the game object.
     */
    public abstract Shape getShape();

    /**
     *  Abstract move method used in the classes that inherits of GameObject.
     */
    public abstract void move();

    /**
     *
     * @return The size of the game object.
     */
    public int getRadius(){
        return radius;
    }

    /**
     *
     * @return The angle of the speed vector of the game object.
     */
    public double getAngle(){
        return angle;
    }

    /**
     *
     * @return The position y of the game object.
     */
    public int getY(){
        return y;
    }

    /**
     *
     * @return The position x of the game object.
     */
    public int getX(){
        return x;
    }
}
