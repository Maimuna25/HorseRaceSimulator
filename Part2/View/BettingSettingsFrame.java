package Part2.View;

import Part2.Model.Horse;
import Part2.data.Colours;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BettingSettingsFrame extends JFrame {
    private JComboBox<String> horseSelection;
    private JTextField betAmountField;
    private JButton placeBetButton;

    public BettingSettingsFrame(List<Horse> horses) {
        setTitle("Betting Settings");
        setSize(300, 200);

        JPanel containerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        containerPanel.setBackground(Colours.LIGHT_BLUE);

        gbc.gridx = 0;
        gbc.gridy = 0;
        containerPanel.add(new JLabel("Select Horse:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        horseSelection = new JComboBox<>();
        for (Horse horse : horses) {
            horseSelection.addItem(horse.getHorseName());
        }
        containerPanel.add(horseSelection, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        containerPanel.add(new JLabel("Enter Bet Amount:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        betAmountField = new JTextField();
        betAmountField.setPreferredSize(new Dimension(100, betAmountField.getPreferredSize().height));
        containerPanel.add(betAmountField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        placeBetButton = new JButton("Place Bet");
        containerPanel.add(placeBetButton, gbc);

        add(containerPanel);

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public JComboBox<String> getHorseSelection() {
        return horseSelection;
    }

    public JTextField getBetAmountField() {
        return betAmountField;
    }

    public JButton getPlaceBetButton() {
        return placeBetButton;
    }
}