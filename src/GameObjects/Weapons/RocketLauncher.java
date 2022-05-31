package GameObjects.Weapons;

import GameObjects.Entities.Entity;

import java.awt.*;

public class RocketLauncher extends Weapon{
    public RocketLauncher(Entity entity){
        super(entity, 30, 5, 5, 0);
    }

    @Override
    protected Projectile[] generateProjectiles(double angle) {
        Projectile p = new Projectile(angle, PROJECTILE_SPEED, PROJECTILE_SIZE, damage, false, e, 300){
            @Override
            public void move() {
                x += speedX;
                y += speedY;
                timeToLive--;
            }

            @Override
            public boolean isActive(){
                return timeToLive > -10;
            }
            @Override
            public void setActive(boolean isActive){
                this.isActive = false;
                speedX = 0;
                speedY = 0;
                persistent = true;
                timeToLive = 0;
                damage = 2;
                size = 50;
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
