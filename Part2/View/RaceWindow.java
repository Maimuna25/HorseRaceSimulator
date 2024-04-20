package Part2.View;

import Part2.Model.Horse;
import Part2.Model.HorsePanel;
import Part2.Model.RaceStatistics;
import Part2.Model.Track;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class RaceWindow extends JFrame {
    private RaceStatistics raceStatistics;

    public RaceWindow(Track track, List<Horse> horses, RaceStatistics raceStatistics) {
        setTitle("Race Window");

        int numLanes = track.getNumLanes();

        int frameHeight = 90 * numLanes;
        setSize(600, frameHeight);

        setLocationRelativeTo(null);

        this.raceStatistics = raceStatistics;

        JPanel raceTrackPanel = new JPanel();
        raceTrackPanel.setLayout(new GridLayout(numLanes, 1));

        List<HorsePanel> horsePanels = new ArrayList<>();
        for (Horse horse : horses) {
            HorsePanel horsePanel = new HorsePanel(horse.getHorseName(), raceStatistics);
            horsePanels.add(horsePanel);
            raceTrackPanel.add(horsePanel);
        }

        add(raceTrackPanel);

        for (HorsePanel panel : horsePanels) {
            new Thread(panel).start();
        }
    }

}