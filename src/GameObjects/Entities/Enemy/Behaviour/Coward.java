package GameObjects.Entities.Enemy.Behaviour;

import GameObjects.Entities.Enemy.Enemy;
import GameObjects.Entities.Entity;

public class Coward extends Behaviour {

    public Coward(Enemy e, Entity target){
        super(e, target);
        e.setCanShoot(false);
    }

    @Override
    public void move() {
        double angle = getAngle() - Math.PI;
        moveEntity(getSpeedX(angle), getSpeedY(angle));
    }
}