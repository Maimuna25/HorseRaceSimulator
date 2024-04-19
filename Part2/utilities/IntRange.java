package Part2.utilities;

import java.util.stream.IntStream;

public class IntRange {
    public static Integer[] getInRange(int min, int max, int step) {
        return IntStream.iterate(min, i -> i < max, i -> i + step)
                .boxed()
                .toArray(Integer[]::new);
    }
}
