package Part2.Controller;

import Part2.Model.Track;
import Part2.View.TrackSettingsFrame;

public class TrackSettingsController {
    private MainFrameController parentController;
    private TrackSettingsFrame trackSettingsFrame;

    public TrackSettingsController(MainFrameController parentController) {
        this.parentController = parentController;
        this.trackSettingsFrame = new TrackSettingsFrame(parentController.getTrackSettings());

        this.trackSettingsFrame.onApplyButtonClicked(_ -> {
            parentController.setTrackSettings(getTrackSettings());
            toggleFrameVisible(false);
        });
    }

    public Track getTrackSettings() {
        return trackSettingsFrame.getTrackSettings();
    }

    public void toggleFrameVisible(boolean makeVisible) {
        trackSettingsFrame.setVisible(makeVisible);
    }
}
