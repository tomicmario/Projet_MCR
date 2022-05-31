package GameObjects.Entities.Enemy;

import GameObjects.Entities.Enemy.Behaviour.Aggressive;
import GameObjects.Entities.Player.Player;
import GameObjects.Weapons.Pistol;
import GameObjects.Weapons.Shotgun;
import GameObjects.Weapons.SlowShotgun;

import java.awt.*;

public class Tank extends Enemy{

    public Tank(int x, int y, Player p) {
        super(x, y, 300, p);
        this.b = new Aggressive(this, p);
        this.speed = 1;
        this.currentWeapon = new SlowShotgun(this);
        currentWeapon.setDelay(100);
    }

    @Override
    public Color getColor() {
        return Color.GRAY;
    }
}
