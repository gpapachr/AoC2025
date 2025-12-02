package io.github.gpapachr.aoc2025.commons;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InputReaderTest {

    @Test
    void readExampleInputLines() {
        InputReader inputReader = InputReader.getInstance();
        var lines = inputReader.readExampleInputLines(1);
        lines.forEach(System.out::println);
        assertEquals(10, lines.size());
        assertNotNull(lines);
        assertFalse(lines.isEmpty());
    }

    @Test
    void readMainInputLines() {
        InputReader inputReader = InputReader.getInstance();
        var lines = inputReader.readMainInputLines(1);
        assertEquals(4445, lines.size());
        assertNotNull(lines);
        assertFalse(lines.isEmpty());
    }
}