package Controller;

import GameObjects.Coordinates;
import GameObjects.Entities.Enemy.Enemy;
import GameObjects.Entities.Enemy.Grunt;
import GameObjects.Entities.Enemy.Sniper;
import GameObjects.Entities.Enemy.Tank;

import java.util.Random;

/**
 *  Simplistic factory class used to create create different types of enemies
 *
 *  @author Janis Chiffelle, Yanik Lange, Mario Tomic
 *  @date 29.05.2022
 *  @version Java 11
 */
public class EnemyFactory {
    private final int minX;
    private final int maxX;
    private final int minY;
    private final int maxY;
    private final Coordinates playerCoordinates;
    private final Random random;
    private static final int ENEMY_TYPES = 3;

    /**
     * Constructor of the factory used to generate the enemies.
     *
     * @param minX : The min position x on where the enemy is created.
     * @param minY : The min position y on where the enemy is created.
     * @param maxX : The max position x on where the enemy is created.
     * @param maxY : The max position y on where the enemy is created.
     * @param playerCoordinates : The coordinates of the player on which the enemy will focus his attacks.
     */
    public EnemyFactory(int minX, int minY, int maxX, int maxY, Coordinates playerCoordinates){
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
        random = new Random();
        this.playerCoordinates = playerCoordinates;
    }

    /**
     * Generates a random type of enemy on a random location.
     *
     * @return a random enemy type on a random location.
     */
    public Enemy generateRandomEnemy(){
        int x = random.nextInt(maxX - minX) + minX;
        int y = random.nextInt(maxY - minY) + minY;
        int type = random.nextInt(ENEMY_TYPES);

        switch (type){
            case 1:
                return generateSniper(x, y);
            case 2:
                return generateTank(x, y);
            default:
                return generateGrunt(x, y);
        }
    }

    /**
     * Creates an enemy of type Grunt.
     *
     * @param x : The position x where the grunt will be created.
     * @param y : The position y where the grunt will be created.
     * @return An enemy, more specifically a grunt.
     */
    public Enemy generateGrunt(int x, int y){
        return new Grunt(x, y, playerCoordinates);
    }

    /**
     * Creates an enemy of type Sniper.
     *
     * @param x : The position x where the sniper will be created.
     * @param y : The position y where the sniper will be created.
     * @return An enemy, more specifically a sniper.
     */
    public Enemy generateSniper(int x, int y){
        return new Sniper(x, y, playerCoordinates);
    }

    /**
     * Creates an enemy of type Tank.
     *
     * @param x : The position x where the tank will be created.
     * @param y : The position y where the tank will be created.
     * @return An enemy, more specifically a tank.
     */
    public Enemy generateTank(int x, int y){
        return new Tank(x, y, playerCoordinates);
    }
}
