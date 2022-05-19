package Entities.Character.Enemy.Behaviour;

import Entities.Character.Enemy.Enemy;

public class Defensive implements Behaviour {
    private final int TOLERABLE_DISTANCE_CLOSE = 100;
    private final int TOLERABLE_DISTANCE_FAR = 300;

    @Override
    public void move(Enemy e, int interestX, int interestY) {
        int distanceX = e.getX() - interestX;
        int distanceY = e.getY() - interestY;
        if(Math.abs(distanceX) < TOLERABLE_DISTANCE_CLOSE){
            e.setX(distanceX < 0 ? e.getX() - e.getSpeed() : e.getX() + e.getSpeed());
        }
        else if(Math.abs(distanceX) < TOLERABLE_DISTANCE_FAR){
            e.setX(distanceX > 0 ? e.getX() - e.getSpeed() : e.getX() + e.getSpeed());
        }

        if(Math.abs(distanceY) < TOLERABLE_DISTANCE_CLOSE){
            e.setY(distanceY < 0 ? e.getY() - e.getSpeed() : e.getY() + e.getSpeed());
        }
        else if(Math.abs(distanceY) < TOLERABLE_DISTANCE_FAR){
            e.setY(distanceY > 0 ? e.getY() - e.getSpeed() : e.getY() + e.getSpeed());
        }
    }
}
