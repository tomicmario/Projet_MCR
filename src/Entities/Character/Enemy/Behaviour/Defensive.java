package Entities.Character.Enemy.Behaviour;

import Entities.Character.Enemy.Enemy;
import Entities.Entity;

import java.util.Random;

public class Defensive implements Behaviour {
    private final int TOLERABLE_DISTANCE_CLOSE = 150;
    private final int TOLERABLE_DISTANCE_FAR = 200;
    private final Enemy e;
    private final Entity target;

    private int speedX;
    private int speedY;
    private final int TIME_UNTIL_REFRESH = 10;
    private int counter = 0;
    Random r;

    public Defensive(Enemy e, Entity target){
        this.e = e;
        this.target = target;
        this.r = new Random();
    }

    @Override
    public void move() {
        int distance = (int)Math.round( Math.sqrt( (target.getX() - e.getX()) * (target.getX() - e.getX()) + (target.getY() - e.getY()) * (target.getY() - e.getY()) ) );
        if(counter >= TIME_UNTIL_REFRESH){
            counter = -1;
            double angle = Math.atan2(target.getY() - e.getY(), target.getX() - e.getX()) - Math.PI / 4;
            if(distance < TOLERABLE_DISTANCE_CLOSE){
                angle -= Math.PI;
            } else if (distance < TOLERABLE_DISTANCE_FAR) {
                angle =  (Math.PI * 2) * r.nextDouble();
            }
            speedX = (int)(e.getSpeed() * Math.cos(angle) - e.getSpeed() * Math.sin(angle));
            speedY = (int)(e.getSpeed() * Math.sin(angle) + e.getSpeed() * Math.cos(angle));
        }
        movePredicted();
        counter++;
    }

    private void movePredicted(){
        e.setCoordinates(e.getX() + speedX, e.getY() + speedY);
    }
}
