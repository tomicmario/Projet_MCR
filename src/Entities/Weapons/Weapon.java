package Entities.Weapons;
import Entities.Entity;
import Entities.Renderer;
import View.GameDisplay;

public abstract class Weapon extends Entity {
    protected Renderer r;
    protected Entity e;
    protected GameDisplay view;
    protected final int width = 10;
    protected final int height = 50;
    protected final int FIRE_RATE = 10;
    protected int counter = FIRE_RATE;

    protected Weapon(Renderer r, Entity e){
        super(r);
        this.r = r;
        this.e = e;
        this.view = GameDisplay.getInstance();
    }

    public abstract Projectile[] fire(int currentX, int currentY, int targetX, int targetY);
}
