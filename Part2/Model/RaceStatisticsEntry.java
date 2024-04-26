package Part2.Model;

public class RaceStatisticsEntry {
    private String raceId;
    private String horseName;
    private double averageSpeed;
    private int finishingTime;
    private boolean win;
    private boolean lose;
    private boolean fallen;

    public RaceStatisticsEntry(String raceId, String horseName, double averageSpeed, int finishingTime, boolean win, boolean lose, boolean fallen) {
        this.raceId = raceId;
        this.horseName = horseName;
        this.averageSpeed = averageSpeed;
        this.finishingTime = finishingTime;
        this.win = win;
        this.lose = lose;
        this.fallen = fallen;
    }

    public double getAverageSpeed() {
        return averageSpeed;
    }

    public int getFinishingTime() {
        return finishingTime;
    }

    public int getDistanceTravelled() {
        return (int) Math.round(averageSpeed * finishingTime);
    }

    public String getRaceId() {
        return raceId;
    }

    public String getHorseName() {
        return horseName;
    }

    public boolean hasWon() {
        return win;
    }

    public boolean hasLost() {
        return lose;
    }

    public boolean hasFallen() {
        return fallen;
    }

    // Retrieves the values of the race statistics entry attributes and stores them in a String array.
    public String[] values() {
        return new String[] {
                raceId,
                horseName,
                String.valueOf(averageSpeed),
                String.valueOf(finishingTime),
                win ? "1" : "0",
                lose ? "1" : "0",
                fallen ? "1" : "0"
        };
    }
}
