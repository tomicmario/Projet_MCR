package GameObjects.Weapons;

import GameObjects.Entities.Entity;

public class Pistol extends ProjectileWeapon {
    public Pistol(Entity entity) {
        super(entity, 60, 5, 3, 30);
    }
}
