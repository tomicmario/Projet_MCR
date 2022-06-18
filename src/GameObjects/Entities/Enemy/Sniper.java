package GameObjects.Entities.Enemy;

import GameObjects.Coordinates;
import GameObjects.Entities.Enemy.Behaviour.*;
import GameObjects.Entities.Player.Player;
import GameObjects.Weapons.Pistol;
import GameObjects.Weapons.Weapon;
import java.awt.*;

/**
 * Sniper class that creates snipers. A more sophisticated enemy of the game.
 * Inherits of Enemy.
 */
public class Sniper extends Enemy {

    /**
     * Constructor of the class used to initialize the snipers in the game.
     *
     * @param x : The position x of the sniper.
     * @param y : The position y of the sniper.
     * @param target : The coordinates of the player on which the sniper will focus his attacks.
     */
    public Sniper(int x, int y, Coordinates target){
        super(x, y, 100, 100, target);
        this.behaviours = new Behaviour[] { new Balanced(this, target),
                                                new Teleporting(this, target) };
        this.weapons = new Weapon[] { new Pistol(this) };
        weapons[currentWeaponIndex].setDelay(100);
    }

    @Override
    protected void checkBehaviourChanged(){
        if(getHealthRatio() <= 0.25){
            currentBehaviourIndex = 1;
        }
    }

    @Override
    public Color getColor(){
        return Color.MAGENTA;
    }
}
