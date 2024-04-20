package Part2.Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RaceStatistics {
    private List<RaceStatisticsEntry> raceStatisticsEntries;

    public RaceStatistics() {
        this.raceStatisticsEntries = new ArrayList<>();

        // Get all the data from raceStatistics.csv and enter them into raceStatisticsEntry
        try (BufferedReader br = new BufferedReader(new FileReader("Part2/data/raceStatistics.csv"))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                RaceStatisticsEntry entry = new RaceStatisticsEntry(
                        values[0],
                        values[1],
                        Double.parseDouble(values[2]),
                        Integer.parseInt(values[3]),
                        values[4].equals("1"),
                        values[5].equals("1"),
                        values[6].equals("1")
                );
                raceStatisticsEntries.add(entry);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
