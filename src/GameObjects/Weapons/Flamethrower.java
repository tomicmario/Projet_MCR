/*
 -----------------------------------------------------------------------------------
 Lab          : 03 (Projet)
 File         : Flamethrower.java
 Authors      : Janis Chiffelle, Yanik Lange, Mario Tomic
 Date         : 18/06/2022
 -----------------------------------------------------------------------------------
 */

package GameObjects.Weapons;

import GameObjects.Entities.Entity;
import java.awt.*;

/**
 * Weapon that fires expanding projectiles at a quick pace.
 *
 * @author Mario Tomic
 */
public class Flamethrower extends Weapon {

    /**
     * Constructor of the flamethrower
     * @param entity Owner of the flamethrower
     */
    public Flamethrower(Entity entity) {
        super(entity);
        projectileSpeed = 3;
        projectileSize = 2;
        fireRate = 3;
        damage = 20;
        persistentProjectile = true;
        projectileTimeToLive = 37;
    }

    @Override
    protected Projectile generateSingleProjectile(double angle) {

        return  new Projectile(angle, projectileSpeed, projectileSize,
                                        damage, persistentProjectile, e, projectileTimeToLive){
            @Override
            public void move() {
                super.move();
                radius++;
                damage = damage == 1 ? damage : damage - 1;
            }

            @Override
            public Color getColor(){
                return Color.ORANGE;
            }
        };
    }

    @Override
    public Color getColor() {
        return Color.BLUE;
    }

}
