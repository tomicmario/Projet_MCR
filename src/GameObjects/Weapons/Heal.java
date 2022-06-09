package GameObjects.Weapons;

import GameObjects.Entities.Entity;

import java.awt.*;

public class Heal extends Weapon{
    public Heal(Entity entity) {
        super(entity);
        projectileSpeed = 0;
        fireRate = 30;
        damage = -2;
        persistentProjectile = true;
        projectileTimeToLive = 10;
    }

    @Override
    protected Projectile[] generateProjectiles(double angle) {
        Projectile p = new Projectile(angle, projectileSpeed, projectileSize,
                damage, persistentProjectile, e, projectileTimeToLive){
            @Override
            public void move() {
                super.move();
                size += 3;
            }

            @Override
            public Entity getShooter() {
                return null;
            }

            @Override
            public Color getColor(){
                return Color.GREEN;
            }
        };
        Projectile[] projectiles = new Projectile[1];
        projectiles[0] = p;
        return projectiles;
    }

    @Override
    public Color getColor() {
        return Color.GREEN;
    }
}
