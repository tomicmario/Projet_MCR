package GameObjects.Entities.Enemy.Behaviour;

import GameObjects.Coordinates;
import GameObjects.Entities.Enemy.Enemy;
import java.util.Random;

/**
 * Teleporting behaviour class used to create teleport behaviours for the enemies.
 * Teleports the enemy at a random location after a certain time.
 * Inherits of Behaviour.
 *
 * @author Janis Chiffelle, Yanik Lange, Mario Tomic
 * @date 12.06.2022
 * @version Java 11
 */
public class Teleporting extends Behaviour {
    private static final int TELEPORT_RANGE = 300;
    private int counter;
    private final static int TIME_UNTIL_REFRESH = 120;
    private final static Random random = new Random();

    /**
     * Teleport Constructor. Used to initialize values for the teleport behaviour.
     *
     * @param e : The enemy on which we affect the distant behaviour.
     * @param target : The player coordinates on which the enemy will have the distant behaviour.
     */
    public Teleporting(Enemy e, Coordinates target){
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
