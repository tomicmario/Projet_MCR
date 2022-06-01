package GameObjects.Weapons;

import GameObjects.Entities.Entity;

public class Pistol extends BaseWeapon {
    public Pistol(Entity entity) {
        super(entity);
        fireRate = 60;
    }
}
