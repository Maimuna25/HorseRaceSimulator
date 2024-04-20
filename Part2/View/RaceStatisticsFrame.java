package Part2.View;

import Part2.Model.RaceStatistics;
import Part2.data.Constants;

import javax.swing.*;
import java.awt.*;

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
        add(scrollPane, gridBagConstraints);
    }

}

