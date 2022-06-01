package GameObjects.Weapons;

import GameObjects.Entities.Entity;

public class Rifle extends BaseWeapon {
    public Rifle(Entity entity) {
        super(entity);
        fireRate = 5;
    }
}