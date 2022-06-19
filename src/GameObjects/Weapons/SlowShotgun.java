package GameObjects.Weapons;

import GameObjects.Entities.Entity;

/**
 * Specialisation of the shotgun with different stats. It is a variant given to the enemies, as the normal shotgun
 * would be way too strong for them.
 *
 * @author Mario Tomic
 * @date 31.05.2022
 * @version Java 11
 */
public class SlowShotgun extends Shotgun {
    private static final int DAMAGE_PER_PELLET = 30;

    /**
     * Constructor of the slow shotgun
     * @param entity Owner of the slow shotgun
     */
    public SlowShotgun(Entity entity) {
        super(entity);
        fireRate = 120;
        damage = DAMAGE_PER_PELLET;
        PELLET_SPREAD = Math.PI / 10;
        pellets = 3;
        projectileSize = 10;
        projectileSpeed = 4;
        projectileTimeToLive = 60;
    }

}