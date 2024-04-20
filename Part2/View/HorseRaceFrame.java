package Part2.View;

import Part2.Model.Horse;
import Part2.Model.HorsePanel;
import Part2.Model.RaceStatistics;
import Part2.Model.Track;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class HorseRaceFrame extends JFrame {
    private String raceId;
    private RaceStatistics raceStatistics;
    private List<HorsePanel> horsePanels;

    public HorseRaceFrame(Track track, List<Horse> horses, RaceStatistics raceStatistics) {
        int numLanes = track.getNumLanes();

        setTitle("Race Window");
        setSize(565, 90 * numLanes);
        setLocationRelativeTo(null);

        this.raceStatistics = raceStatistics;

        JPanel raceTrackPanel = new JPanel();
        raceTrackPanel.setLayout(new GridLayout(numLanes, 1));

        this.raceId = UUID.randomUUID().toString();

        this.horsePanels = new ArrayList<>();
        for (Horse horse : horses) {
            HorsePanel horsePanel = new HorsePanel(raceId, horse, track.getTrackLength(), raceStatistics);
            horsePanels.add(horsePanel);
            raceTrackPanel.add(horsePanel);
        }

        add(raceTrackPanel);
    }

    public void startGame() {
        for (HorsePanel panel : horsePanels) {
            new Thread(panel).start();
        }
    }

}