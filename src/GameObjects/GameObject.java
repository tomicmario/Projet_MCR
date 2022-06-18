package GameObjects;

import View.Displayer;

import java.awt.*;

public abstract class GameObject {
    protected int x;
    protected int y;
    protected int radius;
    protected double angle;
    protected int speed;

    protected GameObject(int x, int y, int radius){
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.speed = 2;
    }

    /**
     *  Displays the entity on the game.
     * @param view
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

    public abstract void move();

    /**
     *
     * @return The size of the entity.
     */
    public int getRadius(){
        return radius;
    }

    /**
     *
     * @return The angle of the speed vector of the entity.
     */
    public double getAngle(){
        return angle;
    }

    /**
     *
     * @return The position y of the entity.
     */
    public int getY(){
        return y;
    }

    /**
     *
     * @return The position x of the entity.
     */
    public int getX(){
        return x;
    }
}
