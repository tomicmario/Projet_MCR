package Entities.Character;

import Entities.Entity;
import Entities.Renderer;
import Entities.Weapons.Pistol;
import Entities.Weapons.Projectile;
import Entities.Weapons.Shotgun;
import Entities.Weapons.Weapon;

public abstract class Being extends Entity {
    protected Weapon w;

    protected Being(int x, int y, int size, Renderer r) {
        super(x, y, size, r);
        w = new Shotgun(this);
    }

    public abstract Projectile[] attack();
}
