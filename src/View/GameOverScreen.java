package View;

import javax.swing.*;
import java.awt.*;

/**
 * GameOverScreen class. Adding a window with the final score of the player once he's dead.
 *
 * @author Janis Chiffelle, Yanik Lange, Mario Tomic
 * @date 31.05.2022
 * @version Java 11
 */
public class GameOverScreen {
    private final JFrame jFrame;
    private final JPanel jPanel;

    /**
     * GameOverScreen constructor. Creating a display/window to show the final score of the player.
     *
     * @param score The score the player had when he died.
     */
    public GameOverScreen(int score){
        jFrame = new JFrame();
        jPanel = new JPanel();

        jFrame.setBackground(Color.WHITE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.setSize(new Dimension(200, 200));
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setContentPane(jPanel);

        jPanel.setBackground(Color.white);
        jPanel.setSize(jFrame.getSize());
        jPanel.add(new JLabel("GAME OVER"));
        jPanel.add(new JLabel("You scored : " + score + " points"));


    }
}
