package GameObjects.Weapons;

import GameObjects.Entities.Entity;

import java.awt.*;

public class RocketLauncher extends BaseWeapon {
    public RocketLauncher(Entity entity){
        super(entity);
        fireRate = 60;
        damage = 0;
    }

    @Override
    protected Projectile[] generateProjectiles(double angle) {
        Projectile p = new Projectile(angle, projectileSpeed, projectileSize, damage, false, e, 300){
            @Override
            public void move() {
                x += speedX;
                y += speedY;
                timeToLive--;
                if(persistent){
                    size += 10;
                }
            }

            @Override
            public boolean isActive(){
                return timeToLive > 0;
            }
            @Override
            public void setActive(boolean isActive){
                this.isActive = false;
                speedX = 0;
                speedY = 0;
                persistent = true;
                timeToLive = 5;
                damage = 50;
                size = 10;
            }
            @Override
            public Color getColor(){
                return damage == 0 ? Color.BLACK : Color.ORANGE;
            }
        };
        Projectile[] projectiles = new Projectile[1];
        projectiles[0] = p;
        return projectiles;
    }
}
