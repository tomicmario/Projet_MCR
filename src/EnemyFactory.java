import GameObjects.Entities.Enemy.Enemy;
import GameObjects.Entities.Enemy.Grunt;
import GameObjects.Entities.Enemy.Sniper;
import GameObjects.Entities.Enemy.Tank;
import GameObjects.Entities.Player.Player;
import java.util.Random;

/**
 *  Factory class used to create a Factory that creates enemies.
 */
public class EnemyFactory {
    private int minX;
    private int maxX;
    private int minY;
    private int maxY;
    private final Player p;
    private Random r;
    private final int ENEMY_TYPES = 3;

    /**
     * Constructor of the factory used to generate the enemies.
     *
     * @param minX : The min position x on where the enemy is created.
     * @param minY : The min position y on where the enemy is created.
     * @param maxX : The max position x on where the enemy is created.
     * @param maxY : The max position y on where the enemy is created.
     * @param p : The player on which the enemy will focus his attacks.
     */
    public EnemyFactory(int minX, int minY, int maxX, int maxY, Player p){
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
        r = new Random();
        this.p = p;
    }

    /**
     * Generates a random type of enemy on a random location.
     *
     * @return a random enemy type on a random location.
     */
    public Enemy generateRandomEnemy(){
        int x = r.nextInt(maxX - minX) + minX;
        int y = r.nextInt(maxY - minY) + minY;
        int type = r.nextInt(ENEMY_TYPES);

        switch (type){
            case 1:
                return generateSniper(x, y);
            case 2:
                return generateTank(x,y);
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
        return new Grunt(x, y, p.getCoordinates());
    }

    /**
     * Creates an enemy of type Sniper.
     *
     * @param x : The position x where the sniper will be created.
     * @param y : The position y where the sniper will be created.
     * @return An enemy, more specifically a sniper.
     */
    public Enemy generateSniper(int x, int y){
        return new Sniper(x, y, p.getCoordinates());
    }

    /**
     * Creates an enemy of type Tank.
     *
     * @param x : The position x where the tank will be created.
     * @param y : The position y where the tank will be created.
     * @return An enemy, more specifically a tank.
     */
    public Enemy generateTank(int x, int y){
        return new Tank(x,y,p.getCoordinates());
    }
}
