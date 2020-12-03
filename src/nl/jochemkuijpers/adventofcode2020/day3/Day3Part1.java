package nl.jochemkuijpers.adventofcode2020.day3;

import nl.jochemkuijpers.adventofcode2020.common.Exercise;

import java.util.List;

/**
 * The entire algorithm is in {@link Day3Util}, as it is reused in part 2.
 */
public class Day3Part1 extends Exercise {

    public Day3Part1() {
        super(3, 1);
    }

    @Override
    public void accept(List<String> input) {
        System.out.println(Day3Util.countTreeCollisions(input, 3, 1));
    }


}
