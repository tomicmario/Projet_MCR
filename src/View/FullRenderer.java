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

/**
 * Assists the rendering of a bouncer that is filled with a color
 */
public class FullRenderer implements Renderer {

    @Override
    public void display(Graphics2D g, Entity b) {
        g.setColor(b.getColor());
        g.fill(b.getShape());
        g.draw(b.getShape());
    }
}
