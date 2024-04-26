package Part2.View;

import Part2.Controller.BettingWindowController;
import Part2.data.Colours;

import javax.swing.*;
import java.awt.*;

public class WinnerPopUpFrame extends JFrame {

    public WinnerPopUpFrame(String winnerName) {
        setTitle("Race Winner");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(Colours.LIGHT_GREEN);

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
