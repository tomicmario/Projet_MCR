/*
 -----------------------------------------------------------------------------------
 Lab          : 01
 File         : Displayer.java
 Authors      : Lange Yanik, Mario Tomic
 Date         : 16/03/2022
 -----------------------------------------------------------------------------------
 */

package View;

import java.awt.*;
import java.awt.event.KeyAdapter;

public interface Displayer {
    int getWidth();
    int getHeight();
    Graphics2D getGraphics();
    void repaint();
    void setTitle(String s);
    void addKeyListener(KeyAdapter ka);
}