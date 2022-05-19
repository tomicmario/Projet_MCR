package Entities.Weapons;

import Entities.Entity;
import Entities.Renderer;

import java.awt.*;

public class ProjectileRenderer implements Renderer {
    @Override
    public void display(Graphics2D g, Entity b) {
        g.setColor(b.getColor());
        g.fill(b.getShape());
        g.draw(b.getShape());
    }
}
