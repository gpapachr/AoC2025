package io.github.gpapachr.aoc2025;

import io.github.gpapachr.aoc2025.commons.InputReader;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public final class DayRunner {
    private static final InputReader inputReader = InputReader.getInstance();

    public static void run(Day day) {
        var input = inputReader.readMainInputLines(day.dayNumber());

        var part1 = day.solvePart1(input);
        var part2 = day.solvePart2(input);

        System.out.println("Day " + day.dayNumber() + " - Part 1: " + part1);
        System.out.println("Day " + day.dayNumber() + " - Part 2: " + part2);
    }
}