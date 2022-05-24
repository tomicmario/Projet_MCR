package Entities.Character.Enemy;

import Entities.Character.Enemy.Behaviour.Defensive;
import Entities.Character.Player.Player;
import Entities.Weapons.Pistol;

public class Sniper extends Enemy{
    public Sniper(int x, int y, Player p) {
        super(x, y, p);
        this.b = new Defensive(this, p);
        this.currentWeapon = new Pistol(this);
        this.speed = 2;
    }
}
