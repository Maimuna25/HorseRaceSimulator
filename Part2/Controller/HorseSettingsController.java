package Part2.Controller;

import Part2.Model.Horse;
import Part2.View.HorseSettingsFrame;

import java.util.List;

public class HorseSettingsController {
    private HorseSettingsFrame horseSettingsFrame;

    public HorseSettingsController(MainFrameController parentController) {
        this.horseSettingsFrame = new HorseSettingsFrame(parentController.getTrackSettings(), parentController.getHorses());

        this.horseSettingsFrame.onCustomiseButtonClicked(_ -> {

            parentController.setHorses(getHorses());
            toggleFrameVisible(false);
        });
    }

    public List<Horse> getHorses() {
        return horseSettingsFrame.getHorses();
    }

    public void toggleFrameVisible(boolean makeVisible) {
        horseSettingsFrame.setVisible(makeVisible);
    }
}
