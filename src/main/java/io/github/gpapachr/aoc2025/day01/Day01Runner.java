package io.github.gpapachr.aoc2025.day01;

import io.github.gpapachr.aoc2025.Day;
import io.github.gpapachr.aoc2025.DayRunner;
import java.util.List;

public class Day01Runner extends DayRunner {
    public static void main(String[] args) {
        Day day = new Day01();

        List<String> input = inputReader.readMainInputLines(day.dayNumber());

        int part1 = day.solvePart1(input).intValue();
        int part2 = day.solvePart2(input).intValue();

        System.out.println("Day " + day.dayNumber() + " - Part 1: " + part1);
        System.out.println("Day " + day.dayNumber() + " - Part 2: " + part2);
    }
}
