package Part2.Model;

import Part2.View.WinnerPopUpFrame;

import javax.swing.*;
import java.awt.*;

public class HorsePanel extends JPanel implements Runnable {
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
        winner = null;
        setLayout(new BorderLayout());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int horseWidth = 30;
        int horseHeight = 26;

        // Calculate the actual position of the horse
        int actualPosition = position;
        if (actualPosition + horseWidth > trackLength) {
            actualPosition = trackLength - horseWidth;
        }

        // Draw the horse image at the calculated position
        if (fallen) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.rotate(Math.PI, actualPosition + 15, 41);
            g2d.drawImage(Toolkit.getDefaultToolkit().getImage(horse.getImagePath()), actualPosition, 28, 30, 26, null);
            g2d.dispose();
        } else {
            g.drawImage(Toolkit.getDefaultToolkit().getImage(horse.getImagePath()), actualPosition, 28, horseWidth, horseHeight, null);
        }

        // Draw the horse name and status text
        int statusTextPosition = actualPosition + horseWidth + 18;
        g.drawString(horseName, actualPosition, 18);
        String status;
        if (fallen) {
            status = ":Fallen";
        } else if (finished) {
            status = "";
        } else {
            status = ":Running";
        }
        g.drawString(status, statusTextPosition, 18);
    }

    @Override
    public void run() {
        long startingTime = System.currentTimeMillis();
        while (position < trackLength && !fallen) {

            if (Math.random() < horse.getHorseConfidence()) {
                position += (int) (Math.random() * 20);
            } else {
                if (Math.random() < 0.01) {
                    fallen = true;
                }
            }

            // Check if the horse has finished the race
            if (position >= trackLength && !fallen && !finished) {
                finished = true;
                if (winner == null) {
                    winner = this; // Set this horse as the winner
                    awardFirstPlace();
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

        if (firstPlace && winner == this) {
            String winnerName = horseName;
            new WinnerPopUpFrame(winnerName);
        }
    }

    public void awardFirstPlace() {
        firstPlace = true;
    }
}