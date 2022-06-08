package GameObjects.Entities.Enemy;

import GameObjects.Entities.Enemy.Behaviour.Aggressive;
import GameObjects.Entities.Enemy.Behaviour.Behaviour;
import GameObjects.Entities.Enemy.Behaviour.Coward;
import GameObjects.Entities.Player.Player;
import GameObjects.Weapons.Pistol;

import java.awt.*;

public class Grunt extends Enemy{
    public Grunt(int x, int y, Player p) {
        super(x, y, 100, 100, p);
        this.behaviours = new Behaviour[]{new Aggressive(this, p)};
        this.currentWeapon = new Pistol(this);
        currentWeapon.setDelay(100);
    }

    @Override
    protected void checkBehaviourChanged() {

    }

    @Override
    public Color getColor() {
        return Color.RED;
    }

}
