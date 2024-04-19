package Part2.View;

import Part2.Model.Horse;
import Part2.Model.Track;
import Part2.data.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class HorseSettingsFrame extends JFrame {

    private int numLanes;
    private List<JTextField> horseNameFields;
    private List<JComboBox<String>> breedComboBoxes;
    private List<JComboBox<String>> coatColorComboBoxes;
    private List<JComboBox<String>> equipmentComboBoxes;
    private List<JComboBox<String>> accessoriesComboBoxes;
    private JButton customiseButton;


    public HorseSettingsFrame(Track trackSettings, List<Horse> horses) {
        this.numLanes = trackSettings.getNumLanes();

        setTitle("Customize Horses");
        setSize(300 * numLanes + 100, 500);
        setLocationRelativeTo(null);

        getContentPane().setBackground(Constants.LIGHT_BLUE);

        this.horseNameFields = new ArrayList<>();
        this.breedComboBoxes = new ArrayList<>();
        this.coatColorComboBoxes = new ArrayList<>();
        this.equipmentComboBoxes = new ArrayList<>();
        this.accessoriesComboBoxes = new ArrayList<>();

        // space between pairs of columns
        Insets columnPairInset = new Insets(0, 0, 10, 20);
        // space between label and field/combo-boxes
        Insets labelInset = new Insets(0, 0, 10, 0);
        // space between buttons
        Insets buttonInset = new Insets(20,0,0,0);

        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.NONE;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        for (int col = 0; col < numLanes; col++) {
            Horse horse = horses.get(col);

            JLabel laneNumberLabel = new JLabel("Lane Number: " + col);
            gridBagConstraints.gridx = 2 * col;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.gridwidth = 2;
            gridBagConstraints.insets = columnPairInset;
            add(laneNumberLabel, gridBagConstraints);

            JLabel horseNameLabel = new JLabel("Horse Name: ");
            gridBagConstraints.gridx = 2 * col;
            gridBagConstraints.gridy = 1;
            gridBagConstraints.gridwidth = 1;
            gridBagConstraints.insets = labelInset;
            add(horseNameLabel, gridBagConstraints);

            JTextField horseNameField = new JTextField(12);
            horseNameField.setText(horse.getHorseName());
            gridBagConstraints.gridx = 2 * col + 1;
            gridBagConstraints.gridy = 1;
            gridBagConstraints.insets = columnPairInset;
            add(horseNameField, gridBagConstraints);
            horseNameFields.add(horseNameField);

            JLabel breedLabel = new JLabel("Breed: ");
            gridBagConstraints.gridx = 2 * col;
            gridBagConstraints.gridy = 2;
            gridBagConstraints.insets = labelInset;
            add(breedLabel, gridBagConstraints);

            JComboBox<String> breedComboBox = new JComboBox<>(Constants.BREEDS);
            breedComboBox.setSelectedItem(horse.getBreed());
            gridBagConstraints.gridx = 2 * col + 1;
            gridBagConstraints.gridy = 2;
            gridBagConstraints.insets = columnPairInset;
            add(breedComboBox, gridBagConstraints);
            breedComboBoxes.add(breedComboBox);

            JLabel coatColourLabel = new JLabel("Coat Colour: ");
            gridBagConstraints.gridx = 2 * col;
            gridBagConstraints.gridy = 3;
            gridBagConstraints.insets = labelInset;
            add(coatColourLabel, gridBagConstraints);

            JComboBox<String> coatColourComboBox = new JComboBox<>(Constants.COAT_COLORS);
            coatColourComboBox.setSelectedItem(horse.getCoatColour());
            gridBagConstraints.gridx = 2 * col + 1;
            gridBagConstraints.gridy = 3;
            gridBagConstraints.insets = columnPairInset;
            add(coatColourComboBox, gridBagConstraints);
            coatColorComboBoxes.add(coatColourComboBox);

            JLabel equipmentLabel = new JLabel("Equipment: ");
            gridBagConstraints.gridx = 2 * col;
            gridBagConstraints.gridy = 4;
            gridBagConstraints.insets = labelInset;
            add(equipmentLabel, gridBagConstraints);

            JComboBox<String> equipmentComboBox = new JComboBox<>(Constants.EQUIPMENT_OPTIONS);
            equipmentComboBox.setSelectedItem(horse.getEquipment());
            gridBagConstraints.gridx = 2 * col + 1;
            gridBagConstraints.gridy = 4;
            gridBagConstraints.insets = columnPairInset;
            add(equipmentComboBox, gridBagConstraints);
            equipmentComboBoxes.add(equipmentComboBox);

            JLabel accessoriesLabel = new JLabel("Accessories: ");
            gridBagConstraints.gridx = 2 * col;
            gridBagConstraints.gridy = 5;
            gridBagConstraints.insets = labelInset;
            add(accessoriesLabel, gridBagConstraints);

            JComboBox<String> accessoriesComboBox = new JComboBox<>(Constants.ACCESSORIES_OPTIONS);
            accessoriesComboBox.setSelectedItem(horse.getAccessory());
            gridBagConstraints.gridx = 2 * col + 1;
            gridBagConstraints.gridy = 5;
            gridBagConstraints.insets = columnPairInset;
            add(accessoriesComboBox, gridBagConstraints);
            accessoriesComboBoxes.add(accessoriesComboBox);
        }

        customiseButton = new JButton("Apply Changes");
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = buttonInset;
        add(customiseButton, gridBagConstraints);
    }

    public void onCustomiseButtonClicked(ActionListener actionListener) {
        customiseButton.addActionListener(actionListener);
    }

    public int getNumLanes() {
        return numLanes;
    }

    public String getHorseName(int laneNum) {
        return horseNameFields.get(laneNum).getText();
    }

    public String getBreed(int laneNum) {
        return (String) breedComboBoxes.get(laneNum).getSelectedItem();
    }

    public String getCoatColour(int laneNum) {
        return (String) coatColorComboBoxes.get(laneNum).getSelectedItem();
    }

    public String getEquipment(int laneNum) {
        return (String) equipmentComboBoxes.get(laneNum).getSelectedItem();
    }

    public String getAccessories(int laneNum) {
        return (String) accessoriesComboBoxes.get(laneNum).getSelectedItem();
    }

    public List<Horse> getHorses() {
        List<Horse> newRunningHorses = new ArrayList<>();

        for (int i = 0; i < numLanes; i++) {
            newRunningHorses.add(new Horse(getHorseName(i), getBreed(i), getCoatColour(i), getEquipment(i), getAccessories(i)));
        }

        return newRunningHorses;
    }
}
