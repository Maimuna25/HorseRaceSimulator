package Part2.View;

import Part2.data.Constants;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private JPanel topPanel;
    private JPanel centerPanel;
    private JPanel bottomPanel;
    private JButton customiseTrackButton;
    private JButton customiseHorsesButton;
    private JButton startRaceButton;
    private JButton statsButton;
    private JButton bettingButton;

    public MainFrame() {
        super("Horse Racing Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Set the Game Application Icon
        ImageIcon icon = new ImageIcon("src/assets/horseIcon.png");
        setIconImage(icon.getImage());

        topPanel = createTopPanel();
        add(topPanel, BorderLayout.NORTH);

        // Center panel with background image and buttons
        centerPanel = createCenterPanel();
        add(centerPanel, BorderLayout.CENTER);

        // Bottom panel with action buttons
        bottomPanel = createBottomPanel();
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private JPanel createTopPanel() {
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(Constants.LIGHT_BLUE);

        // TODO: Create the rest of the Top Panel.

        return topPanel;
    }

    private JPanel createCenterPanel() {
        ImagePanel centerPanel = new ImagePanel("src/assets/raceTrack.jpg");
        centerPanel.setLayout(new GridBagLayout());
        centerPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); // Add padding
        centerPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // TODO: Create the rest of the Center Panel.

        return centerPanel;
    }

    private JPanel createBottomPanel() {
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.setBackground(Constants.LIGHT_BLUE);

        // TODO: Create the rest of the BottomPanel.

        return bottomPanel;
    }
}
