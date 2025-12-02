package io.github.gpapachr.aoc2025.day01;

import io.github.gpapachr.aoc2025.commons.InputReader;
import java.util.List;
import lombok.val;

public class Day01Runner {
    private static final InputReader inputReader = InputReader.getInstance();

    public static void main(String[] args) {
        val day = new Day01();

        List<String> input = inputReader.readMainInputLines(day.dayNumber());

        Integer part1 = day.solvePart1(input);
        Integer part2 = day.solvePart2(input);

        System.out.println("Day " + day.dayNumber() + " - Part 1: " + part1);
        System.out.println("Day " + day.dayNumber() + " - Part 2: " + part2);
    }
}
