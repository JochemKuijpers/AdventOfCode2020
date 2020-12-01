package nl.jochemkuijpers.adventofcode2020.day1;

import nl.jochemkuijpers.adventofcode2020.common.Exercise;
import nl.jochemkuijpers.adventofcode2020.common.Pair;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This problem can be naively solved by a double loop, trying all pairs of numbers,
 * to see which one sums to 2020, which has quadratic complexity.
 * <p>
 * A better strategy is to sort the list first, then walk two indices from both ends inwards.
 * If the sum of the two elements is larger than 2020, we move the pointer of the largest value down.
 * If the sum of the two elements is smaller than 2020, we move the pointer of the smallest value up.
 * We stop once the desired sum is found, or the two pointers meet.
 * <p>
 * This algorithm is implemented in {@link Day1Util#findPairInSortedWithSum}.
 */
public class Day1Part1 extends Exercise {

    public Day1Part1() {
        super(1, 1);
    }

    @Override
    public void accept(List<String> input) {
        List<Integer> sorted = input.stream().map(Integer::valueOf).sorted().collect(Collectors.toList());

        Pair<Integer, Integer> pair = Day1Util.findPairInSortedWithSum(sorted, 2020);

        if (pair == null) {
            System.out.println("not found");
        } else {
            System.out.printf("%d\n", pair.getFirst() * pair.getSecond());
        }
    }
}
