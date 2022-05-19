package Entities.Weapons;
import Entities.Entity;
import Entities.Renderer;
import View.GameDisplay;

public abstract class Weapon extends Entity {
    protected Renderer r;
    protected Entity e;
    protected final int width = 10;
    protected final int height = 50;
    protected final int FIRE_RATE = 15;
    protected int counter = FIRE_RATE;

    protected Weapon(Renderer r, Entity e, int size){
        super(e.getX(), e.getY(),size, r);
        this.r = r;
        this.e = e;
    }

    @Override
    public void move(int maxWidth, int maxHeight) {
        if(counter < FIRE_RATE){
            counter++;
        }
    }

    public abstract Projectile[] fire(int currentX, int currentY, int targetX, int targetY);
}
