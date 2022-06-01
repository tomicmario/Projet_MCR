package GameObjects.Weapons;
import GameObjects.Entities.Entity;

public abstract class ProjectileWeapon implements Weapon {
    protected Entity e;
    protected int counter;
    protected final int PROJECTILE_SIZE;
    protected final int FIRE_RATE;
    protected final int PROJECTILE_SPEED;

    protected int damage;

    protected ProjectileWeapon(Entity e, int fireRate, int projectileSize, int projectileSpeed, int damage){
        this.FIRE_RATE = fireRate;
        this.PROJECTILE_SIZE = projectileSize;
        this.PROJECTILE_SPEED = projectileSpeed;
        this.counter = fireRate;
        this.e = e;
        this.damage = damage;
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
        return null;
    }

    public void setDelay(int delay){
        counter -= delay;
    }

    protected Projectile[] generateProjectiles(double angle){
        return new Projectile[]{new Projectile(angle , PROJECTILE_SPEED, PROJECTILE_SIZE, damage, false, e)};
    }
}
