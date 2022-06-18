import GameObjects.Entities.Entity;

import java.util.LinkedList;

public class SpawnDirector {
    private final LinkedList<Entity> entities;
    private final EnemyFactory ef;
    private int counter;
    private int spawnDelay = 90;
    private int enemiesToSpawn = 1;

    public SpawnDirector(LinkedList<Entity> entities, EnemyFactory ef){
        this.entities = entities;
        this.ef = ef;
        counter = 0;
    }

    public void nextFrame(){
        counter++;
        if(counter == spawnDelay){
            for(int i = 0; i < enemiesToSpawn; ++i) {
                entities.add(ef.generateRandomEnemy());
            }
            spawnDelay--;
            if(spawnDelay < 80){
                spawnDelay = 90 + 10 * enemiesToSpawn;
                enemiesToSpawn++;
            }
            counter = 0;
        }
    }
}
