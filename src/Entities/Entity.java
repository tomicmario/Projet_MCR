package Entities;

import java.awt.*;
import java.awt.Shape;

public interface Entity {
    void draw();
    void move();
    Color getColor();
    Shape getShape();
}
