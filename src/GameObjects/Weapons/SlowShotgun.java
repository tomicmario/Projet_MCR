package GameObjects.Weapons;

import GameObjects.Entities.Entity;

public class SlowShotgun extends Weapon{
    private static final int PELLETS = 3;
    private static final int DAMAGE_PER_PELLET = 30;
    private static final double PELLET_SPREAD = Math.PI / 30;
    public SlowShotgun(Entity entity) {
        super(entity, 120, 3, 5, DAMAGE_PER_PELLET);
    }

    @Override
    protected Projectile[] generateProjectiles(double angle) {
        Projectile[] projectiles = new Projectile[PELLETS];
        for(int i = 0, j = PELLETS - 1; i < j; ++i, --j){
            projectiles[i] = new Projectile(e.getX(), e.getY(), angle - (i+1) * PELLET_SPREAD , PROJECTILE_SPEED, PROJECTILE_SIZE, DAMAGE_PER_PELLET, e);
            projectiles[j] = new Projectile(e.getX(), e.getY(), angle + (i+1) * PELLET_SPREAD  , PROJECTILE_SPEED, PROJECTILE_SIZE, DAMAGE_PER_PELLET, e);
        }
        if(PELLETS % 2 == 1){
            projectiles[PELLETS / 2] = new Projectile(e.getX(), e.getY(), angle , PROJECTILE_SPEED, PROJECTILE_SIZE, DAMAGE_PER_PELLET, e);
        }
        return projectiles;
    }
}