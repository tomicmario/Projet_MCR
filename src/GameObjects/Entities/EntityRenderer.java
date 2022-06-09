/*
 -----------------------------------------------------------------------------------
 Lab          : 01
 File         : FullRenderer.java
 Authors      : Lange Yanik, Mario Tomic
 Date         : 16/03/2022
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
        int cx = b.getShape().getBounds().height / 2;
        int cy = b.getShape().getBounds().width / 2;

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
        g.translate(-b.getSize() * 2 / 3, -10);
        int width = (int)(b.getSize() * 2 * b.getHealthRatio());
        int height = 3;
        Rectangle2D bar = new Rectangle2D.Double(b.getX(), b.getY(), width, height);
        Color c = width < b.getSize() ? Color.RED : Color.GREEN;
        g.setColor(c);
        g.fill(bar);
        g.draw(bar);
        g.translate(b.getSize() * 2 / 3, 10);
    }

    private void displayWeapon(Graphics2D g, Entity b){
        int cx = b.getShape().getBounds().height / 2;
        int cy = b.getShape().getBounds().width / 2;

        AffineTransform oldAT = g.getTransform();

        g.translate(cx + b.getX(), cy + b.getY());
        g.rotate(b.getAngle() + Math.PI / 2);
        g.translate(-cx - b.getX(), -cy -b.getY());

        g.translate(-5, 0);
        Rectangle2D bar = new Rectangle2D.Double(b.getX(), b.getY(), 5, b.getSize());
        g.setColor(b.getCurrentWeapon().getColor());
        g.fill(bar);
        g.draw(bar);
        g.setTransform(oldAT);
        g.translate(-5, 0);
    }
}
