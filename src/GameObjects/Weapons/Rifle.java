package GameObjects.Weapons;

import GameObjects.Entities.Entity;

import java.awt.*;

/**
 * Simple extension of the weapon class, creating a fast shooting rifle for the player.
 *
 * @author Mario Tomic
 */
public class Rifle extends Weapon {
    /**
     * Constructor of a rifle
     * @param entity Owner of the rifle
     */
    public Rifle(Entity entity) {
        super(entity);
        fireRate = 5;
    }

    @Override
    public Color getColor() {
        return Color.BLACK;
    }
}