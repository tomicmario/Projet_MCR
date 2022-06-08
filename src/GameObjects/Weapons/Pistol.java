package GameObjects.Weapons;

import GameObjects.Entities.Entity;

import java.awt.*;

public class Pistol extends Weapon {
    public Pistol(Entity entity) {
        super(entity);
        fireRate = 60;
    }

    @Override
    public Color getColor() {
        return Color.GRAY;
    }
}
