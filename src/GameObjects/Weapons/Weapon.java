package GameObjects.Weapons;

public interface Weapon {
    Projectile[] fire(int currentX, int currentY, int targetX, int targetY);
    void setDelay(int delay);
}
