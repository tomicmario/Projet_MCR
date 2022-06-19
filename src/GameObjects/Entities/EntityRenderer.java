package GameObjects.Entities;

import GameObjects.Renderer;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

/**
 * Assists the rendering of a bouncer that is filled with a color
 *
 * @author Janis Chiffelle, Yanik Lange, Mario Tomic
 * @date 24.05.2022
 * @version Java 11
 */
public class EntityRenderer implements Renderer {

    @Override
    public void display(Graphics2D g, Entity e) {
        displayHealthBar(g, e);
        displayEntity(g, e);
        displayWeapon(g, e);
    }

    /**
     * Draws the entity
     * @param g Graphics of the display
     * @param e Entity to render
     */
    private void displayEntity(Graphics2D g, Entity e){
        int cx = e.getRadius();
        int cy = e.getRadius();

        AffineTransform oldAT = g.getTransform();

        g.translate(cx + e.getX(), cy + e.getY());
        g.rotate(e.getAngle());
        g.translate(-cx - e.getX(), -cy -e.getY());

        g.setColor(e.getColor());
        g.fill(e.getShape());
        g.draw(e.getShape());

        g.setTransform(oldAT);
    }

    /**
     * Draws the health bar of the entity
     * @param g Graphics of the display
     * @param e Entity to render
     */
    private void displayHealthBar(Graphics2D g, Entity e){
        g.translate(-e.getRadius() * 2 / 3, -10);
        int width = (int)(e.getRadius() * 3 * e.getHealthRatio());
        int height = 3;
        Rectangle2D bar = new Rectangle2D.Double(e.getX(), e.getY(), width, height);
        Color c = e.getHealthRatio() < 0.5 ? Color.RED : Color.GREEN;
        g.setColor(c);
        g.fill(bar);
        g.draw(bar);
        g.translate(e.getRadius() * 2 / 3, 10);
    }

    /**
     * Draws the weapon of the entity
     * @param g Graphics of the display
     * @param e Entity to render
     */
    private void displayWeapon(Graphics2D g, Entity e){
        int cx = e.getRadius();
        int cy = e.getRadius();

        AffineTransform oldAT = g.getTransform();

        g.translate(cx + e.getX(), cy + e.getY());
        g.rotate(e.getAngle() + Math.PI / 2);
        g.translate(-cx - e.getX(), -cy -e.getY());

        g.translate(-5, 0);
        Rectangle2D bar = new Rectangle2D.Double(e.getX(), e.getY(), 5, e.getRadius() * 2);
        g.setColor(e.getCurrentWeapon().getColor());
        g.fill(bar);
        g.draw(bar);
        g.setTransform(oldAT);
        g.translate(-5, 0);
    }
}
