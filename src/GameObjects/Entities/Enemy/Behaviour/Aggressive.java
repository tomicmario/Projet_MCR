package GameObjects.Entities.Enemy.Behaviour;

import GameObjects.Entities.Enemy.Enemy;
import GameObjects.Entities.Entity;

public class Aggressive extends Behaviour {
    private static final int MIN_DISTANCE = 50;
    private static final int SHOOT_DISTANCE = 200;

    public Aggressive(Enemy e, Entity target){
        super(e, target);
    }
    @Override
    public void move() {
        int distance = getDistance();
        if(distance > MIN_DISTANCE) {
            double angle = getAngle();
            moveEntity(getSpeedX(angle), getSpeedY(angle));
        }
        e.setCanShoot(distance < SHOOT_DISTANCE);
    }
}
