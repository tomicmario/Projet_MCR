/*
 -----------------------------------------------------------------------------------
 Lab          : 03 (Projet)
 File         : Coward.java
 Authors      : Janis Chiffelle, Yanik Lange, Karel Ngueukam, Pierre-Olivier Sandoz, Mario Tomic
 Date         : 18/06/2022
 -----------------------------------------------------------------------------------
 */

package GameObjects.Entities.Enemy.Behaviour;

import GameObjects.Coordinates;
import GameObjects.Entities.Enemy.Enemy;

/**
 * Coward behaviour class used to create coward behaviours for the enemies.
 * Moves away of the player to keep a certain distance from him.
 * Inherits of Behaviour.
 */
public class Coward extends Behaviour {
    private static final int MIN_DISTANCE = 300;

    /**
     * Coward Constructor. Used to initialize values for the distant behaviour.
     *
     * @param e : The enemy on which we affect the distant behaviour.
     * @param target : The player coordinates on which the enemy will have the distant behaviour.
     */
    public Coward(Enemy e, Coordinates target){
        super(e, target);
    }

    @Override
    public void move(){
        int distance = getDistance();

        if(distance < MIN_DISTANCE) {
            double angle = getAngle() - Math.PI;
            moveEntity(getSpeedX(angle) * 2, getSpeedY(angle) * 2);
        }
        e.setCanShoot(MIN_DISTANCE < distance);
    }
}