/*
 -----------------------------------------------------------------------------------
 Lab          : 03 (Projet)
 File         : Balanced.java
 Authors      : Janis Chiffelle, Yanik Lange, Mario Tomic
 Date         : 18/06/2022
 -----------------------------------------------------------------------------------
 */

package GameObjects.Entities.Enemy.Behaviour;

import GameObjects.Coordinates;
import GameObjects.Entities.Enemy.Enemy;


/**
 * Balanced behaviour class used to create balanced behaviours for the enemies.
 * Inherits of Behaviour.
 */
public class Balanced extends Behaviour {
    private final static int TOLERABLE_DISTANCE_CLOSE = 150;
    private final static int ADDED_DISTANCE_FAR = 50;
    private final static int TIME_UNTIL_REFRESH = 15;
    private boolean canMove = false;
    private double angle = 0;
    private int counter = 0;

    /**
     * Balanced Constructor. Used to initialize values for the balanced behaviour.
     *
     * @param e : The enemy on which we affect the balanced behaviour.
     * @param target : The player coordinates on which the enemy will have the balanced behaviour.
     */
    public Balanced(Enemy e, Coordinates target){
        super(e, target);
    }

    @Override
    public void move(){ // TODO
        e.setCanShoot(true);
        counter++;
        if(counter >= TIME_UNTIL_REFRESH){
            int distance = getDistance();
            double minDistance = TOLERABLE_DISTANCE_CLOSE * 2 - TOLERABLE_DISTANCE_CLOSE * e.getHealthRatio();
            angle = getAngle();
            if(distance < minDistance){
                angle -= Math.PI;
            }
            canMove = distance <= minDistance  || distance >= minDistance + ADDED_DISTANCE_FAR;
            counter = 0;
        }
        if(canMove){
            moveEntity(getSpeedX(angle), getSpeedY(angle));
        }
    }

}
