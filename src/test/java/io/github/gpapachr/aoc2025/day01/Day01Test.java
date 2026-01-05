package io.github.gpapachr.aoc2025.day01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.gpapachr.aoc2025.DayTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Day01Test extends DayTest {
    Day01 day01;

    @BeforeEach
    void setUp() {
        day01 = new Day01();
        super.setUp(day01);
    }

    @Test
    @Override
    protected void testSolvePart1WithExampleData() {
        Integer actual = day01.solvePart1(exampleInput);
        assertEquals(3, actual);
    }

    @Test
    @Override
    protected void testSolvePart1WithMainData() {
        Integer actual = day01.solvePart1(mainInput);
        assertEquals(1071, actual);
    }

    @Test
    @Override
    protected void testSolvePart2WithExampleData() {
        Integer actual = day01.solvePart2(exampleInput);
        assertEquals(6, actual);
    }

    @Test
    @Override
    protected void testSolvePart2WithMainData() {
        Integer actual = day01.solvePart2(mainInput);
        assertEquals(6700, actual);
    }
}