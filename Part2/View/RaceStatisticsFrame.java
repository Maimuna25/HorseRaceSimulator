package Part2.View;

import Part2.Model.RaceStatistics;
import Part2.Model.RaceStatisticsEntry;
import Part2.data.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RaceStatisticsFrame extends JFrame {
    public RaceStatisticsFrame(RaceStatistics statistics) {
        setTitle("Statistics and Analytics");
        setSize(800, 600);
        setLocationRelativeTo(null);

        getContentPane().setBackground(Constants.LIGHT_BLUE);

        setLayout(new GridBagLayout());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(0, 0, 10, 0);
        gridBagConstraints.fill = GridBagConstraints.NONE;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        JTable table = new JTable(statistics.getData(), statistics.getHeaders());
        table.setBounds(0, 0, 300, 200);

        JScrollPane scrollPane = new JScrollPane(table);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 5;
        add(scrollPane, gridBagConstraints);

        List<String> horseNames = getAllHorseNames(statistics);

        JLabel horseNameLabel = new JLabel("Select Horse:");
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.insets = new Insets(0, 20, 0, 0);
        add(horseNameLabel, gridBagConstraints);

        JComboBox<String> horseNameComboBox = new JComboBox<>(horseNames.toArray(new String[0]));
        horseNameComboBox.setSelectedIndex(0);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 10, 0, 0);
        add(horseNameComboBox, gridBagConstraints);

        JTextArea horseStatsTextArea = new JTextArea(4, 1);
        horseStatsTextArea.setFont(horseStatsTextArea.getFont().deriveFont(18f));
        horseStatsTextArea.setBackground(Constants.LIGHT_BLUE);
        horseStatsTextArea.setEditable(false);
        horseStatsTextArea.setText(getHorseInfo(statistics, (String) horseNameComboBox.getSelectedItem()));
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.insets = new Insets(20, 20, 0, 0);
        add(horseStatsTextArea, gridBagConstraints);

        horseNameComboBox.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                horseStatsTextArea.setText(getHorseInfo(statistics, (String) horseNameComboBox.getSelectedItem()));
            }
        });
    }

    private List<String> getAllHorseNames(RaceStatistics statistics) {
        Set<String> horseNames = new HashSet<>();
        for (int i = 0; i < statistics.size(); i++) {
            horseNames.add(statistics.getRaceStatistics(i).getHorseName());
        }
        return horseNames.stream().toList();
    }

    private String getHorseInfo(RaceStatistics raceStatistics, String horseName) {
        List<RaceStatisticsEntry> horseEntries = raceStatistics.getAllEntries()
                .stream()
                .filter(h -> h.getHorseName().equals(horseName)) // filter() removes any Horse object that doesn't match the condition given.
                .toList();

        //.map() function extracts the distance travelled for each horse
        //.reduce() function sums up distances, starting with zero
        int totalDistance = horseEntries.stream().map(RaceStatisticsEntry::getDistanceTravelled).reduce(0, Integer::sum);

        int wins = (int) horseEntries.stream().filter(RaceStatisticsEntry::hasWon).count();  // Filter and count horses that have won
        int loss = (int) horseEntries.stream().filter(RaceStatisticsEntry::hasLost).count(); // Filter and count horses that have lost
        int falls = (int) horseEntries.stream().filter(RaceStatisticsEntry::hasFallen).count(); // Filter and count horses that have fallen

        StringBuilder sb = new StringBuilder();
        sb.append("Horse Selected: ").append(horseName).append("\n");
        sb.append("Total Races Entered: ").append(horseEntries.size()).append("\n");
        sb.append("Total Distance Travelled: ").append(totalDistance).append("m\n");
        sb.append("Total Wins: ").append(wins).append("\n");
        sb.append("Total Losses: ").append(loss).append("\n");
        sb.append("Total Falls: ").append(falls).append("\n");

        return sb.toString();
    }
}

