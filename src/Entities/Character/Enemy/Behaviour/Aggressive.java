package Entities.Character.Enemy.Behaviour;

import Entities.Character.Enemy.Enemy;

public class Aggressive implements Behaviour{
    @Override
    public void move(Enemy e, int interestX, int interestY) {
        e.setCoordinates(interestX < e.getX() ? e.getX() - e.getSpeed() : e.getX() + e.getSpeed(),
                interestY < e.getY() ? e.getY() - e.getSpeed() : e.getY() + e.getSpeed());
    }
}
