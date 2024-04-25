package Part2.Controller;

import Part2.Model.Horse;
import Part2.View.BettingSettingsFrame;
import Part2.data.Colours;
import Part2.data.Constants;

import javax.swing.*;
import java.util.List;

public class BettingWindowController {
    private static BettingSettingsFrame bettingWindow;

    public BettingWindowController(List<Horse> horses) {
        bettingWindow = new BettingSettingsFrame(horses);
        bettingWindow.getPlaceBetButton().addActionListener(_ -> {
            String selectedHorse = (String) bettingWindow.getHorseSelection().getSelectedItem();
            String betAmount = bettingWindow.getBetAmountField().getText();
            JOptionPane.showMessageDialog(null, "Bet placed on " + selectedHorse + " for " + betAmount + " virtual credits.");
            bettingWindow.setVisible(false);
        });
    }

    public static void toggleFrameVisibility(boolean makeVisible) {
        bettingWindow.setVisible(makeVisible);
    }

    public void showBettingWindow() {
        bettingWindow.setVisible(true);
    }
}