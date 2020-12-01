package nl.jochemkuijpers.adventofcode2020.day1;

import nl.jochemkuijpers.adventofcode2020.common.Exercise;
import nl.jochemkuijpers.adventofcode2020.common.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Building on the previous solution, I still find a pair that sums to a desired sum,
 * though the desired sum is reduced by some amount.
 * <p>
 * The reduction of the desired sum is our third value, which means we can execute our previous
 * algorithm from part 1 and find the triplet of values in an additional linear factor.
 */
public class Day1Part2 extends Exercise {

    public Day1Part2() {
        super(1, 2);
    }

    @Override
    public void accept(List<String> input) {
        List<Integer> sorted = input.stream().map(Integer::valueOf).sorted().collect(Collectors.toList());

        Pair<Integer, Integer> pair = null;
        int third = 0;

        for (int thirdIdx = 0; thirdIdx < sorted.size(); thirdIdx++) {
            // select the 'third' value.
            third = sorted.get(thirdIdx);

            // make a copy without the third value
            List<Integer> sortedWithoutThird = new ArrayList<>(sorted);
            sortedWithoutThird.remove(thirdIdx);

            // now find a pair that sums to 2020 minus the third value
            pair = Day1Util.findPairInSortedWithSum(sortedWithoutThird, 2020 - third);
            if (pair != null) {
                break;
            }
        }

        if (pair == null) {
            System.out.println("not found");
        } else {
            System.out.printf("%d\n", pair.getFirst() * pair.getSecond() * third);
        }
    }
}
