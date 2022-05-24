package GameObjects.Entities.Enemy;

import GameObjects.Entities.Enemy.Behaviour.Aggressive;
import GameObjects.Entities.Player.Player;
import GameObjects.Weapons.Pistol;

public class Grunt extends Enemy{
    public Grunt(int x, int y, Player p) {
        super(x, y, p);
        this.b = new Aggressive(this, p);
        this.currentWeapon = new Pistol(this);
    }
}
