package Entities.Weapons;
import Entities.Entity;

public abstract class Weapon {
    protected Entity e;
    protected int counter;
    protected final int PROJECTILE_SIZE;
    protected final int FIRE_RATE;
    protected final int PROJECTILE_SPEED;

    protected Weapon(Entity e, int fireRate, int projectileSize, int projectileSpeed){
        this.FIRE_RATE = fireRate;
        this.PROJECTILE_SIZE = projectileSize;
        this.PROJECTILE_SPEED = projectileSpeed;
        this.counter = fireRate;
        this.e = e;
    }

    public void nextFrame() {
        if(counter < FIRE_RATE){
            counter++;
        }
    }

    public Projectile[] fire(int currentX, int currentY, int targetX, int targetY){
        if(counter == FIRE_RATE){
            counter = 0;
            double angle = Math.atan2(targetY - currentY, targetX - currentX) - Math.PI / 4;
            return generateProjectiles(angle);
        }
        return new Projectile[0];
    }

    protected Projectile[] generateProjectiles(double angle){
        return new Projectile[]{new Projectile(e.getX(), e.getY(), angle , PROJECTILE_SPEED, PROJECTILE_SIZE)};
    }
}
