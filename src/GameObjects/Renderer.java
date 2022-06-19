package GameObjects;

import GameObjects.Entities.Entity;
import java.awt.*;

/**
 * Renderer interface, taken from the first lab of the MCR course
 */
public interface Renderer {
    void display(Graphics2D g, Entity b);
}
