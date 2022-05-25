package GameObjects.Weapons;

import GameObjects.Entities.Entity;

public class Flamethrower extends Weapon{
    public Flamethrower(Entity entity) {
        super(entity, 5, 5, 3);
    }

    @Override
    protected Projectile[] generateProjectiles(double angle) {
        Projectile p = new Projectile(e.getX(), e.getY(), angle , PROJECTILE_SPEED, PROJECTILE_SIZE){
            @Override
            public void move() {
                super.move();
                size++;
            }
        };
        Projectile[] projectiles = new Projectile[1];
        projectiles[0] = p;
        return projectiles;
    }
}
