package GameObjects.Weapons;

import GameObjects.Entities.Entity;
import java.awt.*;

/**
 * Shotgun class, creating a weapon that fires multiple projectiles, forming a small segment of circle
 *
 * @author Mario Tomic
 * @date 19.05.2022
 * @version Java 11
 */
public class Shotgun extends Weapon {
    protected int pellets = 11;
    private static final int DAMAGE_PER_PELLET = 45;
    protected double PELLET_SPREAD = Math.PI / 30;

    /**
     * Constructor of a shotgun
     * @param entity Owner of the shotgun
     */
    public Shotgun(Entity entity) {
        super(entity);
        damage = DAMAGE_PER_PELLET;
        projectileSpeed = 10;
        fireRate = 45;
        projectileTimeToLive = 15;
    }

    @Override
    protected Projectile[] generateProjectiles(double angle) {
        Projectile[] projectiles = new Projectile[pellets];
        // Generates a couple of projectiles in a < pattern, with the angle growing every iteration
        for(int i = 0, j = pellets - 1; i < j; ++i, --j){
            projectiles[i] = generateSingleProjectile(angle - (i+1) * PELLET_SPREAD );
            projectiles[j] = generateSingleProjectile(angle + (i+1) * PELLET_SPREAD );
        }

        // Generates the projectile shooting at the angle of the shooter
        if(pellets % 2 == 1){
            projectiles[pellets / 2] = generateSingleProjectile(angle);
        }
        return projectiles;
    }

    @Override
    public Color getColor() {
        return Color.PINK;
    }
}
