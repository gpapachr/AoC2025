package io.github.gpapachr.aoc2025.commons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public class InputReader {
    private static final InputReader INSTANCE = new InputReader();
    private static final String INPUTS_BASE_PATH = "inputs/";

    private InputReader() {}

    public static InputReader getInstance() {
        return INSTANCE;
    }

    public List<String> readMainInputLines(int day) {
        return readLines(getResourcePath(day, ""));
    }

    public List<String> readExampleInputLines(int day) {
        return readLines(getResourcePath(day, "_example"));
    }

    private String getResourcePath(int day, String suffix) {
        return INPUTS_BASE_PATH + "day%02d".formatted(day) + suffix + ".txt";
    }

    /**
     * Reads all lines from a resource file located in the classpath and returns them as a list of strings.
     *
     * @param resourcePath The path to the resource file relative to the classpath.
     * @return A list of strings, where each string represents a line from the resource file.
     * @throws IllegalArgumentException If the resource file is not found at the specified path.
     * @throws RuntimeException         If an error occurs while reading the resource file.
     */
    private List<String> readLines(String resourcePath) {
        try (InputStream inputStream = getClassLoader().getResourceAsStream(resourcePath)) {
            if (inputStream == null) {
                throw new IllegalArgumentException("Resource not found: " + resourcePath);
            }
            return getStringList(inputStream);
        } catch (Exception e) {
            throw new RuntimeException("Failed to read resource: " + resourcePath, e);
        }
    }

    private static List<String> getStringList(InputStream inputStream) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            // Collect all lines into a list and return
            return reader.lines().collect(Collectors.toList());
        }
    }

    private ClassLoader getClassLoader() {
        return Thread.currentThread().getContextClassLoader() != null
                ? Thread.currentThread().getContextClassLoader()
                : InputReader.class.getClassLoader();
    }
}