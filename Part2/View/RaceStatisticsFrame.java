package Part2.View;

import Part2.Model.RaceStatistics;
import Part2.Model.RaceStatisticsEntry;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class RaceStatisticsFrame extends JFrame {
    public RaceStatisticsFrame(RaceStatistics statistics) {
        setTitle("Statistics and Analytics");
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new GridLayout(1, 2));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JTextArea statisticsTextArea = new JTextArea();
        statisticsTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(statisticsTextArea);
        mainPanel.add(scrollPane);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < statistics.size(); i++) {
            sb.append("Race Number: ").append(i + 1).append("\n");
            RaceStatisticsEntry entry = statistics.getRaceStatistics(i);
            sb.append("Average Speed: ").append(entry.getAverageSpeed()).append("\n");
            sb.append("Finishing Time: ").append(entry.getFinishingTime()).append("\n\n");
        }
        statisticsTextArea.setText(sb.toString());

        add(mainPanel);
    }

}

