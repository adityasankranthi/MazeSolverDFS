# MazeSolverDFS

## Overview
**MazeSolverDFS** is a project for implementing and solving mazes using depth-first search (DFS). The project includes creating and manipulating a maze represented by two-dimensional boolean arrays and visualizing paths through the maze. The implementation features depth-first search for pathfinding and graphical rendering for solution display.

## Features
- **Maze Representation**: Uses two-dimensional boolean arrays to represent passages in a maze.
- **Maze Reading/Writing**: Methods to read a maze from a textual representation and write it back.
- **Depth-First Search (DFS)**: Non-recursive implementation of DFS to find paths from the maze's entry to exit.
- **Path Visualization**: Graphical rendering of mazes and solutions using the provided MazeDisplay class.

## Maze ADT
- **`Maze` Class**: Manages the maze structure with methods to check passages, read and write maze representations.
  - `isOpenDirection(int row, int col, Direction dir)`: Checks if there is a passage in the specified direction.
  - `read(BufferedReader reader)`: Reads maze data from a textual file.
  - `write(PrintWriter writer)`: Writes maze data to a textual file.

## Depth-First Search
- **`MazeSolver` Class**: Implements depth-first search to find paths in the maze.
  - `findPath()`: Performs DFS to find a path from the maze's entrance to its exit.

## Graphical Rendering
- **`MazeDisplay` Class**: Provides methods to render the maze and display solutions. The display includes:
  - Path from entry to exit.
  - All reachable cells from the entry.

## File Structure
- **`src/TestMaze`**: JUnit tests for the `Maze` ADT.
- **`src/TestMazeSolver`**: JUnit tests for the `MazeSolver`.
- **`src/edu/uwm/cs351/Maze.java`**: Skeleton of the Maze implementation, including a main program for execution.
- **`lib/small.txt`**: Example maze file.
- **`lib/noway.txt`**: Example maze file with no solution.
- **`lib/manyway.txt`**: Example maze file with multiple solutions.
- **`lib/*.txt`**: Additional maze test files.

## Getting Started
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/MazeSolverDFS.git
   ```
2. Navigate to the project directory:
   ```bash
   cd MazeSolverDFS
   ```
3. Open the project in Eclipse or your preferred Java IDE.

## Running the Program
To run the program and solve a maze, use the following command-line arguments:
```bash
java -cp bin edu.uwm.cs351.Maze --read filename --solve
```
Replace `filename` with the path to your maze file.

## Testing
- **JUnit Tests**: Run the JUnit tests provided in `src/TestMaze` and `src/TestMazeSolver` to validate the Maze ADT and DFS implementation.
- **Random Testing**: The JAR file includes random testing for both the Maze ADT and the solver.

## Objectives
- Implement maze storage and rendering.
- Read and write mazes using ASCII text.
- Perform depth-first search for maze pathfinding.
- Visualize maze paths and solutions graphically.
