package GameObjects.Weapons;

import GameObjects.Entities.Entity;

public class SlowShotgun extends Shotgun {
    private static final int DAMAGE_PER_PELLET = 30;
    public SlowShotgun(Entity entity) {
        super(entity);
        fireRate = 120;
        damage = DAMAGE_PER_PELLET;
        PELLET_SPREAD = Math.PI / 10;
        PELLETS = 3;
        projectileSize = 10;
        projectileSpeed = 3;
    }

}