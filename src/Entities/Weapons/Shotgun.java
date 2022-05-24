package Entities.Weapons;

import Entities.Entity;

public class Shotgun extends Weapon{
    private static final int PELLETS = 6;
    private static final double PELLET_SPREAD = Math.PI / 12;
    public Shotgun(Entity entity) {
        super(entity, 30, 3, 10);
    }

    @Override
    protected Projectile[] generateProjectiles(double angle) {
        Projectile[] projectiles = new Projectile[PELLETS];
        for(int i = 0, j = PELLETS - 1; i <= j; ++i, --j){
            projectiles[i] = new Projectile(e.getX(), e.getY(), angle - i * PELLET_SPREAD , PROJECTILE_SPEED, PROJECTILE_SIZE);
            projectiles[j] = new Projectile(e.getX(), e.getY(), angle + (i+1) * PELLET_SPREAD  , PROJECTILE_SPEED, PROJECTILE_SIZE);
        }
        return projectiles;
    }
}
