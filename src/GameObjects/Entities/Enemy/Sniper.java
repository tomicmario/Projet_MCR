package GameObjects.Entities.Enemy;

import GameObjects.Entities.Enemy.Behaviour.*;
import GameObjects.Entities.Player.Player;
import GameObjects.Weapons.Pistol;
import GameObjects.Weapons.Weapon;

import java.awt.*;

public class Sniper extends Enemy{
    public Sniper(int x, int y, Player p) {
        super(x, y, 100, 100, p);
        this.behaviours = new Behaviour[]{new Balanced(this, p), new Distant(this, p)};
        this.weapons = new Weapon[]{new Pistol(this)};
        this.speed = 2;
        weapons[currentWeaponIndex].setDelay(100);
    }

    @Override
    public void move() {
        super.move();
    }

    @Override
    protected void checkBehaviourChanged() {
        if(health != MAX_HEALTH){
            currentBehaviourIndex = 1;
        }
    }

    @Override
    public Color getColor() {
        return Color.MAGENTA;
    }
}
