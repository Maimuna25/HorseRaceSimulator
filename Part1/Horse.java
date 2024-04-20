package Part1;

/**
 * The Horse class represents a horse participating in a horse race simulation.
 * The class provides methods to access and modify the horse's attributes.
 * @author Maimuna Nowaz
 * @version 1
 */
public class Horse {
    //Fields of class Horse
    private String horseName;
    private char horseSymbol;
    private double horseConfidence;
    private int distanceTravelled;
    private boolean fallen;

    //Constructor of class Horse

    /**
     * Constructor for objects of class Horse
     */
    public Horse(char horseSymbol, String horseName, double horseConfidence) {
        this.horseSymbol = horseSymbol;
        this.horseName = horseName;
        this.horseConfidence = horseConfidence;
        this.distanceTravelled = 0;
        this.fallen = false;
    }



    //Other methods of class Horse
    public void fall() {
        this.fallen = true;
    }

    public double getConfidence() {
        return horseConfidence;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public String getName() {
        return horseName;
    }

    public char getSymbol() {
        return horseSymbol;
    }

    public void goBackToStart() {
        this.distanceTravelled = 0;
        this.fallen = false;
    }

    public boolean hasFallen() {
        return fallen;
    }

    public void moveForward() {
        if (!fallen) {
            this.distanceTravelled++;
        }
    }

    public void setConfidence(double newConfidence) {
        if (newConfidence >= 0 && newConfidence <= 1) {
            this.horseConfidence = newConfidence;
        } else {
            System.out.println("Confidence rating must be between 0 and 1.");
        }
    }

    public void setSymbol(char newSymbol) {
        this.horseSymbol = newSymbol;
    }

}
