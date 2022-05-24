package GameObjects.Entities.Enemy;

import GameObjects.Entities.Enemy.Behaviour.Balanced;
import GameObjects.Entities.Player.Player;
import GameObjects.Weapons.Pistol;

public class Sniper extends Enemy{
    public Sniper(int x, int y, Player p) {
        super(x, y, p);
        this.b = new Balanced(this, p);
        this.currentWeapon = new Pistol(this);
        this.speed = 2;
    }
}
