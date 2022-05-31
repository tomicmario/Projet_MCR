package GameObjects.Weapons;

import GameObjects.Entities.Entity;

import java.awt.*;

public class Flamethrower extends Weapon{
    public Flamethrower(Entity entity) {
        super(entity, 5, 5, 3, 20);
    }

    @Override
    protected Projectile[] generateProjectiles(double angle) {
        Projectile p = new Projectile(angle, PROJECTILE_SPEED, PROJECTILE_SIZE, damage, true, e, 45){
            @Override
            public void move() {
                super.move();
                size++;
                damage = damage == 1 ? damage : damage - 1;
            }

            @Override
            public Color getColor(){
                return Color.ORANGE;
            }
        };
        Projectile[] projectiles = new Projectile[1];
        projectiles[0] = p;
        return projectiles;
    }

}
