package GameObjects.Weapons;

import GameObjects.Entities.Entity;

public class Unarmed extends BaseWeapon {
    public Unarmed(Entity e) {
        super(e, 0, 0, 0, 0);
    }

    @Override
    protected Projectile[] generateProjectiles(double angle) {
        return null;
    }

}
