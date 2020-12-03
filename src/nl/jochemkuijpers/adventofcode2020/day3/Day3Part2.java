package nl.jochemkuijpers.adventofcode2020.day3;

import nl.jochemkuijpers.adventofcode2020.common.Exercise;

import java.util.List;

/**
 * Executes the same algorithm 5 times. Theoretically all could be done in one loop, but I didn't bother :)
 */
public class Day3Part2 extends Exercise {

    public Day3Part2() {
        super(3, 1);
    }

    @Override
    public void accept(List<String> input) {
        long val = Day3Util.countTreeCollisions(input, 1, 1)
                * Day3Util.countTreeCollisions(input, 3, 1)
                * Day3Util.countTreeCollisions(input, 5, 1)
                * Day3Util.countTreeCollisions(input, 7, 1)
                * Day3Util.countTreeCollisions(input, 1, 2);

        System.out.println(val);
    }


}
