package nl.jochemkuijpers.adventofcode2020.day3;

import java.util.List;

/**
 * We don't need to build a map or anything, we can maintain a collision count as we iterate over the input.
 */
public class Day3Util {

    public static long countTreeCollisions(List<String> input, int dx, int dy) {
        int x = 0;
        long numTrees = 0;

        for (int y = 0; y < input.size(); y += dy) {
            final String line = input.get(y);
            numTrees += line.charAt(x) == '#' ? 1 : 0;
            x = (x + dx) % line.length();
        }

        return numTrees;
    }

}
