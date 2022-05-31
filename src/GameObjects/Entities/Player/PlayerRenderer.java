/*
 -----------------------------------------------------------------------------------
 Lab          : 01
 File         : FullRenderer.java
 Authors      : Lange Yanik, Mario Tomic
 Date         : 16/03/2022
 -----------------------------------------------------------------------------------
 */

package GameObjects.Entities.Player;

import GameObjects.Entities.Entity;
import GameObjects.Renderer;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

/**
 * Assists the rendering of a bouncer that is filled with a color
 */
public class PlayerRenderer implements Renderer {

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
    }

    private void makeHealthBar(Graphics2D g, Entity b){
        g.translate(-6, -7);
        int width = (int)(25 * b.getHealthRatio());
        int height = 3;
        Rectangle2D bar = new Rectangle2D.Double(b.getX(), b.getY(), width, height);
        Color c = width < 13 ? Color.RED : Color.GREEN;
        g.setColor(c);
        g.fill(bar);
        g.draw(bar);
        g.translate(6, 7);
    }
}
