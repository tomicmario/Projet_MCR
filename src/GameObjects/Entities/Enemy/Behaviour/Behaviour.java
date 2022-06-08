package GameObjects.Entities.Enemy.Behaviour;

import GameObjects.Entities.Enemy.Enemy;
import GameObjects.Entities.Entity;


public abstract class Behaviour {
    protected final Enemy e;
    protected final Entity target;

    protected Behaviour(Enemy e, Entity target){
        this.e = e;
        this.target = target;
    }

    public abstract void move();

    protected double getAngle(){
        return Math.atan2(target.getY() - e.getY(), target.getX() - e.getX()) - Math.PI / 4;
    }

    protected int getDistance(){
        return (int)Math.round( Math.sqrt( (target.getX() - e.getX()) * (target.getX() - e.getX()) + (target.getY() - e.getY()) * (target.getY() - e.getY()) ) );
    }

    protected int getSpeedX(double angle){
        return (int) (e.getSpeed() * Math.cos(angle) - e.getSpeed() * Math.sin(angle));
    }

    protected int getSpeedY(double angle){
        return (int) (e.getSpeed() * Math.sin(angle) + e.getSpeed() * Math.cos(angle));
    }

    protected void moveEntity(int speedX, int speedY){
        e.setCoordinates(e.getX() + speedX, e.getY() + speedY);
    }
}
