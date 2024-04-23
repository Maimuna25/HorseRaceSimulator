package Part2.utilities;

import java.util.stream.IntStream;

public class IntRange {

    // Generate a stream of integers within the range [min, max) with the specified step
    //.boxed() function converts the primitive stream to a boxed stream of Integer objects
    public static Integer[] getInRange(int min, int max, int step) {
        return IntStream.iterate(min, i -> i < max, i -> i + step)
                .boxed()
                .toArray(Integer[]::new);
    }
}
