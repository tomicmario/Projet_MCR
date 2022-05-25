package GameObjects.Entities.Enemy.Behaviour;

import GameObjects.Entities.Enemy.Enemy;
import GameObjects.Entities.Entity;

public class Aggressive implements Behaviour{
    private static final int MIN_DISTANCE = 30;
    private final Enemy e;
    private final Entity target;

    public Aggressive(Enemy e, Entity target){
        this.e = e;
        this.target = target;
    }
    @Override
    public void move() {
        int distance = (int)Math.round( Math.sqrt( (target.getX() - e.getX()) * (target.getX() - e.getX()) + (target.getY() - e.getY()) * (target.getY() - e.getY()) ) );
        if(distance > MIN_DISTANCE) {
            double angle = Math.atan2(target.getY() - e.getY(), target.getX() - e.getX()) - Math.PI / 4;
            int speedX = (int) (e.getSpeed() * Math.cos(angle) - e.getSpeed() * Math.sin(angle));
            int speedY = (int) (e.getSpeed() * Math.sin(angle) + e.getSpeed() * Math.cos(angle));
            e.setCoordinates(e.getX() + speedX, e.getY() + speedY);
        }
    }
}
