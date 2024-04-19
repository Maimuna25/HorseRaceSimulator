package Part1;

public class Main {
    public static void main(String[] args) {
        Horse myHorse = new Horse('H', "Thunder", 0.8);

        System.out.println("Horses name: " + myHorse.getName());
        System.out.println("Symbol: " + myHorse.getSymbol());
        System.out.println("Confidence Level: " + myHorse.getConfidence());
        System.out.println("Distance Travelled: " + myHorse.getDistanceTravelled());
        System.out.println();

        myHorse.moveForward();
        System.out.println("New distance: " + myHorse.getDistanceTravelled());

        myHorse.setConfidence(0.9);
        System.out.println("Updated Confidence level: " + myHorse.getConfidence());

        myHorse.setSymbol('T');
        System.out.println("New symbol: " + myHorse.getSymbol());
    }
}