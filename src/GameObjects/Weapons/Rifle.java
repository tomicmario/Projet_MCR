package GameObjects.Weapons;

import GameObjects.Entities.Entity;

public class Rifle extends ProjectileWeapon {
    public Rifle(Entity entity) {
        super(entity, 5, 5, 5, 25);
    }
}