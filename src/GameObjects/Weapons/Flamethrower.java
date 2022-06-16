package GameObjects.Weapons;

import GameObjects.Entities.Entity;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Flamethrower extends Weapon {
    public Flamethrower(Entity entity) {
        super(entity);
        projectileSpeed = 3;
        projectileSize = 2;
        fireRate = 3;
        damage = 20;
        persistentProjectile = true;
        projectileTimeToLive = 30;
    }

    @Override
    protected Projectile[] generateProjectiles(double angle) {
        Projectile p = new Projectile(angle, projectileSpeed, projectileSize,
                                        damage, persistentProjectile, e, projectileTimeToLive){
            @Override
            public void move() {
                super.move();
                radius++;
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
