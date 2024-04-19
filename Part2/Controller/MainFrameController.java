package Part2.Controller;

import Part2.Model.Horse;
import Part2.Model.Track;
import Part2.View.MainFrame;
import Part2.data.Constants;

import java.util.ArrayList;
import java.util.List;

public class MainFrameController {
    private MainFrame mainFrame;
    private Track trackSettings;
    private List<Horse> horses;

    public MainFrameController(MainFrame mainFrame) {
        this.mainFrame = mainFrame;

        setUpDefaultSettings();
    }

    private void setUpDefaultSettings() {
        this.trackSettings = new Track(1, 500);
        this.horses = new ArrayList<>();
        horses.add(new Horse("Horse 0", Constants.BREEDS[0], Constants.COAT_COLORS[0]));
    }
}
