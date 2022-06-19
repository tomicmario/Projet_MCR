import GameObjects.Entities.Entity;
import java.util.LinkedList;

/**
 * SpawnDirector class. Managing the time/rythme on which the enemies spawn.
 *
 * @author Janis Chiffelle, Yanik Lange, Mario Tomic
 * @date 01.06.2022
 * @version Java 11
 */
public class SpawnDirector {
    private final LinkedList<Entity> entities;
    private final EnemyFactory ef;
    private int ticks;
    private final int INITIAL_DELAY = 90;
    private int spawnDelay = INITIAL_DELAY;
    private int enemiesToSpawn = 1;
    private int spawnCycles = 0;
    private static final int CYCLES_TO_INCREMENT = 10;
    private static final int ADDED_TICKS_BY_SPAWNED_ENEMIES = 60;

    /**
     *
     * @param entities : The list of entities of the field.
     * @param ef : the enemy factory to create the enemies.
     */
    public SpawnDirector(LinkedList<Entity> entities, EnemyFactory ef){
        this.entities = entities;
        this.ef = ef;
        ticks = 0;
    }

    /**
     * Adds an amount of enemies after a certain delay. The more time passes, the more enemies spawn at once.
     * The more enemies spawn at once, the longer it takes the director to spawn a new wave
     */
    public void nextTick() {
        ticks++;
        if(ticks == spawnDelay){
            spawnCycles++;
            ticks = 0;
            if(spawnCycles % CYCLES_TO_INCREMENT == 0){
                spawnDelay = INITIAL_DELAY + ADDED_TICKS_BY_SPAWNED_ENEMIES * (enemiesToSpawn - 1);
                enemiesToSpawn++;
            }
            for(int i = 0; i < enemiesToSpawn; ++i) {
                entities.add(ef.generateRandomEnemy());
            }

        }
    }
}
