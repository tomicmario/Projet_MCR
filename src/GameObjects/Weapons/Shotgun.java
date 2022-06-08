package GameObjects.Weapons;

import GameObjects.Entities.Entity;

public class Shotgun extends Weapon {
    protected int PELLETS = 13;
    private static final int DAMAGE_PER_PELLET = 30;
    protected double PELLET_SPREAD = Math.PI / 24;
    public Shotgun(Entity entity) {
        super(entity);
        damage = DAMAGE_PER_PELLET;
        projectileSpeed = 10;
        fireRate = 30;
    }

    @Override
    protected Projectile[] generateProjectiles(double angle) {
        Projectile[] projectiles = new Projectile[PELLETS];
        for(int i = 0, j = PELLETS - 1; i < j; ++i, --j){
            projectiles[i] = generateSingleProjectile(angle - (i+1) * PELLET_SPREAD );
            projectiles[j] = generateSingleProjectile(angle + (i+1) * PELLET_SPREAD );
        }
        if(PELLETS % 2 == 1){
            projectiles[PELLETS / 2] = generateSingleProjectile(angle);
        }
        return projectiles;
    }
}
