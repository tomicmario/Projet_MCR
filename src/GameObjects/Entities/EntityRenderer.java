/*
 -----------------------------------------------------------------------------------
 Lab          : 03 (Projet)
 File         : EntityRenderer.java
 Authors      : Janis Chiffelle, Yanik Lange, Mario Tomic
 Date         : 18/06/2022
 -----------------------------------------------------------------------------------
 */

package GameObjects.Entities;

import GameObjects.Renderer;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

/**
 * Assists the rendering of a bouncer that is filled with a color
 */
public class EntityRenderer implements Renderer {

    @Override
    public void display(Graphics2D g, Entity b) {
        makeHealthBar(g, b);
        int cx = b.getRadius();
        int cy = b.getRadius();

        AffineTransform oldAT = g.getTransform();

        g.translate(cx + b.getX(), cy + b.getY());
        g.rotate(b.getAngle());
        g.translate(-cx - b.getX(), -cy -b.getY());

        g.setColor(b.getColor());
        g.fill(b.getShape());
        g.draw(b.getShape());

        g.setTransform(oldAT);

        displayWeapon(g, b);
    }

    private void makeHealthBar(Graphics2D g, Entity b){
        g.translate(-b.getRadius() * 2 / 3, -10);
        int width = (int)(b.getRadius() * 3 * b.getHealthRatio());
        int height = 3;
        Rectangle2D bar = new Rectangle2D.Double(b.getX(), b.getY(), width, height);
        Color c = b.getHealthRatio() < 0.5 ? Color.RED : Color.GREEN;
        g.setColor(c);
        g.fill(bar);
        g.draw(bar);
        g.translate(b.getRadius() * 2 / 3, 10);
    }

    private void displayWeapon(Graphics2D g, Entity b){
        int cx = b.getRadius();
        int cy = b.getRadius();

        AffineTransform oldAT = g.getTransform();

        g.translate(cx + b.getX(), cy + b.getY());
        g.rotate(b.getAngle() + Math.PI / 2);
        g.translate(-cx - b.getX(), -cy -b.getY());

        g.translate(-5, 0);
        Rectangle2D bar = new Rectangle2D.Double(b.getX(), b.getY(), 5, b.getRadius() * 2);
        g.setColor(b.getCurrentWeapon().getColor());
        g.fill(bar);
        g.draw(bar);
        g.setTransform(oldAT);
        g.translate(-5, 0);
    }
}
