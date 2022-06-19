package View;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

/**
 * View of the application, using a JFrame and a JPanel.
 * Implements the Displayer interface.
 *
 * @author Janis Chiffelle, Yanik Lange, Mario Tomic
 * @date 01.06.2022
 * @version Java 11
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

    }

    /**
     * Sets the size of the panel.
     *
     * @param d Dimension of the panel size.
     */
    public void setPanelSize(Dimension d){
        jPanel.setSize(d);
        jFrame.getContentPane().setPreferredSize(d);
        jFrame.pack();
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

    /**
     * Used to return the state of the mouse click
     *
     * @return True if the mouse is clicked, False if not.
     */
    public boolean isMouseClicked(){
        return click;
    }


    @Override
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

    /**
     * closes the frame.
     */
    public void close(){
        jFrame.setVisible(false);
    }
}
