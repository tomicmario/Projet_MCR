package Entities.Character.Enemy;

import Entities.Character.Enemy.Behaviour.Aggressive;
import Entities.Character.Player.Player;
import Entities.Weapons.Pistol;

public class Grunt extends Enemy{
    public Grunt(int x, int y, Player p) {
        super(x, y, p);
        this.b = new Aggressive();
        this.currentWeapon = new Pistol(this);
    }
}
