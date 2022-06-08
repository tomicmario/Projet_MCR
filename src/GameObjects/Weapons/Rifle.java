package GameObjects.Weapons;

import GameObjects.Entities.Entity;

import java.awt.*;

public class Rifle extends Weapon {
    public Rifle(Entity entity) {
        super(entity);
        fireRate = 5;
    }

    @Override
    public Color getColor() {
        return Color.BLACK;
    }
}