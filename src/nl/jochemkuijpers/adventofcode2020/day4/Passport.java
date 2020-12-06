package nl.jochemkuijpers.adventofcode2020.day4;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * A helper class for Day 4, validates a set of key value pairs by various criteria.
 */
public class Passport {

    private static final Set<String> REQUIRED_KEYS = Set.of("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid");
    private static final Set<String> VALID_ECL_VALUES = Set.of("amb", "blu", "brn", "gry", "grn", "hzl", "oth");

    private final Map<String, String> keyValues;

    public Passport() {
        keyValues = new HashMap<>();
    }

    public void addKeyValue(String key, String value) {
        keyValues.put(key, value);
    }

    /**
     * Validates the password.
     *
     * @param isPart1   whether part 1 or part 2 validation should be applied
     * @return          whether the passport is valid
     */
    public boolean isValid(boolean isPart1) {
        boolean valid = keyValues.keySet().containsAll(REQUIRED_KEYS);
        if (!valid || isPart1) {
            return valid;
        }

        try {
            int byr = Integer.parseInt(keyValues.getOrDefault("byr", ""));
            if (byr < 1920 || byr > 2002) return false;
            int iyr = Integer.parseInt(keyValues.getOrDefault("iyr", ""));
            if (iyr < 2010 || iyr > 2020) return false;
            int eyr = Integer.parseInt(keyValues.getOrDefault("eyr", ""));
            if (eyr < 2020 || eyr > 2030) return false;

            String hgtString = keyValues.getOrDefault("hgt", "");
            int hgt = Integer.parseInt(hgtString.substring(0, hgtString.length() - 2));
            if (hgtString.endsWith("cm")) {
                if (hgt < 150 || hgt > 193) return false;
            } else if (hgtString.endsWith("in")) {
                if (hgt < 59 || hgt > 76) return false;
            } else {
                return false;
            }

            String hclString = keyValues.getOrDefault("hcl", "");
            if (!hclString.matches("(#[0-f]{6})")) return false;

            String eclString = keyValues.getOrDefault("ecl", "");
            if (!VALID_ECL_VALUES.contains(eclString)) return false;

            String pidString = keyValues.getOrDefault("pid", "");
            if (!pidString.matches("([0-9]{9})")) return false;

        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
