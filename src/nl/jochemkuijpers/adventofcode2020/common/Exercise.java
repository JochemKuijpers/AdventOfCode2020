package nl.jochemkuijpers.adventofcode2020.common;

import java.util.List;
import java.util.function.Consumer;

public abstract class Exercise implements Consumer<List<String>> {

    private final String name;

    public Exercise(int day, int part) {
        this.name = String.format("Day %2d - Part %d", day, part);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
