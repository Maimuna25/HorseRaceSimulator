package Part2.Controller;

import Part2.Model.Horse;
import Part2.Model.RaceStatistics;
import Part2.Model.Track;
import Part2.View.MainFrame;
import Part2.View.RaceWindow;
import Part2.data.Constants;

import java.util.ArrayList;
import java.util.List;

public class MainFrameController {
    private MainFrame mainFrame;
    private TrackSettingsController trackSettingsController;
    private HorseSettingsController horseSettingsController;
    private Track trackSettings;
    private List<Horse> horses;
    private RaceStatistics raceStatistics;

    public MainFrameController(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.raceStatistics = new RaceStatistics();

        setUpDefaultSettings();

        this.trackSettingsController = new TrackSettingsController(this);
        this.horseSettingsController = new HorseSettingsController(this);

        this.mainFrame.onCustomiseTrackButtonClicked(_ -> trackSettingsController.toggleFrameVisible(true));
        this.mainFrame.onCustomiseHorsesButtonClicked(_ -> {
            this.horseSettingsController = new HorseSettingsController(this);
            horseSettingsController.toggleFrameVisible(true);
        });

        this.mainFrame.onStartRaceButtonClicked(_ -> {
            System.out.println("Starting the race...");
            // Creating a race window with three horses
            RaceWindow raceWindow = new RaceWindow(trackSettings, horses, raceStatistics);
            raceWindow.setVisible(true);
        });

        this.mainFrame.onStatsButtonClicked(_ -> {
            // TODO: Add action to open the stats window
            System.out.println("Opening the stats window...");
        });

        this.mainFrame.onBettingButtonClicked(_ -> {
            // TODO: Add action to open the betting window
            System.out.println("Opening the betting window...");
        });
    }

    private void setUpDefaultSettings() {
        this.trackSettings = new Track(1, 500);
        this.horses = new ArrayList<>();
        horses.add(new Horse("Horse 0", Constants.BREEDS[0], Constants.COAT_COLORS[0]));
    }

    public void setTrackSettings(Track trackSettings) {
        this.trackSettings = trackSettings;

        // need to update the list of horses when track settings have changed.
        int diff = trackSettings.getNumLanes() - horses.size();
        if (diff > 0) {
            for (int i = horses.size(); i < trackSettings.getNumLanes(); i++) {
                horses.add(new Horse("Horse" + i, Constants.BREEDS[0], Constants.COAT_COLORS[0]));
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
}
