package nl.jochemkuijpers.adventofcode2020.day2;

import nl.jochemkuijpers.adventofcode2020.common.Exercise;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Based on part 1 of course. Checks a different condition, but otherwise the same.
 */
public class Day2Part2 extends Exercise {

    public Day2Part2() {
        super(2, 2);
    }

    @Override
    public void accept(List<String> input) {
        Pattern pattern = Pattern.compile("(\\d+)-(\\d+) ([a-z]): ([a-z]+)");

        int numValid = 0;

        for (String line : input) {
            Matcher matcher = pattern.matcher(line);
            if (!matcher.find()) {
                throw new IllegalArgumentException("Illegal input.");
            }

            final int low = Integer.parseInt(matcher.group(1));
            final int high = Integer.parseInt(matcher.group(2));
            final char chr = matcher.group(3).charAt(0);
            final String password = matcher.group(4);

            // either the first character matches, or the last.. exclusive or.
            if ( (password.charAt(low - 1) == chr) ^ (password.charAt(high - 1) == chr) ) {
                numValid += 1;
            }
        }

        System.out.println(numValid);
    }

}
