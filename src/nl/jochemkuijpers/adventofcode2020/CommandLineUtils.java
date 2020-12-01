package nl.jochemkuijpers.adventofcode2020;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CommandLineUtils {

    /** The (assumed) width of the output window, in characters. */
    private static final int OUTPUT_WIDTH = 150;

    /**
     * Shows a number of items and requests the user to enter the 1-based index of the item they want to select.
     * <p>
     * Objects are mapped to strings automatically using {@link Object#toString()}. An optional second
     * parameters can be passed to provide a custom string mapper.
     *
     * @param <T>       the type of items to pick from.
     * @param items     the items to pick from, non-null
     * @return          the selected item, or null if the user aborts
     */
    public static <T> T selectFromItems(List<T> items) {
        return selectFromItems(items, Objects::toString);
    }

    /**
     * Shows a number of items and requests the user to enter the 1-based index of the item they want to select.
     *
     * @param <T>       the type of items to pick from.
     * @param items     the items to pick from, non-null
     * @param mapper    the string mapper, to map the values to strings
     * @return          the selected item, or null if the user aborts
     */
    public static <T> T selectFromItems(List<T> items, Function<T, String> mapper) {
        final int size = items.size();

        final List<String> strings = items.stream().map(mapper).collect(Collectors.toList());
        final int maxValueLength = strings.stream().reduce(0, (maxLength, string) -> Math.max(maxLength, string.length()), Math::max);

        final int maxNumber = Integer.toString(size).length();
        final int maxEntryWidth = maxValueLength + maxNumber + 4;

        final int numColumns = Math.min(size, OUTPUT_WIDTH / maxEntryWidth);
        final int columnWidth = OUTPUT_WIDTH / numColumns;

        final String columnFormat = "[%" + maxNumber + "d] %-" + (columnWidth - maxNumber - 4) + "s ";


        for (int i = 0; i < size; i++) {
            System.out.printf(columnFormat, (i + 1), strings.get(i));
            if ( (i > 0 && i % numColumns == 0) || i == size - 1) {
                System.out.println();
            }
        }
        System.out.println("---");

        final Scanner scanner = new Scanner(System.in);

        int choice = -1;
        while (choice < 0 || choice >= size) {

            System.out.printf("Your choice? [1-%d, q to quit]\n", size);
            System.out.print( "> ");

            try {
                String line = scanner.nextLine();
                if (line.toLowerCase().equals("q")) {
                    return null;
                }

                choice = Integer.parseInt(line) - 1;
            } catch (NumberFormatException ignored) {}
        }

        return items.get(choice);
    }
}
