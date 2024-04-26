package Part1;

import java.util.concurrent.TimeUnit;
import java.lang.Math;

/**
 * A three-horse race, each horse running in its own lane
 * for a given distance
 *
 * @author McFarewell
 * @version 1.0
 */
public class Race {
    private int raceLength;
    private Horse lane1Horse;
    private Horse lane2Horse;
    private Horse lane3Horse;

    /**
     * Constructor for objects of class Race
     * Initially there are no horses in the lanes
     *
     * @param distance the length of the racetrack (in metres/yards...)
     */
    public Race(int distance) {
        // initialise instance variables
        raceLength = distance;
        lane1Horse = null;
        lane2Horse = null;
        lane3Horse = null;
    }

    /**
     * Adds a horse to the race in a given lane
     *
     * @param theHorse   the horse to be added to the race
     * @param laneNumber the lane that the horse will be added to
     * @throws IllegalArgumentException if the lane number is invalid
     */
    public void addHorse(Horse theHorse, int laneNumber) {
        if (laneNumber == 1) {
            lane1Horse = theHorse;
        } else if (laneNumber == 2) {
            lane2Horse = theHorse;
        } else if (laneNumber == 3) {
            lane3Horse = theHorse;
        } else {
            throw new IllegalArgumentException("Invalid lane number: " + laneNumber);
        }
    }

    private String determineWinner() {
        if (raceWonBy(lane1Horse)) {
            return lane1Horse.getName();
        } else if (raceWonBy(lane2Horse)) {
            return lane2Horse.getName();
        } else if (raceWonBy(lane3Horse)) {
            return lane3Horse.getName();
        }
        return "none of them";
    }


    /**
     * Start the race
     * The horse are brought to the start and
     * then repeatedly moved forward until the
     * race is finished
     */
    public void startRace() {
        //declare a local variable to tell us when the race is finished
        boolean finished = false;

        //reset all the lanes (all horses not fallen and back to 0).
        lane1Horse.goBackToStart();
        lane2Horse.goBackToStart();
        lane3Horse.goBackToStart();


        while (!finished) {
            //move each horse
            moveHorse(lane1Horse);
            moveHorse(lane2Horse);
            moveHorse(lane3Horse);

            //print the race positions
            printRace();
            if (raceWonBy(lane1Horse) || raceWonBy(lane2Horse) || raceWonBy(lane3Horse) ||
                    (lane1Horse.hasFallen() && lane2Horse.hasFallen() && lane3Horse.hasFallen())) {
                finished = true;
            }


            //wait for 100 milliseconds
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (Exception ignored) {
            }
        }

        System.out.println("And the winner is " + determineWinner());
    }

    /**
     * Randomly make a horse move forward or fall depending
     * on its confidence rating
     * A fallen horse cannot move
     *
     * @param theHorse the horse to be moved
     */
    private void moveHorse(Horse theHorse) {
        //if the horse has fallen it cannot move,
        //so only run if it has not fallen

        if (!theHorse.hasFallen()) {
            //the probability that the horse will move forward depends on the confidence;
            if (Math.random() < theHorse.getConfidence()) {
                theHorse.moveForward();
            }

            //the probability that the horse will fall is very small (max is 0.1)
            //but will also will depends exponentially on confidence
            //so if you double the confidence, the probability that it will fall is *2
            if (Math.random() < (0.1 * theHorse.getConfidence() * theHorse.getConfidence())) {
                if (theHorse.getConfidence() >= 0.1) {
                    theHorse.setConfidence(theHorse.getConfidence() - 0.1);
                }
                theHorse.fall();
            }

            //Increase confidence level by 0.1, if horse wins the race.
            if (raceWonBy(theHorse) && theHorse.getConfidence() <= 0.9) {
                theHorse.setConfidence(theHorse.getConfidence() + 0.1);
            }
        }
    }

    /**
     * Determines if a horse has won the race
     *
     * @param theHorse The horse we are testing
     * @return true if the horse has won, false otherwise.
     */
    private boolean raceWonBy(Horse theHorse) {
        return !theHorse.hasFallen() && theHorse.getDistanceTravelled() == raceLength;
//        if (theHorse.getDistanceTravelled() == raceLength)
//        {
//            return true;
//        }
//        else
//        {
//            return false;
//        }
    }

    /***
     * Print the race on the terminal
     */
    private void printRace() {
        // This code is unnecessary.
        // System.out.print('\u000C');  //clear the terminal window

        multiplePrint('=', raceLength + 3); //top edge of track
        System.out.println();

        printLane(lane1Horse);
        System.out.println();

        printLane(lane2Horse);
        System.out.println();

        printLane(lane3Horse);
        System.out.println();

        multiplePrint('=', raceLength + 3); //bottom edge of track
        System.out.println();
    }

    /**
     * print a horse's lane during the race
     * for example
     * |           X                      |
     * to show how far the horse has run
     */
    private void printLane(Horse theHorse) {
        //calculate how many spaces are needed before
        //and after the horse
        int spacesBefore = theHorse.getDistanceTravelled();
        int spacesAfter = raceLength - theHorse.getDistanceTravelled();

        //print a | for the beginning of the lane
        System.out.print('|');

        //print the spaces before the horse
        multiplePrint(' ', spacesBefore);

        //if the horse has fallen then print dead
        //else print the horse's symbol
        if (theHorse.hasFallen()) {
            System.out.print('\u2322');
        } else {
            System.out.print(theHorse.getSymbol());
        }

        //print the spaces after the horse
        multiplePrint(' ', spacesAfter);

        //print the | for the end of the track
        System.out.print('|');

        //print the horse's confidence level
        System.out.print(" " + theHorse.getName() +
                " (Current Confidence level " + (Math.round(theHorse.getConfidence() * 100.0) / 100.0) + ")");
    }


    /***
     * print a character a given number of times.
     * e.g. printmany('x',5) will print: xxxxx
     *
     * @param aChar the character to Print
     */
    private void multiplePrint(char aChar, int times) {
        int i = 0;
        while (i < times) {
            System.out.print(aChar);
            i = i + 1;
        }
    }
}

class RaceTest {
    public static void main(String[] args) {

        // Test case 1: Adding horses to all lanes
        Race race1 = new Race(10);
        Horse horse1 = new Horse('T', "Thunder", 0.8);
        Horse horse2 = new Horse('B', "Blaze", 0.7);
        Horse horse3 = new Horse('S', "Swift", 0.6);
        race1.addHorse(horse1, 1);
        race1.addHorse(horse2, 2);
        race1.addHorse(horse3, 3);
        race1.startRace();
        System.out.println();


        // Test case 3: Starting race without adding any horses
        Race race3 = new Race(10);
//        race3.startRace(); // Should print an error message

        // Additional test cases for other scenarios
        // ...

        // Ensure proper cleanup after tests
        System.exit(0);
    }
}

