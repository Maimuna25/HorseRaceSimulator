package Part2.Model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RaceStatistics {
    public static final String RACE_DATA_FILE = "Part2/data/raceStatistics.csv";
    private List<RaceStatisticsEntry> raceStatisticsEntries;
    private String[] headers;

    public RaceStatistics() {
        this.raceStatisticsEntries = new ArrayList<>();

        // Get all the data from raceStatistics.csv and enter them into raceStatisticsEntry
        try (BufferedReader br = new BufferedReader(new FileReader(RACE_DATA_FILE))) {
            String line;
            this.headers = br.readLine().split(",");  // Remove the header

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
            e.printStackTrace();
        }
    }

    // Method to update statistics for a race
    public void updateRaceStatistics(RaceStatisticsEntry entry) {
        raceStatisticsEntries.add(entry);

        // Add this entry into raceStatistics.csv.
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RACE_DATA_FILE, true))) {
            bw.write(String.join(",", entry.values()) + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<RaceStatisticsEntry> getAllEntries() {
        return raceStatisticsEntries;
    }

    public RaceStatisticsEntry getRaceStatistics(int index) {
        return raceStatisticsEntries.get(index);
    }

    public int size() {
        return raceStatisticsEntries.size();
    }

    public String[] getHeaders() {
        return headers;
    }

    //Retrieves the data stored in the race statistics entries and organises it into a 2D array.
    public String[][] getData() {
        String[][] data = new String[raceStatisticsEntries.size()][headers.length];
        for (int i = 0; i < raceStatisticsEntries.size(); i++) {
            data[i] = raceStatisticsEntries.get(i).values();
        }
        return data;
    }
}
