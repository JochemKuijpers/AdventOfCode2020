package nl.jochemkuijpers.adventofcode2020;

import nl.jochemkuijpers.adventofcode2020.common.Exercise;
import nl.jochemkuijpers.adventofcode2020.day1.Day1Part1;
import nl.jochemkuijpers.adventofcode2020.day1.Day1Part2;
import nl.jochemkuijpers.adventofcode2020.day2.Day2Part1;
import nl.jochemkuijpers.adventofcode2020.day2.Day2Part2;
import nl.jochemkuijpers.adventofcode2020.day3.Day3Part1;
import nl.jochemkuijpers.adventofcode2020.day3.Day3Part2;
import nl.jochemkuijpers.adventofcode2020.day4.Day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final List<Exercise> EXERCISE_LIST = List.of(
            new Day1Part1(),
            new Day1Part2(),
            new Day2Part1(),
            new Day2Part2(),
            new Day3Part1(),
            new Day3Part2(),
            new Day4(true),
            new Day4(false)
    );

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        System.out.println("-= Advent of Code 2020 =-");
        System.out.println("-= by  Jochem Kuijpers =-");
        System.out.println();

        boolean keepGoing;
        do {
            keepGoing = pickAndExecuteExercise(scanner);
        } while (keepGoing);

        System.out.println();
        System.out.println();
        System.out.println("  Happy holidays!  ");
        System.out.println();
        System.out.println();
    }

    private static boolean pickAndExecuteExercise(Scanner scanner) {
        final Exercise exercise = CommandLineUtils.selectFromItems(EXERCISE_LIST);

        if (exercise == null) {
            return false;
        }

        System.out.println();
        System.out.printf("Selected: %s\n", exercise.getName());

        System.out.println();
        System.out.println("--- put your input in the input.txt file and press enter ---");
        System.out.println();

        scanner.nextLine();

        final List<String> input;
        try {
            input = new ArrayList<>(Files.readAllLines(Paths.get("input.txt")));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        System.out.printf("--- got %s lines of input ---\n", input.size());
        System.out.println();
        System.out.println("-v- output below -v-");
        System.out.println();

        long start = System.nanoTime();

        exercise.accept(input);

        long stop = System.nanoTime();

        System.out.println();
        System.out.println("-^- output above -^-");
        System.out.println();
        System.out.printf("Took %.4fms.\n", (stop - start) / 1e6);
        System.out.println();

        return true;
    }
}
