package Part2.Model;

import javax.swing.*;
import java.awt.*;

public class HorsePanel extends JPanel implements Runnable {
    public static final String HORSE_IMAGE = "Part2/assets/horseblack-blacksaddle-blackbridle-blackhair.png";
    private String raceId;
    private Horse horse;
    private String horseName;
    private RaceStatistics raceStatistics;
    private int trackLength;
    private int position = 0;
    private boolean fallen = false; // Track if the horse has fallen

    public HorsePanel(String raceId, Horse horse, int trackLength, RaceStatistics raceStatistics) {
        this.horse = horse;
        this.horseName = horse.getHorseName(); // Assuming there is a getter for horseName in Horse class
        this.raceStatistics = raceStatistics;
        this.trackLength = trackLength;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // If the horse has fallen, rotate the image by 180 degrees clockwise
        if (fallen) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.rotate(Math.PI, position + 15, 41);
            g2d.drawImage(Toolkit.getDefaultToolkit().getImage(HORSE_IMAGE), position, 28, 30, 26, null);
            g2d.dispose();
        } else {
            g.drawImage(Toolkit.getDefaultToolkit().getImage(HORSE_IMAGE), position, 28, 30, 26, null);
        }

        g.drawString(horseName, position, 18);
    }

    @Override
    public void run() {
        long startingTime = System.currentTimeMillis();
        while (position < 550 && !fallen) {
            // Probability that the horse will move forward depends on the confidence
            if (Math.random() < horse.getHorseConfidence()) {
                position += (int) (Math.random() * 10);
            } else {
                // If the horse doesn't move forward, check if it falls
                double fallProbability = 0.1 * horse.getHorseConfidence() * horse.getHorseConfidence();
                if (Math.random() < 0.01) {
                    fallen = true;
                }
            }

            repaint();
            try {
                Thread.sleep(100); // Adjust speed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Race finished or horse has fallen, update statistics
        int timeTaken = (int) ((System.currentTimeMillis() - startingTime) / 1000);
        double averageSpeed = (double) trackLength / timeTaken;
        raceStatistics.updateRaceStatistics(new RaceStatisticsEntry(
                raceId,
                horse.getHorseName(),
                averageSpeed,
                timeTaken,
                false,  // TODO: figure out whether the horse won or not.
                false,      // TODO: figure out whether the horse finished the race or not if it didn't win.
                fallen
        ));
    }



}