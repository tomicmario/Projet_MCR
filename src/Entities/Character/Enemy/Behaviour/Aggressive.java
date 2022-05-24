package Entities.Character.Enemy.Behaviour;

import Entities.Character.Enemy.Enemy;
import Entities.Entity;

public class Aggressive implements Behaviour{
    private final Enemy e;
    private final Entity target;

    public Aggressive(Enemy e, Entity target){
        this.e = e;
        this.target = target;
    }
    @Override
    public void move() {
        double angle = Math.atan2(target.getY() - e.getY(), target.getX() - e.getX()) - Math.PI / 4;
        int speedX = (int)(e.getSpeed() * Math.cos(angle) - e.getSpeed() * Math.sin(angle));
        int speedY = (int)(e.getSpeed() * Math.sin(angle) + e.getSpeed() * Math.cos(angle));
        e.setCoordinates(e.getX() + speedX, e.getY() + speedY);
    }
}
