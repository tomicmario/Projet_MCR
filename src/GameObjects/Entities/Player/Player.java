package GameObjects.Entities.Player;

import GameObjects.Entities.Entity;
import GameObjects.Entities.EntityRenderer;
import GameObjects.Weapons.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Player class used to instanciate a player for the game.
 * Inherits of Entity.
 *
 * @author Janis Chiffelle, Yanik Lange, Mario Tomic
 * @date 04.05.2022
 * @version Java 11
 */
public class Player extends Entity {
    private static final int RADIUS = 5;
    protected int mouseX;
    protected int mouseY;
    protected boolean mouseClicked;
    protected int[] activeDirections;


    /**
     * Constructor of the class used to initialize the player in the game.
     *
     * @param x : The position x of the player.
     * @param y : The position y of the player.
     */
    public Player(int x, int y){
        super(x, y, RADIUS, 500, new EntityRenderer());
        weapons = new Weapon[]{ new Rifle(this), new Shotgun(this), new Flamethrower(this), new RocketLauncher(this)};
        mouseClicked = false;
        activeDirections = new int[Direction.values().length];
    }

    /**
     * Sets the click state for the player. //TODO
     *
     * @param clicked : Boolean that returns True if a mouse is clicked, False else.
     */
    public void setMouseClicked(boolean clicked){
        this.mouseClicked = clicked;
    }

    /**
     *
     * @param d : The direction of the player to set. So he moves in that direction.
     */
    public void setDirection(Direction d){
        activeDirections[d.ordinal()] = speed;
    }

    /**
     * 
     * @param d :  The direction of the player to unset. So he stops moving.
     */
    public void unsetDirection(Direction d){
        activeDirections[d.ordinal()] = 0;
    }

    public void setMousePosition(int x, int y){
        this.mouseX = x;
        this.mouseY = y;
    }

    /**
     *
     * @param angle : the angle of the player to be set.
     */
    public void setAngle(double angle) {
        this.angle = angle;
    }

    /**
     * Equip the next weapon that the player has.
     */
    public void equipNextWeapon(){
        currentWeaponIndex++;
        if(currentWeaponIndex >= weapons.length){
            currentWeaponIndex = 0;
        }
    }

    /**
     * Equip the previous weapon that the player has.
     */
    public void equipPreviousWeapon(){
        currentWeaponIndex--;
        if(currentWeaponIndex <= 0){
            currentWeaponIndex = weapons.length - 1;
        }
    }

    @Override
    public Projectile[] attack(){
        if(mouseClicked){
            return weapons[currentWeaponIndex].fire(x, y, mouseX, mouseY);
        }

        return null;
    }

    @Override
    public void move(){
        x += activeDirections[Direction.RIGHT.ordinal()] - activeDirections[Direction.LEFT.ordinal()];
        y += activeDirections[Direction.DOWN.ordinal()] - activeDirections[Direction.UP.ordinal()];
        weapons[currentWeaponIndex].nextFrame();
        setAngle(Math.atan2(mouseY - y, mouseX - x));
    }

    @Override
    public Color getColor(){
        return Color.CYAN;
    }

    @Override
    public Shape getShape(){
        return new Rectangle2D.Double(x, y, radius * 2, radius * 2);
    }


    @Override
    public int getPointsWhenKilled(){
        return 0;
    }

}
