package GameObjects.Entities.Enemy;

import GameObjects.Entities.Enemy.Behaviour.Balanced;
import GameObjects.Entities.Player.Player;
import GameObjects.Weapons.Pistol;

import java.awt.*;

public class Sniper extends Enemy{
    public Sniper(int x, int y, Player p) {
        super(x, y, 100, 100, p);
        this.b = new Balanced(this, p);
        this.currentWeapon = new Pistol(this);
        this.speed = 2;
        currentWeapon.setDelay(100);
    }

    @Override
    public Color getColor() {
        return Color.MAGENTA;
    }
}
