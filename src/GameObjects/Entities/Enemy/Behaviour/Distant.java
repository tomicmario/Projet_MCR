package GameObjects.Entities.Enemy.Behaviour;

import GameObjects.Entities.Enemy.Enemy;
import GameObjects.Entities.Entity;


/**
 * Coward behaviour class used to create coward behaviours for the enemies.
 * Moves away of the player to keep a certain distance from him.
 * Inherits of Behaviour.
 */
public class Distant extends Behaviour {
    private static final int MIN_DISTANCE = 300;

    /**
     * Distant Constructor. Used to initialize values for the distant behaviour.
     *
     * @param e : The enemy on which we affect the distant behaviour.
     * @param target : The player on which the enemy will have the distant behaviour.
     */
    public Distant(Enemy e, Entity target){
        super(e, target);
    }

    @Override
    public void move(){
        int distance = getDistance();

        if(distance < MIN_DISTANCE) {
            double angle = getAngle() - Math.PI;
            moveEntity(getSpeedX(angle), getSpeedY(angle));
        }
    }
}
