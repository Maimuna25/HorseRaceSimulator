package Part2.Controller;

import Part2.Model.Horse;
import Part2.Model.RaceStatistics;
import Part2.Model.Track;
import Part2.View.BettingSettingsFrame;
import Part2.View.MainFrame;
import Part2.data.Constants;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MainFrameController {
    private MainFrame mainFrame;
    private TrackSettingsController trackSettingsController;
    private HorseSettingsController horseSettingsController;
    private RaceStatisticsController raceStatisticsController;
    private BettingWindowController bettingWindowController;
    private HorseRaceController horseRaceController;
    private Track trackSettings;
    private List<Horse> horses;
    private RaceStatistics raceStatistics;

    public MainFrameController(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.raceStatistics = new RaceStatistics();

        setUpDefaultSettings();

        this.trackSettingsController = new TrackSettingsController(this);
        this.horseSettingsController = new HorseSettingsController(this);
        this.raceStatisticsController = new RaceStatisticsController(this);
        this.horseRaceController = new HorseRaceController(this);
        this.bettingWindowController = new BettingWindowController(horses);

        this.mainFrame.onCustomiseTrackButtonClicked(_ -> trackSettingsController.toggleFrameVisible(true));
        this.mainFrame.onCustomiseHorsesButtonClicked(_ -> {
            this.horseSettingsController = new HorseSettingsController(this);
            initializeBettingWindowController();
            horseSettingsController.toggleFrameVisible(true);
        });

        this.mainFrame.onStartRaceButtonClicked(_ -> {
            horseRaceController.toggleFrameVisibility(true);
        });

        this.mainFrame.onStatsButtonClicked(_ -> raceStatisticsController.toggleFrameVisibility(true));

        this.mainFrame.onBettingButtonClicked(_ -> BettingWindowController.toggleFrameVisibility(true));

    }

    // Initialize the BettingWindowController with the current list of horses
    private void initializeBettingWindowController() {
        this.bettingWindowController = new BettingWindowController(horses);
    }


    private void setUpDefaultSettings() {
        this.trackSettings = new Track(1, 500);
        this.horses = new ArrayList<>();
        horses.add(new Horse("Horse 0", Constants.COAT_COLORS[0], Constants.HAIR_COLOURS[0]));
    }

    public void setTrackSettings(Track trackSettings) {
        this.trackSettings = trackSettings;

        // update the list of horses when track settings have changed.
        int diff = trackSettings.getNumLanes() - horses.size();
        if (diff > 0) {
            for (int i = horses.size(); i < trackSettings.getNumLanes(); i++) {
                horses.add(new Horse("Horse " + i, Constants.COAT_COLORS[0], Constants.HAIR_COLOURS[0]));
            }
        } else if (diff < 0) {
            while (horses.size() > trackSettings.getNumLanes()) {
                horses.removeLast();
            }
        }
    }

    public Track getTrackSettings() {
        return trackSettings;
    }

    public void setHorses(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public RaceStatistics getRaceStatistics() {
        return raceStatistics;
    }
}
