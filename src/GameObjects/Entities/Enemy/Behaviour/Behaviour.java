/*
 -----------------------------------------------------------------------------------
 Lab          : 03 (Projet)
 File         : Behaviour.java
 Authors      : Janis Chiffelle, Yanik Lange, Karel Ngueukam, Pierre-Olivier Sandoz, Mario Tomic
 Date         : 18/06/2022
 -----------------------------------------------------------------------------------
 */

package GameObjects.Entities.Enemy.Behaviour;

import GameObjects.Coordinates;
import GameObjects.Entities.Enemy.Enemy;

/**
 * Abstract class used to define all the behaviours of the IA trough inheritance.
 */
public abstract class Behaviour {
    protected final Enemy e;
    protected final Coordinates target;

    /**
     * Behaviour Constructor. Used to initialize common values of all
     * classes that inherits of Behaviour (in this case all the behaviours of the game).
     *
     * @param e : The enemy on which we affect the behaviour.
     * @param target : The player on which the enemy will behave depending on the behaviour.
     */
    protected Behaviour(Enemy e, Coordinates target){
        this.e = e;
        this.target = target;
    }

    /**
     *
     * @return The angle needed by the enemy used to move toward the target/player. // TODO.
     */
    protected double getAngle(){
        return Math.atan2(target.getY() - e.getY(), target.getX() - e.getX()) - Math.PI / 4;
    }

    /**
     *
     * @return The distance between the enemy and the target/player.
     */
    protected int getDistance(){
        return (int)Math.round( Math.sqrt( (target.getX() - e.getX()) * (target.getX() - e.getX()) + (target.getY() - e.getY()) * (target.getY() - e.getY()) ) );
    }

    /**
     *
     * @param angle : The angle of the enemy used to calculate the speed on the axis x.
     * @return A delta x that can be added to the current x to change the position (equivalent as speed).
     */
    protected int getSpeedX(double angle){
        return (int) (e.getSpeed() * Math.cos(angle) - e.getSpeed() * Math.sin(angle));
    }

    /**
     *
     * @param angle : The angle of the enemy used to calculate the speed on the axis y.
     * @return A delta y that can be added to the current y to change the position (equivalent as speed).
     */
    protected int getSpeedY(double angle){
        return (int) (e.getSpeed() * Math.sin(angle) + e.getSpeed() * Math.cos(angle));
    }

    /**
     * Moves an enemy by setting new coordinates.
     *
     * @param speedX : The speed x or delta x that will be added to the current x to move the enemy.
     * @param speedY : The speed y or delta y that will be added to the current y to move the enemy.
     */
    protected void moveEntity(int speedX, int speedY){
        e.setCoordinates(e.getX() + speedX, e.getY() + speedY);
    }

    /**
     * Abstract move function used in all the classes that inherits of Behaviour.
     * Moves the enemy depending on the behaviour.
     */
    public abstract void move();
}
