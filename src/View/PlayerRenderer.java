/*
 -----------------------------------------------------------------------------------
 Lab          : 01
 File         : FullRenderer.java
 Authors      : Lange Yanik, Mario Tomic
 Date         : 16/03/2022
 -----------------------------------------------------------------------------------
 */

package View;

import Entities.Entity;
import java.awt.*;
import java.awt.geom.AffineTransform;

/**
 * Assists the rendering of a bouncer that is filled with a color
 */
public class PlayerRenderer implements Renderer {

    @Override
    public void display(Graphics2D g, Entity b) {
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
}
