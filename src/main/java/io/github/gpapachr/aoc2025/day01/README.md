# Day 1: Secret Entrance

This project solves the [Advent of Code 2025 Day 1](https://adventofcode.com/2025/day/1) problems, involving movement within a circular range \[0, 99\], where the goal is to count how many times a position crosses zero. The main logic is implemented in the `Day01` class, which follows the `Day` interface and provides solutions for two parts of the problem.

---

## Overview

- **Circular Range:** Positions wrap around from 0 to 99 and vice versa.
- **Zero Crossings:** The solution tracks how many times the position passes through zero.
- **Main Class:** `Day01` contains all core logic and helper methods.

---

## Key Components

### `Day01` Class

- **Field:** `timesInZero` — tracks the number of zero crossings.
- **Methods:**  
  - `solvePart1`  
  - `solvePart2`  
  Both delegate to a shared `solve` method.

### `solve` Method

- **Start Position:** 50
- **Input:** List of movement commands
- **Logic:**  
  - If `countZeroCrossings` is `true`, uses `moveWithZeroCrossings`.
  - Otherwise, uses `move`, counting only how many times the pointer stops exactly on 0.

### `move` Method

- Handles simple movement.
- Wraps position within \[0, 99\].
- Increments `timesInZero` if position becomes exactly 0.

### `moveWithZeroCrossings` Method

- Handles multiple zero crossings in a single move.
- Adds full circles (`steps / 100`) to `timesInZero`.
- Uses `checkForFinalCrossing` for the last movement.

### Zero Crossing Check

- `checkForFinalCrossing` uses:
  - `crossedFromL`
  - `crossedFromR`
- Determines if the final movement crosses zero.

### Wrapping the Position

- `wrapPosition` uses modular arithmetic to keep position in \[0, 99\].
- Handles both positive and negative positions.