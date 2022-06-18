package GameObjects.Entities.Enemy;

import GameObjects.Coordinates;
import GameObjects.Entities.Enemy.Behaviour.Aggressive;
import GameObjects.Entities.Enemy.Behaviour.Behaviour;
import GameObjects.Entities.Player.Player;
import GameObjects.Weapons.Flamethrower;
import GameObjects.Weapons.Pistol;
import GameObjects.Weapons.Weapon;
import java.awt.*;

/**
 * Grunt class that creates grunts. The basic enemy of the game.
 * Inherits of Enemy.
 */
public class Grunt extends Enemy {

    /**
     * Constructor of the class used to initialize the grunts in the game.
     *
     * @param x : The position x of the grunt.
     * @param y : The position y of the grunt.
     * @param target : The coordinates of the target on which the grunt will focus his attacks.
     */
    public Grunt(int x, int y, Coordinates target){
        super(x, y, 100, 100, target);
        this.behaviours = new Behaviour[]{new Aggressive(this, target)};
        this.weapons = new Weapon[]{new Flamethrower(this)};
        weapons[currentWeaponIndex].setDelay(100);
    }

    @Override
    protected void checkBehaviourChanged() {
        // TODO
    }

    @Override
    public Color getColor() {
        return Color.RED;
    }

}
