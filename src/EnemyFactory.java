import GameObjects.Entities.Enemy.Enemy;
import GameObjects.Entities.Enemy.Grunt;
import GameObjects.Entities.Enemy.Sniper;
import GameObjects.Entities.Enemy.Tank;
import GameObjects.Entities.Player.Player;

import java.util.Random;


public class EnemyFactory {
    private int minX;
    private int maxX;
    private int minY;
    private int maxY;
    private final Player p;
    Random r;

    private final int ENEMY_TYPES = 3;

    public EnemyFactory(int minX, int minY, int maxX, int maxY, Player p){
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
        r = new Random();
        this.p = p;
    }


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

    public Enemy generateGrunt(int x, int y){
        return new Grunt(x, y, p);
    }

    public Enemy generateSniper(int x, int y){
        return new Sniper(x, y, p);
    }

    public Enemy generateTank(int x, int y) {return new Tank(x,y,p);}
}
