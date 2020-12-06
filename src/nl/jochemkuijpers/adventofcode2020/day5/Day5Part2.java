package nl.jochemkuijpers.adventofcode2020.day5;

import nl.jochemkuijpers.adventofcode2020.common.Exercise;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Day5Part2 extends Exercise {

    public Day5Part2() {
        super(5, 2);
    }

    @Override
    public void accept(List<String> input) {

        Set<Integer> seatIds = input.stream()
                .map(line -> line.replace('F', '0'))
                .map(line -> line.replace('B', '1'))
                .map(line -> line.replace('L', '0'))
                .map(line -> line.replace('R', '1'))
                .map(line -> Integer.parseInt(line, 2))
                .collect(Collectors.toSet());

        for (int i = 0; i < 1024; i++) {
            if (seatIds.contains(i)) { continue; }

            if (seatIds.contains(i-1) && seatIds.contains(i+1)) {
                System.out.println(i);
            }
        }
    }

}
