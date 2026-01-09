package io.github.gpapachr.aoc2025.day02;

import io.github.gpapachr.aoc2025.Day;
import io.github.gpapachr.aoc2025.DayRunner;

public class Day02Runner extends DayRunner {
    public static void main(String[] args) {
        Day day = new Day02();

        var input = inputReader.readMainInputLines(day.dayNumber());

        var part1 = day.solvePart1(input);
        var part2 = day.solvePart2(input);

        System.out.println("Day " + day.dayNumber() + " - Part 1: " + part1);
        System.out.println("Day " + day.dayNumber() + " - Part 2: " + part2);
    }
}
