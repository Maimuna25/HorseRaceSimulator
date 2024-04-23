package Part2.View;

import Part2.Model.Horse;
import Part2.Model.Track;
import Part2.data.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.List;

public class HorseSettingsFrame extends JFrame {

    private int numLanes;
    private List<JTextField> horseNameFields;
    private List<JComboBox<String>> coatColourComboBoxes;
    private List<JComboBox<String>> hairColourComboBoxes;
    private List<JComboBox<String>> saddleColourComboBoxes;
    private List<JComboBox<String>> bridleColourComboBoxes;
    private List<Double> horseConfidence;
    private JButton customiseButton;


    public HorseSettingsFrame(Track trackSettings, List<Horse> horses) {
        this.numLanes = trackSettings.getNumLanes();

        setTitle("Customise Horses");

        int numHorses = trackSettings.getNumLanes();
        int windowHeight = numHorses <= 5 ? 430 : 780;
        setSize(1400, windowHeight);
        setResizable(false);
        setLocationRelativeTo(null);

        getContentPane().setBackground(Constants.LIGHT_BLUE);

        this.horseNameFields = new ArrayList<>();
        this.coatColourComboBoxes = new ArrayList<>();
        this.hairColourComboBoxes = new ArrayList<>();
        this.saddleColourComboBoxes = new ArrayList<>();
        this.bridleColourComboBoxes = new ArrayList<>();
        this.horseConfidence = new ArrayList<>();

        // space between pairs of columns
        Insets columnPairInset = new Insets(0, 0, 10, 20);
        // space between label and field/combo-boxes
        Insets labelInset = new Insets(0, 0, 10, 0);
        // space between buttons
        Insets buttonInset = new Insets(20,0,0,0);

        setLayout(new FlowLayout());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.RELATIVE;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        for (int col = 0; col < numLanes; col++) {
            JPanel horseCustomPanel = new JPanel(new GridBagLayout());
            horseCustomPanel.setBackground(Constants.LIGHT_BLUE);

            int finalCol = col;
            Horse horse = horses.get(finalCol);

            JLabel laneNumberLabel = new JLabel("Lane Number: " + col);
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.gridwidth = 2;
            gridBagConstraints.insets = columnPairInset;
            horseCustomPanel.add(laneNumberLabel, gridBagConstraints);

            JLabel horseNameLabel = new JLabel("Horse Name: ");
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 1;
            gridBagConstraints.gridwidth = 1;
            gridBagConstraints.insets = labelInset;
            horseCustomPanel.add(horseNameLabel, gridBagConstraints);

            JTextField horseNameField = new JTextField(12);
            horseNameField.setText(horse.getHorseName());
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = 1;
            gridBagConstraints.insets = columnPairInset;
            horseCustomPanel.add(horseNameField, gridBagConstraints);
            horseNameFields.add(horseNameField);

            JLabel coatColourLabel = new JLabel("Coat Colour: ");
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 2;
            gridBagConstraints.insets = labelInset;
            horseCustomPanel.add(coatColourLabel, gridBagConstraints);

            JComboBox<String> coatColourComboBox = new JComboBox<>(Constants.COAT_COLORS);
            coatColourComboBox.setSelectedItem(horse.getCoatColour());
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = 2;
            gridBagConstraints.insets = columnPairInset;
            horseCustomPanel.add(coatColourComboBox, gridBagConstraints);
            coatColourComboBoxes.add(coatColourComboBox);

            JLabel hairColourLabel = new JLabel("Hair Colour: ");
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 3;
            gridBagConstraints.insets = labelInset;
            horseCustomPanel.add(hairColourLabel, gridBagConstraints);

            JComboBox<String> hairColourComboBox = new JComboBox<>(Constants.HAIR_COLOURS);
            hairColourComboBox.setSelectedItem(horse.getHairColour());
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = 3;
            gridBagConstraints.insets = columnPairInset;
            horseCustomPanel.add(hairColourComboBox, gridBagConstraints);
            hairColourComboBoxes.add(hairColourComboBox);

            JLabel saddleColourLabel = new JLabel("Saddle Colour: ");
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 4;
            gridBagConstraints.insets = labelInset;
            horseCustomPanel.add(saddleColourLabel, gridBagConstraints);

            JComboBox<String> saddleColourComboBox = new JComboBox<>(Constants.SADDLE_COLOUR);
            saddleColourComboBox.setSelectedItem(horse.getSaddleColour());
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = 4;
            gridBagConstraints.insets = columnPairInset;
            horseCustomPanel.add(saddleColourComboBox, gridBagConstraints);
            saddleColourComboBoxes.add(saddleColourComboBox);

            JLabel bridleColourLabel = new JLabel("Bridle Colour: ");
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 5;
            gridBagConstraints.insets = labelInset;
            horseCustomPanel.add(bridleColourLabel, gridBagConstraints);

            JComboBox<String> bridleColourComboBox = new JComboBox<>(Constants.BRIDLE_COLOUR);
            bridleColourComboBox.setSelectedItem(horse.getBridleColour());
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = 5;
            gridBagConstraints.insets = columnPairInset;
            horseCustomPanel.add(bridleColourComboBox, gridBagConstraints);
            bridleColourComboBoxes.add(bridleColourComboBox);

            horseConfidence.add(horse.getHorseConfidence());

            JLabel horsePreviewLabel = new JLabel("Preview:");
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 6;
            gridBagConstraints.gridwidth = 2;
            gridBagConstraints.insets = new Insets(0, 0, 0, 0);
            horseCustomPanel.add(horsePreviewLabel, gridBagConstraints);

            JLabel horsePreview = new JLabel();
            setImage(horsePreview, horse);
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 7;
            gridBagConstraints.gridwidth = 2;
            horseCustomPanel.add(horsePreview, gridBagConstraints);

            // Add listeners to handle user interactions with various components
            //The setImage() method is called to update the preview image based on the changes
            horseNameField.addActionListener(_ -> horses.get(finalCol).setHorseName(horseNameField.getText()));
            coatColourComboBox.addItemListener(e -> {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    Horse horseSelected = horses.get(finalCol);
                    horseSelected.setCoatColour((String) coatColourComboBox.getSelectedItem());
                    setImage(horsePreview, horseSelected);
                }
            });
            hairColourComboBox.addItemListener(e -> {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    Horse horseSelected = horses.get(finalCol);
                    horseSelected.setHairColour((String) hairColourComboBox.getSelectedItem());
                    setImage(horsePreview, horseSelected);
                }
            });
            saddleColourComboBox.addItemListener(e -> {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    Horse horseSelected = horses.get(finalCol);
                    horseSelected.setSaddleColour((String) saddleColourComboBox.getSelectedItem());
                    setImage(horsePreview, horseSelected);
                }
            });
            bridleColourComboBox.addItemListener(e -> {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    Horse horseSelected = horses.get(finalCol);
                    horseSelected.setBridleColour((String) bridleColourComboBox.getSelectedItem());
                    setImage(horsePreview, horseSelected);
                }
            });

            add(horseCustomPanel);
        }

        customiseButton = new JButton("Apply Changes");
        add(customiseButton);
    }

    public void onCustomiseButtonClicked(ActionListener actionListener) {
        customiseButton.addActionListener(actionListener);
    }

    public String getHorseName(int laneNum) {
        return horseNameFields.get(laneNum).getText();
    }

    public String getCoatColour(int laneNum) {
        return (String) coatColourComboBoxes.get(laneNum).getSelectedItem();
    }

    public String getHairColour(int laneNum) {
        return (String) hairColourComboBoxes.get(laneNum).getSelectedItem();
    }

    public String getSaddleColour(int laneNum) {
        return (String) saddleColourComboBoxes.get(laneNum).getSelectedItem();
    }

    public String getBridleColour(int laneNum) {
        return (String) bridleColourComboBoxes.get(laneNum).getSelectedItem();
    }

    public List<Horse> getHorses() {
        List<Horse> newRunningHorses = new ArrayList<>();

        for (int i = 0; i < numLanes; i++) {
            newRunningHorses.add(new Horse(
                    getHorseName(i),
                    getCoatColour(i),
                    getHairColour(i),
                    getSaddleColour(i),
                    getBridleColour(i),
                    horseConfidence.get(i)
            ));
        }

        return newRunningHorses;
    }

    // Load and scale the image to fit within the JLabel component
    private void setImage(JLabel horsePreview, Horse horse) {
        Image newImage = Toolkit.getDefaultToolkit().getImage(horse.getImagePath());
        horsePreview.setIcon(new ImageIcon(newImage.getScaledInstance(150, 130, Image.SCALE_DEFAULT)));
    }
}
