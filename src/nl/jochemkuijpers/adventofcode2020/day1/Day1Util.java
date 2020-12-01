package nl.jochemkuijpers.adventofcode2020.day1;

import nl.jochemkuijpers.adventofcode2020.common.Pair;

import java.util.List;

public class Day1Util {

    /**
     * Implements the algorithm described in day 1 part 1, which is reused in part 2.
     * The list of values is assumed to be sorted.
     *
     * @param sorted        the sorted list of values
     * @param requiredSum   the required sum
     * @return              a pair of numbers in the list of values that sum to the required sum, or null.
     */
    public static Pair<Integer, Integer> findPairInSortedWithSum(List<Integer> sorted, int requiredSum) {
        int highIdx = sorted.size() - 1;
        int lowIdx = 0;
        int sum = 0;

        while (highIdx > lowIdx) {
            sum = sorted.get(lowIdx) + sorted.get(highIdx);

            if (sum > requiredSum) {
                highIdx -= 1;
                continue;
            }

            if (sum < requiredSum) {
                lowIdx += 1;
                continue;
            }

            break;
        }

        if (sum != requiredSum) {
            return null;
        }

        return Pair.of(sorted.get(lowIdx), sorted.get(highIdx));
    }

}
