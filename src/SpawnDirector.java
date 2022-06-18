/*
 -----------------------------------------------------------------------------------
 Lab          : 03 (Projet)
 File         : SpawnDirector.java
 Authors      : Janis Chiffelle, Yanik Lange, Mario Tomic
 Date         : 18/06/2022
 -----------------------------------------------------------------------------------
 */

import GameObjects.Entities.Entity;
import java.util.LinkedList;

/**
 * SpawnDirector class. Managing the time/rythme on which the enemies spawn.
 */
public class SpawnDirector {
    private final LinkedList<Entity> entities;
    private final EnemyFactory ef;
    private int counter;
    private int spawnDelay = 90;
    private int enemiesToSpawn = 1;

    /**
     *
     * @param entities : The list of entities of the field.
     * @param ef : the enemy factory to create the enemies.
     */
    public SpawnDirector(LinkedList<Entity> entities, EnemyFactory ef){
        this.entities = entities;
        this.ef = ef;
        counter = 0;
    }

    /**
     * Adds an enemy after a certain delay. Reduce the delay through time
     * and after reaching < 80, it increases the number of enemies to spawn each delay
     * and sets the delay back to higher value depending on the number of enemies to spawn.
     */
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
