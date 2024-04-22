package Part2.View;

import javax.swing.*;
import java.awt.*;

public class WinnerPopUpFrame extends JFrame {

    public WinnerPopUpFrame(String winnerName) {
        setTitle("Race Winner");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Color customGreen = new Color(144, 238, 144);
        getContentPane().setBackground(customGreen);

        JLabel winnerLabel = new JLabel("The Winner is " + winnerName + "!");
        winnerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        Font labelFont = winnerLabel.getFont();
        winnerLabel.setFont(new Font(labelFont.getName(), Font.PLAIN, 20));

        add(winnerLabel, BorderLayout.CENTER);

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(_ -> {

            setVisible(false);
            HorseRaceFrame.getFrame().setVisible(false);
        });
        add(closeButton, BorderLayout.SOUTH);

        setVisible(true);
    }
}
