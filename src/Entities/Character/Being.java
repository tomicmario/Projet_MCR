package Entities.Character;

import Entities.Entity;
import Entities.Renderer;
import Entities.Weapons.Projectile;
import Entities.Weapons.Weapon;

public abstract class Being extends Entity {
    protected Weapon currentWeapon;

    protected Being(int x, int y, int size, Renderer r) {
        super(x, y, size, r);
    }

    public abstract Projectile[] attack();

    protected void checkBounds(int maxWidth, int maxHeight) {
        // Width check
        if(x >= maxWidth - size || x <= 0) {
            x = x <= 0 ? 0 : maxWidth - size;
        }
        // Height check
        if(y >= maxHeight - size || y <= 0) {
            y = y <= 0 ? 0 : maxHeight - size;
        }
    }

}
