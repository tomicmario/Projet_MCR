/*
 -----------------------------------------------------------------------------------
 Lab          : 03 (Projet)
 File         : Rifle.java
 Authors      : Janis Chiffelle, Yanik Lange, Mario Tomic
 Date         : 18/06/2022
 -----------------------------------------------------------------------------------
 */

package GameObjects.Weapons;

import GameObjects.Entities.Entity;
import java.awt.*;

/**
 * Simple extension of the weapon class, creating a fast shooting rifle for the player.
 *
 * @author Mario Tomic
 * @date 31.05.2022
 * @version Java 11
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