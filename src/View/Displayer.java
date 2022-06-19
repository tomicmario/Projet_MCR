package View;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;

/**
 * Adapted Displayer interface from the first Lab of the MCR course, used for the display of the game.
 *
 * @author Janis Chiffelle, Yanik Lange, Mario Tomic
 * @date 04.05.2022
 * @version Java 11
 */
public interface Displayer {

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