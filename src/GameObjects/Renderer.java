/*
 -----------------------------------------------------------------------------------
 Lab          : 03 (Projet)
 File         : Renderer.java
 Authors      : Janis Chiffelle, Yanik Lange, Mario Tomic
 Date         : 18/06/2022
 -----------------------------------------------------------------------------------
 */

package GameObjects;

import GameObjects.Entities.Entity;
import java.awt.*;

/**
 * Renderer interface. Implemented in the classes of the entities to render them on the game.
 */
public interface Renderer {
    void display(Graphics2D g, Entity b);
}
