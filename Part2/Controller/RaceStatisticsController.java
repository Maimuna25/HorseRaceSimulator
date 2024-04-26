package Part2.Controller;

import Part2.View.RaceStatisticsFrame;

public class RaceStatisticsController {
    private MainFrameController parentController;
    private RaceStatisticsFrame raceStatisticsFrame;

    public RaceStatisticsController(MainFrameController parentController) {
        this.parentController = parentController;
        this.raceStatisticsFrame = new RaceStatisticsFrame(parentController.getRaceStatistics());
    }

    public void toggleFrameVisibility(boolean makeVisible) {
        raceStatisticsFrame.setVisible(makeVisible);
    }
}
