package Part2.Model;

public class RaceStatisticsEntry {
    private double averageSpeed;
    private long finishingTime; // Represented in milliseconds

    public RaceStatisticsEntry(double averageSpeed, long finishingTime) {
        this.averageSpeed = averageSpeed;
        this.finishingTime = finishingTime;
    }

    public double getAverageSpeed() {
        return averageSpeed;
    }

    public long getFinishingTime() {
        return finishingTime;
    }

}
