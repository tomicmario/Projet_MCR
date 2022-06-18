/*
 -----------------------------------------------------------------------------------
 Lab          : 03 (Projet)
 File         : Heal.java
 Authors      : Janis Chiffelle, Yanik Lange, Mario Tomic
 Date         : 18/06/2022
 -----------------------------------------------------------------------------------
 */

package GameObjects.Weapons;

import GameObjects.Entities.Entity;
import java.awt.*;

/**
 * Healing weapon, creating a small expanding radius with negative damage.
 *
 * @author Mario Tomic
 */
public class Heal extends Weapon{
    private static final int RADIUS_EXPANSION = 4;

    /**
     * Constructor of the healing weapon
     * @param entity Owner of the healing weapon
     */
    public Heal(Entity entity) {
        super(entity);
        projectileSpeed = 0;
        fireRate = 30;
        damage = -2;
        persistentProjectile = true;
        projectileTimeToLive = 10;
    }

    @Override
    protected Projectile generateSingleProjectile(double angle) {
        return new Projectile(angle, projectileSpeed, projectileSize,
                damage, persistentProjectile, e, projectileTimeToLive){
            @Override
            public void move() {
                super.move();
                radius += RADIUS_EXPANSION;
                x -= RADIUS_EXPANSION / 2;
                y -= RADIUS_EXPANSION / 2;
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
    }

    @Override
    public Color getColor() {
        return Color.GREEN;
    }
}
