/*
 -----------------------------------------------------------------------------------
 Lab          : 01
 File         : BouncerDisplay.java
 Authors      : Lange Yanik, Mario Tomic
 Date         : 16/03/2022
 -----------------------------------------------------------------------------------
 */

package View;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

/**
 * View of the application, using a JFrame and a JPanel
 */
public class GameDisplay implements Displayer {

    private static GameDisplay instance;
    private final JFrame jFrame;
    private final JPanel jPanel;
    private BufferedImage image;
    private boolean click;

    /**
     * Singleton instantiation of the display
     * @return The instance of the display
     */
    public static GameDisplay getInstance(){
        if (instance == null){
            instance = new GameDisplay();
        }
        return instance;
    }

    /**
     * Initialise the class and sets the right parameters
     */
    private GameDisplay() {
        jFrame = new JFrame();
        jPanel = new JPanel();

        jFrame.setBackground(Color.WHITE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setContentPane(jPanel);

        jPanel.setBackground(Color.white);
        jPanel.setSize(jFrame.getSize());
        jPanel.setDoubleBuffered(true);

        image = (BufferedImage) jPanel.createImage(jPanel.getWidth(), jPanel.getHeight());
        jFrame.pack();

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
    }

    public void setPanelSize(Dimension d){
        jPanel.setSize(d);
        jFrame.getContentPane().setPreferredSize(d);
        jFrame.pack();
    }

    @Override
    public int getWidth() {
        return jPanel.getWidth();
    }

    @Override
    public int getHeight() {
        return jPanel.getHeight();
    }

    @Override
    public Graphics2D getGraphics() {
        return (Graphics2D) image.getGraphics();
    }

    @Override
    public void repaint() {
        jPanel.getGraphics().drawImage(image, 0 , 0, null);
        image = (BufferedImage) jPanel.createImage(jPanel.getWidth(), jPanel.getHeight());
    }

    @Override
    public void setTitle(String s) {
        jFrame.setTitle(s);
    }

    @Override
    public void addKeyListener(KeyAdapter ka) {
        jFrame.addKeyListener(ka);
    }

    public boolean isClick(){
        return click;
    }

    public void addMouseMotionListener(MouseAdapter ma) {
        jPanel.addMouseMotionListener(ma);
        jPanel.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                click = true;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                click = false;
            }
        });
    }
}
