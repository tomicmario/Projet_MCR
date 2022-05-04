package Entities.Weapons;
import Entities.Entity;
import Entities.Renderer;
import View.GameDisplay;

public abstract class Projectile extends Entity {
    protected GameDisplay view;

    protected Projectile(Renderer r){
        super(r);
        view = GameDisplay.getInstance();
    }

}
