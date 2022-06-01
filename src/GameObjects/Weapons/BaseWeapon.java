package GameObjects.Weapons;
import GameObjects.Entities.Entity;

public abstract class BaseWeapon implements Weapon {
    protected Entity e;
    protected int counter;
    protected int projectileSize;
    protected int fireRate;
    protected int projectileSpeed;
    protected int projectileTimeToLive;
    protected boolean persistentProjectile;
    protected int damage;

    protected BaseWeapon(Entity e){
        this.e = e;
        fireRate = 20;
        projectileSize = 5;
        projectileSpeed = 5;
        damage = 25;
        persistentProjectile = false;
        projectileTimeToLive = 300;
    }

    public void nextFrame() {
        if(counter < fireRate){
            counter++;
        }
    }

    public Projectile[] fire(int currentX, int currentY, int targetX, int targetY){
        if(counter == fireRate){
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
        return new Projectile[] { generateSingleProjectile(angle) };
    }

    protected Projectile generateSingleProjectile(double angle){
        return new Projectile(angle, projectileSpeed, projectileSize, damage, persistentProjectile, e);
    }
}
