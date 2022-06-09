package GameObjects.Entities.Enemy.Behaviour;

import GameObjects.Entities.Enemy.Enemy;
import GameObjects.Entities.Entity;

public class Distant extends Behaviour {
    private static final int MIN_DISTANCE = 300;

    public Distant(Enemy e, Entity target){
        super(e, target);
    }

    @Override
    public void move() {
        int distance = getDistance();
        if(distance < MIN_DISTANCE) {
            double angle = getAngle() - Math.PI;
            moveEntity(getSpeedX(angle), getSpeedY(angle));
        }
    }
}