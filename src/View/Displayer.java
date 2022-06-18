/*
 -----------------------------------------------------------------------------------
 Lab          : 03 (Projet)
 File         : Displayer.java
 Authors      : Janis Chiffelle, Yanik Lange, Mario Tomic
 Date         : 18/06/2022
 -----------------------------------------------------------------------------------
 */

package View;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;

/**
 * Displayer interface. Implemented in the classes of the display to create a display.
 */
public interface Displayer {
    /**
     *
     * @return The width of the display.
     */
    int getWidth();

    /**
     *
     * @return The height of the display.
     */
    int getHeight();

    /**
     *
     * @return The graphics2D element on which we draw.
     */
    Graphics2D getGraphics();

    /**
     * Updates the display by repainting on it.
     */
    void repaint();

    /**
     * Set the title of the display/window.
     *
     * @param s The title of the display/window we want to set.
     */
    void setTitle(String s);

    /**
     * Adds a key listener to listen the key input.
     *
     * @param ka Key input.
     */
    void addKeyListener(KeyAdapter ka);

    /**
     * Adds a mouse motion listener to listen the mouse movement/click on the display/window.
     *
     * @param ma Mouse movement/click input.
     */
    void addMouseMotionListener(MouseAdapter ma);
}