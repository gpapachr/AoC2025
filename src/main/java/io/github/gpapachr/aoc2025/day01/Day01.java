package io.github.gpapachr.aoc2025.day01;

import io.github.gpapachr.aoc2025.Day;
import java.util.List;

/**
 * Day 1: Secret Entrance
 */
public class Day01 implements Day {
    private int timesInZero;

    @Override
    public int dayNumber() {
        return 1;
    }

    @Override
    public Integer solvePart1(List<String> input) {
        return solve(input, false);
    }

    @Override
    public Integer solvePart2(List<String> input) {
        return solve(input, true);
    }

    private int solve(List<String> input, boolean countZeroCrossings) {
        int position = 50;
        timesInZero = 0;

        for (String line : input) {
            position = countZeroCrossings ? moveWithZeroCrossings(position, line) : move(position, line);
        }
        return timesInZero;
    }

    private int move(int position, String line) {
        int steps = Integer.parseInt(line.substring(1));
        position = line.startsWith("L") ? wrapPosition(position - steps) : wrapPosition(position + steps);
        if (position == 0) {
            timesInZero++;
        }
        return position;
    }

    private int moveWithZeroCrossings(int position, String line) {
        int steps = Integer.parseInt(line.substring(1));
        int fullCircles = steps / 100;
        timesInZero += fullCircles;

        int remainingSteps = steps % 100;
        int newPosition = line.startsWith("L") ? position - remainingSteps : position + remainingSteps;

        checkForFinalCrossing(position, line, newPosition);

        return wrapPosition(newPosition);
    }

    private void checkForFinalCrossing(int position, String line, int newPosition) {
        if (crossedFromL(position, line, newPosition) || crossedFromR(position, line, newPosition)) {
            timesInZero++;
        }
    }

    private static boolean crossedFromL(int position, String line, int newPosition) {
        return line.startsWith("L") && newPosition <= 0 && position != 0;
    }

    private static boolean crossedFromR(int position, String line, int newPosition) {
        return line.startsWith("R") && newPosition >= 100 && position != 0;
    }

    private int wrapPosition(int position) {
        return ((position % 100) + 100) % 100;
    }
}