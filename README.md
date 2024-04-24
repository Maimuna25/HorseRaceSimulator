# Horse Race Simulator

Welcome to the Horse Race Simulator project! This project simulates horse races in both textual and graphical formats.

### Description

The Horse Race Simulator consists of two parts:
* Part 1 (Textual Version): Simulates a three-horse race in a textual format.
* Part 2 (Graphical Version): Simulates the same race with a graphical user interface (GUI).

## Part 1: Textual Version

### Instructions on how to play:

Start the Race:

Upon launching the textual version of the simulator, you'll be presented with a pre-configured race with three horses.
To begin the race, simply run the startRace() method in the RaceTest class.

Monitor the Race:

Once the race starts, the horses will move forward randomly based on their confidence levels.
Each horse has a symbol representing it on the track, and you'll see their positions updated in real-time as they progress.
You can track the progress of each horse as they move towards the finish line.

Determine the Winner:

The race continues until one of the horses reaches the finish line (completes the race length).
If a horse falls during the race, it can no longer progress forward.
The first horse to reach the finish line without falling wins the race.

End of Race:

Once the race is over and a winner is determined, the simulator will announce the name of the winning horse.
The race statistics, including the distance traveled by each horse and their confidence levels, will be displayed.

Repeat or Adjust:

You can repeat the race with the same configuration or adjust parameters such as race length, horse confidence levels, and more to see different outcomes.

Enjoy the excitement of the race as you watch the horses compete to be crowned the champion!

## Part 2: Graphical Version

### Overview

The Horse Racing Simulator GUI Module expands upon the groundwork established in Part I, introducing fresh and innovative features to create an immersive and interactive experience for users. 

This module includes the following key features:
1. Customisable Track Design
2. Customisable Horses
3. Statistics and Analytics

### Instructions on how to play:

Upon launching the GUI, users will be presented with four buttons on the homepage:

1. Customise Track: Before starting the race, users can design their own racing track by specifying the number of lanes and setting the lengths of the tracks for each horse. Whether you prefer a straightforward sprint or a more challenging course, the choice is yours!
2. Customise Horses: Personalise your horses by selecting various options such as coat colour, saddle colour, bridle colour, and more. Experiment with different combinations to create unique-looking horses that reflect your style and preferences. Preview how your horses will appear on the track before proceeding to the race.
3. Start Race: Once you've customised the track and horses to your liking, click the "Start Race" button to begin the race. Sit back, relax, and watch as the horses gallop towards the finish line. Feel the excitement as they compete for victory, and cheer on your favourites as they strive to cross the finish line first.
4. View Statistics and Analytics: After the race concludes, click on the "View Statistics and Analytics" button to access detailed statistics and analytics for each horse. Analyse their performance metrics such as average time, falls, and distance traveled to gain insights into their racing abilities and identify areas for improvement.

 With more customisation options and the ability to race with additional horses, the graphical version of the Horse Racing Simulator offers an enhanced gaming experience that is both engaging and entertaining. So, gather your friends, customise your horses, and get ready for an exhilarating race to the finish line!

## Set Up

### Part 1

To run the textual version of the simulator, execute the following command on your terminal:

1. Clone the repository:
   
   git clone https://github.com/Maimuna25/HorseRaceSimulator.git
3. Compile and Run:
   
   cd HorseRaceSimulator
5. Run the textual version by typing:
   
   java Part1.RaceTest

### Part 2

To set up and run the Horse Racing Simulator GUI Module on your local machine, follow these steps:
Go to your terminal

1. Clone the Repository:
   
   git clone https://github.com/Maimuna25/HorseRaceSimulator.git
3. Compile and Run: Compile and run the GUI module to launch the application.

   cd HorseRaceSimulator

   javac *.java
5. Run the GUI application by typing:
   
   java Part2.RaceTrackApp


