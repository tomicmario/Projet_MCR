package GameObjects.Weapons;

import GameObjects.Entities.Entity;

import java.awt.*;

public class Flamethrower extends Weapon {
    public Flamethrower(Entity entity) {
        super(entity);
        projectileSpeed = 3;
        fireRate = 5;
        damage = 20;
        persistentProjectile = true;
        projectileTimeToLive = 45;
    }

    @Override
    protected Projectile[] generateProjectiles(double angle) {
        Projectile p = new Projectile(angle, projectileSpeed, projectileSize,
                                        damage, persistentProjectile, e, projectileTimeToLive){
            @Override
            public void move() {
                super.move();
                size++;
                damage = damage == 3 ? damage : damage - 1;
            }

            @Override
            public Color getColor(){
                return Color.ORANGE;
            }
        };
        Projectile[] projectiles = new Projectile[1];
        projectiles[0] = p;
        return projectiles;
    }

    @Override
    public Color getColor() {
        return Color.BLUE;
    }

}
