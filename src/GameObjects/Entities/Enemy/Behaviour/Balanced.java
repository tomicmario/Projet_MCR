package GameObjects.Entities.Enemy.Behaviour;

import GameObjects.Entities.Enemy.Enemy;
import GameObjects.Entities.Entity;
import java.util.Random;

/**
 * Balanced behaviour class used to create balanced behaviours for the enemies.
 * Inherits of Behaviour.
 */
public class Balanced extends Behaviour {
    private final int TOLERABLE_DISTANCE_CLOSE = 150;
    private final int TOLERABLE_DISTANCE_FAR = 200;
    private final int TIME_UNTIL_REFRESH = 15;
    private boolean canMove = false;
    private double angle = 0;
    private int counter = 0;
    Random r;

    /**
     * Balanced Constructor. Used to initialize values for the balanced behaviour.
     *
     * @param e : The enemy on which we affect the balanced behaviour.
     * @param target : The player on which the enemy will have the balanced behaviour.
     */
    public Balanced(Enemy e, Entity target){
        super(e, target);
        this.r = new Random();
    }

    @Override
    public void move(){ // TODO
        e.setCanShoot(true);
        counter++;
        int distance = getDistance();
        if(counter >= TIME_UNTIL_REFRESH){
            angle = getAngle();
            counter = 0;
            if(distance < TOLERABLE_DISTANCE_CLOSE){
                angle -= Math.PI;
            }
            canMove = distance <= TOLERABLE_DISTANCE_CLOSE  || distance >= TOLERABLE_DISTANCE_FAR;
        }
        if(canMove){
            moveEntity(getSpeedX(angle), getSpeedY(angle));
        }
    }

}
