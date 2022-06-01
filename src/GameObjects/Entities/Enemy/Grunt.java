package GameObjects.Entities.Enemy;

import GameObjects.Entities.Enemy.Behaviour.Aggressive;
import GameObjects.Entities.Enemy.Behaviour.Coward;
import GameObjects.Entities.Player.Player;
import GameObjects.Weapons.Pistol;

import java.awt.*;

public class Grunt extends Enemy{
    public Grunt(int x, int y, Player p) {
        super(x, y, 100, 100, p);
        this.b = new Aggressive(this, p);
        this.currentWeapon = new Pistol(this);
        currentWeapon.setDelay(100);
    }

    @Override
    public Color getColor() {
        return Color.RED;
    }

    @Override
    public void move() {
        if(health < MAX_HEALTH / 2 && !(b instanceof Coward)){
            b = new Coward(this, p);
        }
        currentWeapon.nextFrame();
        b.move();
    }


}
