package GameObjects.Entities.Enemy.Behaviour;

import GameObjects.Entities.Enemy.Enemy;
import GameObjects.Entities.Entity;

import java.util.Random;


/**
 * Coward behaviour class used to create coward behaviours for the enemies.
 * Moves away of the player to keep a certain distance from him.
 * Inherits of Behaviour.
 */
public class Teleporting extends Behaviour {
    private static final int TELEPORT_RANGE = 300;
    private int counter;
    private final static int TIME_UNTIL_REFRESH = 120;
    private final static Random random = new Random();

    /**
     * Distant Constructor. Used to initialize values for the distant behaviour.
     *
     * @param e : The enemy on which we affect the distant behaviour.
     * @param target : The player on which the enemy will have the distant behaviour.
     */
    public Teleporting(Enemy e, Entity target){
        super(e, target);
        counter = TIME_UNTIL_REFRESH;
    }

    @Override
    public void move(){
        counter++;
        if(counter >= TIME_UNTIL_REFRESH) {
            int newX = -TELEPORT_RANGE / 2 + random.nextInt(TELEPORT_RANGE);
            int newY = -TELEPORT_RANGE / 2 + random.nextInt(TELEPORT_RANGE);
            moveEntity(newX, newY);
            counter = 0;
        }
    }
}
