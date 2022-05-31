package View;

import javax.swing.*;
import java.awt.*;

public class GameOverScreen {
    private final JFrame jFrame;
    private final JPanel jPanel;

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
