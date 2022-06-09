package GameObjects.Entities.Enemy;

import GameObjects.Entities.Enemy.Behaviour.Aggressive;
import GameObjects.Entities.Enemy.Behaviour.Behaviour;
import GameObjects.Entities.Enemy.Behaviour.Coward;
import GameObjects.Entities.Enemy.Behaviour.Distant;
import GameObjects.Entities.Player.Player;
import GameObjects.Weapons.*;

import java.awt.*;

public class Tank extends Enemy{

    public Tank(int x, int y, Player p) {
        super(x, y, 300, 300, p);
        this.behaviours = new Behaviour[]{new Aggressive(this, p), new Coward(this, p)};
        this.speed = 1;
        this.weapons = new Weapon[]{new SlowShotgun(this), new Heal(this)};
        weapons[currentWeaponIndex].setDelay(100);
    }

    @Override
    public Color getColor() {
        return Color.GRAY;
    }

    @Override
    protected void checkBehaviourChanged() {
        if(health <= MAX_HEALTH / 4 && currentWeaponIndex == 0){
            currentBehaviourIndex = 1;
            currentWeaponIndex = 1;
        } else if(health <= MAX_HEALTH / 2 && currentWeaponIndex == 1) {
            currentBehaviourIndex = 1;
            currentWeaponIndex = 1;
        } else {
            currentBehaviourIndex = 0;
            currentWeaponIndex = 0;
        }
    }
}
