package Part2.Model;

import Part2.View.WinnerPopUpFrame;

import javax.swing.*;
import java.awt.*;

public class HorsePanel extends JPanel implements Runnable {
    public static final String HORSE_IMAGE = "Part2/assets/horseblack-blacksaddle-blackbridle-blackhair.png";
    private String raceId;
    private Horse horse;
    private String horseName;
    private RaceStatistics raceStatistics;
    private int trackLength;
    private int position;
    private boolean fallen;
    private boolean finished;
    private boolean firstPlace;
    private static HorsePanel winner;


    public HorsePanel(String raceId, Horse horse, int trackLength, RaceStatistics raceStatistics) {
        this.raceId = raceId;
        this.horse = horse;
        this.horseName = horse.getHorseName();
        this.raceStatistics = raceStatistics;
        this.trackLength = trackLength;
        this.position = 0;
        this.fallen = false;
        this.finished = false;
        this.firstPlace = false;
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

        // Draw status
        String status;
        if (fallen) {
            status = ":Fallen";
        } else if (finished) {
            status = ":Finished";
        } else {
            status = ":Running";
        }
        g.drawString(status, position + 50, 18);
    }

    @Override
    public void run() {
        long startingTime = System.currentTimeMillis();
        while (position < trackLength && !fallen) {
            // Probability that the horse will move forward depends on the confidence
            if (Math.random() < horse.getHorseConfidence()) {
                position += (int) (Math.random() * 20);
            } else {
                if (Math.random() < 0.01) {
                    fallen = true;
                }
            }

            // End the race when all horses (not fallen) have finished the race.
            // Set the winner if no winner has been set once the first horse has reached the end
            // call awardFirstPlace function
            if (position >= trackLength && !fallen && !finished) {
                    finished = true;
                if (winner == null) {
                    winner = this;
                    awardFirstPlace();

                    String winnerName = horseName;
                    new WinnerPopUpFrame(winnerName);
                }
            }

            repaint();
            try {
                Thread.sleep(80); // Adjust speed
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
                finished && firstPlace,
                finished && !firstPlace,
                fallen
        ));
    }

    public void awardFirstPlace() {
        firstPlace = true;
    }

}