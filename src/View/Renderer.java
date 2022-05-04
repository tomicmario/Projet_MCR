/*
 -----------------------------------------------------------------------------------
 Lab          : 01
 File         : Renderer.java
 Authors      : Lange Yanik, Mario Tomic
 Date         : 16/03/2022
 -----------------------------------------------------------------------------------
 */

package View;

import Entities.Entity;
import java.awt.*;

public interface Renderer {
    void display(Graphics2D g, Entity b);
}
