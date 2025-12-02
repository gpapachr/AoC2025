package io.github.gpapachr.aoc2025.day01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.gpapachr.aoc2025.commons.InputReader;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Day01Test {

    Day01 day01;
    InputReader inputReader;
    List<String> exampleInput;
    List<String> mainInput;

    @BeforeEach
    void setUp() {
        day01 = new Day01();
        inputReader = InputReader.getInstance();
        exampleInput = inputReader.readExampleInputLines(day01.dayNumber());
        mainInput = inputReader.readMainInputLines(day01.dayNumber());
    }

    @Test
    void testSolvePart1WithExampleData() {
        Integer actual = day01.solvePart1(exampleInput);
        assertEquals(3, actual);
    }

    @Test
    void testSolvePart1WithMainData() {
        Integer actual = day01.solvePart1(mainInput);
        assertEquals(1071, actual);
    }

    @Test
    void testSolvePart2WithExampleData() {
        Integer actual = day01.solvePart2(exampleInput);
        assertEquals(6, actual);
    }

    @Test
    void testSolvePart2WithMainData() {
        Integer actual = day01.solvePart2(mainInput);
        assertEquals(6700, actual);
    }
}