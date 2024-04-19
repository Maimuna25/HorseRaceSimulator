package Part2.Model;

import java.util.ArrayList;
import java.util.List;

public class RaceStatistics {
    private List<RaceStatisticsEntry> raceStatisticsEntries;

    public RaceStatistics() {
        this.raceStatisticsEntries = new ArrayList<>();

        // TODO: Get all the data from raceStatistics.csv and enter them into raceStatisticsEntry
    }

    // Method to update statistics for a race
    public void updateRaceStatistics(RaceStatisticsEntry entry) {
        raceStatisticsEntries.add(entry);

        // TODO: Add this entry into raceStatistics.csv as well.
    }

    public RaceStatisticsEntry getRaceStatistics(int index) {
        return raceStatisticsEntries.get(index);
    }

    public int size() {
        return raceStatisticsEntries.size();
    }
}
