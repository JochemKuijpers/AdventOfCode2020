package nl.jochemkuijpers.adventofcode2020.day2;

import nl.jochemkuijpers.adventofcode2020.common.Exercise;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Fairly straight-forward implementation. Goes over each line, parses the line with
 * a regular expression and checks the password, counts the valid passwords.
 */
public class Day2Part1 extends Exercise {

    public Day2Part1() {
        super(2, 1);
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

            int chrCount = 0;
            for (char passChr : password.toCharArray()) {
                if (passChr == chr) {
                    chrCount += 1;
                }
            }

            if (chrCount >= low && chrCount <= high) {
                numValid += 1;
            }
        }

        System.out.println(numValid);
    }

}
