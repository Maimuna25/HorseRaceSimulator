package Part2.Model;

import Part2.View.ImagePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class HorsePanel extends JPanel implements Runnable {
    public static final String HORSE_IMAGE = "Part2/assets/horseblack-blacksaddle-blackbridle-blackhair.png";
    private String raceId;
    private Horse horse;
    private int trackLength;
    private RaceStatistics raceStatistics;
    private int position = 0;

    public HorsePanel(String raceId, Horse horse, int trackLength, RaceStatistics raceStatistics) {
        this.horse = horse;
        this.trackLength = trackLength;
        this.raceStatistics = raceStatistics;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(Toolkit.getDefaultToolkit().getImage(HORSE_IMAGE), position, 28, 30, 26, null);
        g.drawString(horse.getHorseName(), position, 18);
    }

    @Override
    public void run() {
        long startingTime = System.currentTimeMillis();
        while (position < 550) { // Adjust according to your track length
            position += (int) (Math.random() * 10); 
            repaint();
            try {
                Thread.sleep(100); // Adjust speed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // Race finished, update statistics
        long timeTaken = (System.currentTimeMillis() - startingTime) / 1000;
        double averageSpeed = (double) trackLength / timeTaken;

        // TODO: figure out whether the horse has won, lost or fallen.
        raceStatistics.updateRaceStatistics(new RaceStatisticsEntry(raceId, horse.getHorseName(), averageSpeed, timeTaken, false, false, false));
    }
}

