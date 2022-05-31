import GameObjects.Entities.Enemy.Enemy;
import GameObjects.Entities.Enemy.EnemyFactory;

import java.util.LinkedList;

public class SpawnDirector {
    private final LinkedList<Enemy> enemies;
    private final EnemyFactory ef;
    private int counter;
    private int spawnDelay = 120;

    public SpawnDirector(LinkedList<Enemy> enemies, EnemyFactory ef){
        this.enemies = enemies;
        this.ef = ef;
        counter = 0;
    }

    public void nextFrame(){
        counter++;
        if(counter == spawnDelay){
            enemies.add(ef.generateRandomEnemy());
            spawnDelay--;
            counter = 0;
        }
    }
}
