package Part2.View;

import Part2.Model.Horse;
import Part2.Model.HorsePanel;
import Part2.Model.RaceStatistics;
import Part2.Model.Track;
import Part2.data.Constants;

import javax.swing.*;
import javax.swing.border.Border;
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
        int laneWidth = 22;
        int frameWidth = laneWidth + trackLength;

        instance = this;

        setTitle("Race Window");
        setSize(frameWidth, 90 * numLanes);
        setLocationRelativeTo(null);

        JPanel raceTrackPanel = new JPanel();
        raceTrackPanel.setLayout(new GridLayout(numLanes, 1));

        this.raceId = UUID.randomUUID().toString();

        this.horsePanels = new ArrayList<>();


        for (int i = 0; i < horses.size(); i++) {
            Horse horse = horses.get(i);
            HorsePanel horsePanel = new HorsePanel(raceId, horse, track.getTrackLength(), raceStatistics);

            Color[] laneColors = Constants.LANE_COLOURS;
            horsePanel.setBackground(laneColors[i % laneColors.length]);

            Border border = BorderFactory.createLineBorder(Color.BLACK);
            horsePanel.setBorder(border);

            JLabel finishLineLabel = new JLabel(new ImageIcon("Part2/assets/Race_Flag.png"));
            horsePanel.add(finishLineLabel, BorderLayout.EAST);

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
