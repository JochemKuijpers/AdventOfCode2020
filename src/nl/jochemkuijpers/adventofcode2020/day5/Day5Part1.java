package nl.jochemkuijpers.adventofcode2020.day5;

import nl.jochemkuijpers.adventofcode2020.common.Exercise;

import java.util.List;
import java.util.Optional;

public class Day5Part1 extends Exercise {

    public Day5Part1() {
        super(5, 1);
    }

    @Override
    public void accept(List<String> input) {

        Optional<Integer> maxSeatID = input.stream()
                .map(line -> line.replace('F', '0'))
                .map(line -> line.replace('B', '1'))
                .map(line -> line.replace('L', '0'))
                .map(line -> line.replace('R', '1'))
                .map(line -> Integer.parseInt(line, 2))
                .max(Integer::compareTo);

        System.out.println(maxSeatID.get());

    }

}
