package GameObjects.Weapons;

import GameObjects.Entities.Entity;

import java.awt.*;

public class RocketLauncher extends Weapon {
    private static final int EXPLOSION_RADIUS = 10;
    public RocketLauncher(Entity entity){
        super(entity);
        fireRate = 45;
        damage = 50;
    }

    @Override
    protected Projectile[] generateProjectiles(double angle) {
        Projectile p = new Projectile(angle, projectileSpeed, projectileSize,
                                        damage, persistentProjectile, e, projectileTimeToLive){
            @Override
            public void move() {
                x += speedX;
                y += speedY;
                timeToLive--;
                if(persistent){
                    radius += EXPLOSION_RADIUS;
                    x -= EXPLOSION_RADIUS / 2;
                    y -= EXPLOSION_RADIUS / 2;
                }
            }

            @Override
            public void setInactive(){
                speedX = 0;
                speedY = 0;
                persistent = true;
                timeToLive = 6;
                radius = EXPLOSION_RADIUS;
            }
            @Override
            public Color getColor(){
                return persistent ? Color.ORANGE : Color.BLACK;
            }

            @Override
            public Entity getShooter(){
                if(persistent){
                    return null;
                }
                return shooter;
            }
        };
        Projectile[] projectiles = new Projectile[1];
        projectiles[0] = p;
        return projectiles;
    }

    @Override
    public Color getColor() {
        return Color.RED;
    }
}
