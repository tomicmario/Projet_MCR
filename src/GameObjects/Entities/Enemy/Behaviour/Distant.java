package GameObjects.Entities.Enemy.Behaviour;

import GameObjects.Entities.Enemy.Enemy;
import GameObjects.Entities.Entity;

public class Distant extends Behaviour {
    private static final int MIN_DISTANCE = 300;

    public Distant(Enemy e, Entity target){
        super(e, target);
        e.setCanShoot(true);
    }

    @Override
    public void move() {
        int distance = getDistance();
        if(distance < MIN_DISTANCE) {
            e.setCanShoot(false);
            double angle = getAngle() - Math.PI;
            moveEntity(getSpeedX(angle), getSpeedY(angle));
        }
        else {
            e.setCanShoot(true);
        }
    }
}
