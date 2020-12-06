package nl.jochemkuijpers.adventofcode2020.day4;

import nl.jochemkuijpers.adventofcode2020.common.Exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Since the algorithm for validating passwords is the only thing that differs, this class covers both part 1 and 2.
 */
public class Day4 extends Exercise {

    private final boolean isPart1;

    public Day4(boolean isPart1) {
        super(4, isPart1 ? 1 : 2);
        this.isPart1 = isPart1;
    }

    @Override
    public void accept(List<String> input) {
        final List<Passport> passports = new ArrayList<>();
        Passport currentPassport = new Passport();

        for (String line : input) {
            if (line.isBlank()) {
                passports.add(currentPassport);
                currentPassport = new Passport();
            } else {
                String[] keyValues = line.split(" ");
                for (String keyValue : keyValues) {
                    String[] parts = keyValue.split(":");
                    currentPassport.addKeyValue(parts[0], parts[1]);
                }
            }
        }
        passports.add(currentPassport);

        long validCount = passports.stream().filter(p -> p.isValid(isPart1)).count();

        System.out.println(validCount);
    }
}
