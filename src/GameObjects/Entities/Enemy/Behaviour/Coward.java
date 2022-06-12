package GameObjects.Entities.Enemy.Behaviour;

import GameObjects.Entities.Enemy.Enemy;
import GameObjects.Entities.Entity;


public class Coward extends Behaviour {
    private static final int MIN_DISTANCE = 300;

    public Coward(Enemy e, Entity target){
        super(e, target);
    }

    @Override
    public void move(){
        int distance = getDistance();

        if(distance < MIN_DISTANCE) {
            double angle = getAngle() - Math.PI;
            moveEntity(getSpeedX(angle) * 2, getSpeedY(angle) * 2);
        }
        e.setCanShoot(MIN_DISTANCE < distance);
    }
}