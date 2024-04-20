package Part2.Controller;

import Part2.View.HorseRaceFrame;

public class HorseRaceController {

    private MainFrameController parentController;
    private HorseRaceFrame horseRaceFrame;

    public HorseRaceController(MainFrameController parentController) {
        this.parentController = parentController;
        setUpHorseRace();
    }

    public void toggleFrameVisibility(boolean makeVisible) {
        setUpHorseRace();
        horseRaceFrame.setVisible(makeVisible);
        horseRaceFrame.startGame();
    }

    private void setUpHorseRace() {
        horseRaceFrame = new HorseRaceFrame(
                parentController.getTrackSettings(),
                parentController.getHorses(),
                parentController.getRaceStatistics()
        );
    }
}
