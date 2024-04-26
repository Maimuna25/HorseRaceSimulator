package Part2.Model;

public class Track {
    private int numLanes;
    private int trackLength;

    public Track(int numLanes, int trackLength) {
        this.numLanes = numLanes;
        this.trackLength = trackLength;
    }

    public int getNumLanes() {
        return numLanes;
    }

    public int getTrackLength() {
        return trackLength;
    }
}
