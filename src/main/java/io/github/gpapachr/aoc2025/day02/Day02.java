package io.github.gpapachr.aoc2025.day02;

import io.github.gpapachr.aoc2025.Day;
import java.util.List;
import java.util.function.LongPredicate;

public class Day02 implements Day {
    @Override
    public int dayNumber() {
        return 2;
    }

    @Override
    public Long solvePart1(List<String> input) {
        return sumInvalidIds(input, Day02::isValidId);
    }

    @Override
    public Long solvePart2(List<String> input) {
        return sumInvalidIds(input, Day02::isValidIdEnhanced);
    }

    private static long sumInvalidIds(List<String> input, LongPredicate isValid) {
        String line = input.stream().findFirst().orElse("").trim();
        if (line.isEmpty()) {
            return 0L;
        }

        long sum = 0;

        for (String ranges : line.split(",")) {
            String[] bounds = ranges.trim().split("-");
            long start = Long.parseLong(bounds[0].trim());
            long end = Long.parseLong(bounds[1].trim());

            for (long id = start; id <= end; id++) {
                if (!isValid.test(id)) {
                    sum += id;
                }
            }
        }
        return sum;
    }

    private static boolean isValidId(long id) { // Part 1: exactly twice
        String stringId = Long.toString(id);
        int length = stringId.length();

        if (length % 2 == 1) {
            return true;
        }

        int half = length / 2;
        return !stringId.regionMatches(0, stringId, half, half);
    }

    /**
     * Checks if the given ID does not exhibit a repeating pattern of two or more repetitions. This method uses the Knuth-Morris-Pratt (KMP) algorithm to detect periodicity in the string
     * representation of the ID.
     *
     * @param id The ID to validate, represented as a long.
     * @return {@code true} if the ID is valid (does not have a repeating pattern of 2+ repetitions), {@code false} otherwise.
     */
    private static boolean isValidIdEnhanced(long id) { // Part 2: 2+ repeats
        // Convert the ID to its string representation
        String stringId = Long.toString(id);
        int length = stringId.length();

        // Initialize the LPS (Longest Prefix Suffix) array
        int[] lpsArray = new int[length];
        for (int index = 1; index < length; index++) {
            // Get the length of the current prefix
            int prefixLength = lpsArray[index - 1];

            // Backtrack until a match is found or the prefix length becomes zero
            while (prefixLength > 0 && stringId.charAt(index) != stringId.charAt(prefixLength)) {
                prefixLength = lpsArray[prefixLength - 1];
            }

            // If characters match, increment the prefix length
            if (stringId.charAt(index) == stringId.charAt(prefixLength)) {
                prefixLength++;
            }

            // Store the prefix length in the LPS array
            lpsArray[index] = prefixLength;
        }

        // Retrieve the LPS value of the last character
        int lps = lpsArray[length - 1];

        // Calculate the potential period of the string
        int period = length - lps;

        // Check if the string has a repeating pattern of 2+ repetitions
        boolean hasRepeatedPattern = lps > 0 && (length % period == 0);

        // Return true if the ID is valid (does not have a repeating pattern)
        return !hasRepeatedPattern;
    }
}
