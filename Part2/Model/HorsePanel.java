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
    private String horseName;
    private RaceStatistics raceStatistics;
    private int position = 0;

    public HorsePanel(String horseName, RaceStatistics raceStatistics) {
        this.horseName = horseName;
        this.raceStatistics = raceStatistics;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(Toolkit.getDefaultToolkit().getImage("Part2/assets/horse5-nosaddle.png"), position, 28, 30, 26, null);
        g.drawString(horseName, position, 18);
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
        double averageSpeed = Math.random() * 40;
        long timeTaken = System.currentTimeMillis() - startingTime;
        raceStatistics.updateRaceStatistics(new RaceStatisticsEntry(averageSpeed, timeTaken));
    }
}

