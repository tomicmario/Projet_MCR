package Entities.Character;

import Entities.Entity;
import Entities.Renderer;
import Entities.Weapons.Pistol;
import Entities.Weapons.Weapon;

public abstract class Being extends Entity {
    protected Weapon w;

    protected Being(Renderer r) {
        super(r);
        w = new Pistol(this);
    }

    public abstract void attack();
}
