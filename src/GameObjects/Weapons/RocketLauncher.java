package GameObjects.Weapons;

import GameObjects.Entities.Entity;
import GameObjects.GameObject;

import java.awt.*;

/**
 * Weapon launching projectiles with a special behaviour.
 * It behaves as a normal projectile until a collision with an entity happens. After the collision, the
 * projectile becomes persistent and grows, while also changing color, simulating an explosion.
 *
 * @author Mario Tomic
 * @date 31.05.2022
 * @version Java 11
 */
public class RocketLauncher extends Weapon {
    private static final int EXPLOSION_RADIUS = 10;

    /**
     * Constructor of a rocket launcher
     * @param entity Owner of the rocket launcher
     */
    public RocketLauncher(Entity entity){
        super(entity);
        fireRate = 45;
        damage = 50;
    }


    @Override
    public Color getColor() {
        return Color.RED;
    }

    @Override
    protected Projectile generateSingleProjectile(double angle) {
        return new Projectile(angle, projectileSpeed, projectileSize,
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
            public GameObject getShooter(){
                if(persistent){
                    return null;
                }
                return shooter;
            }
        };
    }
}
