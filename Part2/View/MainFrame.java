package Part2.View;

import Part2.Controller.MainFrameController;
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
        ImageIcon icon = new ImageIcon("Part2/assets/horseIcon.png");
        setIconImage(icon.getImage());

        topPanel = createTopPanel();
        add(topPanel, BorderLayout.NORTH);

        // Center panel with background image and buttons
        centerPanel = createCenterPanel();
        add(centerPanel, BorderLayout.CENTER);

        // Bottom panel with action buttons
        bottomPanel = createBottomPanel();
        add(bottomPanel, BorderLayout.SOUTH);

        new MainFrameController(this);

        setVisible(true);
    }

    private JPanel createTopPanel() {
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(Constants.LIGHT_BLUE);

        // Image panel
        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(new ImageIcon("Part2/assets/horseIcon.png"));
        topPanel.add(imageLabel, BorderLayout.WEST);

        // Title label
        JLabel titleLabel = new JLabel("Welcome to Horse Racing Game");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 100, 0, 0)); // Add left padding
        topPanel.add(titleLabel, BorderLayout.CENTER);

        return topPanel;
    }

    private JPanel createCenterPanel() {
        ImagePanel centerPanel = new ImagePanel("Part2/assets/raceTrack.jpg");
        centerPanel.setLayout(new GridBagLayout());
        centerPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); // Add padding
        centerPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.NONE;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        gridBagConstraints.insets = new Insets(0, 0,20,0);

        customiseTrackButton = new JButton("Customise Track");
        customiseTrackButton.setPreferredSize(new Dimension(200, 50));

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        centerPanel.add(customiseTrackButton, gridBagConstraints);

        customiseHorsesButton = new JButton("Customise Horse");
        customiseHorsesButton.setPreferredSize(new Dimension(200, 50));

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        centerPanel.add(customiseHorsesButton, gridBagConstraints);

        startRaceButton = new JButton("Start Race");
        startRaceButton.setPreferredSize(new Dimension(200, 50));

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        centerPanel.add(startRaceButton, gridBagConstraints);

        return centerPanel;
    }

    private JPanel createBottomPanel() {
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.setBackground(Constants.LIGHT_BLUE);

        // Action buttons
        statsButton = new JButton("View Statistics and Analytics");
        bottomPanel.add(statsButton);

        bettingButton = new JButton("Enter Virtual Betting System");
        bottomPanel.add(bettingButton);

        return bottomPanel;
    }
}
