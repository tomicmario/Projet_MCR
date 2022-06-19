package GameObjects.Entities.Enemy;

import GameObjects.Coordinates;
import GameObjects.Entities.Enemy.Behaviour.Aggressive;
import GameObjects.Entities.Enemy.Behaviour.Behaviour;
import GameObjects.Entities.Enemy.Behaviour.Coward;
import GameObjects.Weapons.*;
import java.awt.*;

/**
 * Tank class that creates snipers. A more sophisticated enemy of the game.
 * Inherits of Enemy.
 *
 * @author Janis Chiffelle, Yanik Lange, Mario Tomic
 * @date 31.05.2022
 * @version Java 11
 */
public class Tank extends Enemy{

    /**
     * Constructor of the class used to initialize the tanks in the game.
     *
     * @param x : The position x of the tanks.
     * @param y : The position y of the tanks.
     * @param target : The coordinates of the player on which the tank will focus his attacks.
     */
    public Tank(int x, int y, Coordinates target) {
        super(x, y, 300, 300, target);
        this.speed = 1;
    }

    @Override
    protected void defineBehaviours() {
        this.behaviours = new Behaviour[] { new Aggressive(this, target),
                new Coward(this, target) };
    }

    @Override
    protected void defineWeapons() {
        this.weapons = new Weapon[]{ new SlowShotgun(this),
                new Heal(this) };
        weapons[currentWeaponIndex].setDelay(100);
    }

    @Override
    protected void checkBehaviourChanged() {
        if(health <= MAX_HEALTH / 4 && currentWeaponIndex == 0){
            currentBehaviourIndex = 1;
            currentWeaponIndex = 1;
        } else if(health <= MAX_HEALTH / 2 && currentWeaponIndex == 1) {
            currentBehaviourIndex = 1;
        } else {
            currentBehaviourIndex = 0;
            currentWeaponIndex = 0;
        }
    }

    @Override
    public Color getColor() {
        return Color.GRAY;
    }
}
