package io.github.gpapachr.aoc2025;

import java.util.List;

public interface Day {
    int dayNumber();

    Number solvePart1(List<String> input);

    Number solvePart2(List<String> input);
}
