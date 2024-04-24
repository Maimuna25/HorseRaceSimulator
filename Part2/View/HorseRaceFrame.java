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
    private List<HorsePanel> horsePanels;
    private static HorseRaceFrame instance;

    public HorseRaceFrame(Track track, List<Horse> horses, RaceStatistics raceStatistics) {
        int numLanes = track.getNumLanes();
        int trackLength = track.getTrackLength();
        int laneWidth = 108;
        int frameWidth = laneWidth + trackLength;

        instance = this;

        setTitle("Race Window");
        setSize(frameWidth, 90 * numLanes);
        setLocationRelativeTo(null);

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

    public static HorseRaceFrame getFrame() {
        return instance;
    }

    public void startGame() {
        for (HorsePanel panel : horsePanels) {
            new Thread(panel).start();
        }
    }

}