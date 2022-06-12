package GameObjects.Entities.Enemy;

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
     * @param p : The player on which the sniper will focus his attacks.
     */
    public Sniper(int x, int y, Player p){
        super(x, y, 100, 100, p);
        this.behaviours = new Behaviour[]{new Balanced(this, p), new Teleporting(this, p)};
        this.weapons = new Weapon[]{new Pistol(this)};
        this.speed = 2;
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
