package Part2;

import Part2.View.MainFrame;

import javax.swing.*;

public class RaceTrackApp {
    public static void main(String[] args) {
        // runs in AWT thread
        SwingUtilities.invokeLater(MainFrame::new);
    }
}