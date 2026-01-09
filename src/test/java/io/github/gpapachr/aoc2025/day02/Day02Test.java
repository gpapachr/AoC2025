package io.github.gpapachr.aoc2025.day02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.gpapachr.aoc2025.DayTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Day02Test extends DayTest {
    private Day02 day02;

    @BeforeEach
    void setUp() {
        day02 = new Day02();
        super.setUp(new Day02());
    }

    @Test
    @Override
    protected void testSolvePart1WithExampleData() {
        Long actual = day02.solvePart1(exampleInput);
        assertEquals(1227775554, actual);
    }

    @Test
    @Override
    protected void testSolvePart1WithMainData() {
        Long actual = day02.solvePart1(mainInput);
        assertEquals(53420042388L, actual);
    }

    @Test
    @Override
    protected void testSolvePart2WithExampleData() {
        Long actual = day02.solvePart2(exampleInput);
        assertEquals(4174379265L, actual);
    }

    @Test
    @Override
    protected void testSolvePart2WithMainData() {
        Long actual = day02.solvePart2(mainInput);
        assertEquals(69553832684L, actual);
    }
}