package Part2.View;

import Part2.Model.Track;
import Part2.data.Constants;
import Part2.utilities.IntRange;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TrackSettingsFrame extends JFrame {
    private JComboBox<Integer> numLanesField;
    private JSlider trackLengthSlider;
    private JButton applyButton;

    public TrackSettingsFrame(Track trackSettings) {
        setTitle("Track Design");
        setSize(400, 300);
        setLocationRelativeTo(null);

        getContentPane().setBackground(Constants.LIGHT_BLUE);

        JLabel numHorsesLabel = new JLabel("Number of Tracks: ");
        JLabel trackLengthLabel = new JLabel("Track Length:");

        numLanesField = new JComboBox<>(IntRange.getInRange(1, 11, 1));
        numLanesField.setEditable(false);
        numLanesField.setSelectedItem(trackSettings.getNumLanes());

        trackLengthSlider = new JSlider(JSlider.HORIZONTAL, 100, 2000, trackSettings.getTrackLength());
        trackLengthSlider.setBackground(Constants.LIGHT_BLUE);

        JLabel trackLengthValueLabel = new JLabel("Track Length: " + trackLengthSlider.getValue() + " meters");
        applyButton = new JButton("Apply Changes");

        Insets fieldsInset = new Insets(0, 0, 10, 0);
        Insets buttonInset = new Insets(20,0,0,0);

        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = fieldsInset;
        gridBagConstraints.fill = GridBagConstraints.NONE;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        add(numHorsesLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        add(numLanesField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        add(trackLengthLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        add(trackLengthSlider, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        add(trackLengthValueLabel, gridBagConstraints);

        // Listener for track length slider
        trackLengthSlider.addChangeListener(_ -> {
            trackLengthValueLabel.setText("Track Length: " + trackLengthSlider.getValue() + " meters");
        });

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = buttonInset;
        add(applyButton, gridBagConstraints);
    }

    public void onApplyButtonClicked(ActionListener actionListener) {
        applyButton.addActionListener(actionListener);
    }

    public int getNumLanes() {
        return (int) numLanesField.getSelectedItem();
    }

    public int getTrackLength() {
        return trackLengthSlider.getValue();
    }

    public Track getTrackSettings() {
        return new Track(getNumLanes(), getTrackLength());
    }
}
