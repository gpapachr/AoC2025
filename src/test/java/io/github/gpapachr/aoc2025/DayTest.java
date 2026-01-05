package io.github.gpapachr.aoc2025;

import io.github.gpapachr.aoc2025.commons.InputReader;
import java.util.List;

public abstract class DayTest {
    protected InputReader inputReader;
    protected List<String> exampleInput;
    protected List<String> mainInput;

    protected void setUp(Day day) {
        inputReader = InputReader.getInstance();
        exampleInput = inputReader.readExampleInputLines(day.dayNumber());
        mainInput = inputReader.readMainInputLines(day.dayNumber());
    }

    protected abstract void testSolvePart1WithExampleData();

    protected abstract void testSolvePart1WithMainData();

    protected abstract void testSolvePart2WithExampleData();

    protected abstract void testSolvePart2WithMainData();
}
