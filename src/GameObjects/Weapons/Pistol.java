package GameObjects.Weapons;

import GameObjects.Entities.Entity;

import java.awt.*;

/**
 * Simple extension of the weapon class, creating a slow shooting pistol for the enemies.
 *
 * @author Mario Tomic
 */
public class Pistol extends Weapon {
    /**
     * Constructor of the pistol
     * @param entity Owner of the Pistol
     */
    public Pistol(Entity entity) {
        super(entity);
        fireRate = 60;
    }

    @Override
    public Color getColor() {
        return Color.GRAY;
    }
}
