package GameObjects.Entities.Enemy.Behaviour;

import GameObjects.Entities.Enemy.Enemy;
import GameObjects.Entities.Entity;

/**
 * Aggresssive behaviour class used to create aggressive behaviours for the enemies.
 * Will get close to the player and start shooting at a certain distance.
 * Inherits of Behaviour.
 */
public class Aggressive extends Behaviour {
    private static final int MIN_DISTANCE = 50; //min distance that enemy with this behaviour will stay away from the player.
    private static final int SHOOT_DISTANCE = 200; //distance on which the enemy will start to shoot with this behaviour.

    /**
     * Aggressive Constructor. Used to initialize values for the aggressive behaviour.
     *
     * @param e : The enemy on which we affect the aggressive behaviour.
     * @param target : The player on which the enemy will have the aggressive behaviour.
     */
    public Aggressive(Enemy e, Entity target){
        super(e, target);
    }

    @Override
    public void move(){
        e.setCanShoot(true);
        int distance = getDistance();

        if(distance > MIN_DISTANCE){
            double angle = getAngle();
            moveEntity(getSpeedX(angle), getSpeedY(angle));
        }
        e.setCanShoot(distance < SHOOT_DISTANCE);
    }
}
