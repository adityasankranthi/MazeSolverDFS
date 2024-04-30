package edu.uwm.cs351;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import edu.uwm.cs351.Maze.Cell;

public class MazeSolver {
    private final Maze maze;
    private Stack<Maze.Cell> stack = new Stack<Cell>();
    private Cell[][] parent;

    public MazeSolver(Maze m) {
        maze = m;
        parent = new Cell[maze.rows()][maze.columns()];
    }

    public SolutionDisplay findPath() {
        int rows = maze.rows();
        int columns = maze.columns();

        boolean[][] marked = new boolean[rows][columns];
        stack.push(maze.makeCell(rows - 1, 0));
        marked[maze.makeCell(rows - 1, 0).row][maze.makeCell(rows - 1, 0).column] = true;

        while (!stack.isEmpty()) {
            Cell current = stack.pop();

            if (current.equals(maze.makeCell(0, columns - 1))) {
                return new PathSolutionDisplay(maze, retrieve(maze.makeCell(0, columns - 1)));
            }

            List<Cell> neighbors = new ArrayList<>();

            if (current.column < columns - 1 ) {
            addRightNeighbor(current, marked, neighbors);
            }
            if (current.row < rows - 1 ) {
            addDownNeighbor(current, marked, neighbors);
            }
            if (current.column > 0 ) {
            addLeftNeighbor(current, marked, neighbors);
            }
            if (current.row > 0) {
            addUpNeighbor(current, marked, neighbors);
            }
            
            Collections.reverse(neighbors);
            for (Cell neighbor : neighbors) {
                stack.push(neighbor);
                parent[neighbor.row][neighbor.column] = current;
            }
        }
        return new VisitedSolutionDisplay(maze, marked);
    }

    private void addRightNeighbor(Cell current, boolean[][] marked, List<Cell> neighbors) {
    	if (maze.isOpenRight(current.row, current.column) && !marked[current.row][current.column + 1]) {
            neighbors.add(maze.makeCell(current.row, current.column + 1));
            marked[current.row][current.column + 1] = true;
        }
    }

    private void addDownNeighbor(Cell current, boolean[][] marked, List<Cell> neighbors) {
    	if (maze.isOpenDown(current.row, current.column) && !marked[current.row + 1][current.column]) {
            neighbors.add(maze.makeCell(current.row + 1, current.column));
            marked[current.row + 1][current.column] = true;
    	}
    }

    private void addLeftNeighbor(Cell current, boolean[][] marked, List<Cell> neighbors) {
    	if (maze.isOpenLeft(current.row, current.column) && !marked[current.row][current.column - 1]) {
            neighbors.add(maze.makeCell(current.row, current.column - 1));
            marked[current.row][current.column - 1] = true;
        }
    }

    private void addUpNeighbor(Cell current, boolean[][] marked, List<Cell> neighbors) {
    	if (maze.isOpenUp(current.row, current.column) && !marked[current.row - 1][current.column]) {
            neighbors.add(maze.makeCell(current.row - 1, current.column));
            marked[current.row - 1][current.column] = true;
        }
    }

    private List<Cell> retrieve(Cell end) {
        List<Cell> path = new ArrayList<>();
        Cell at = end;
        while (at != null) {
            path.add(at);
            if (at.equals(maze.makeCell(maze.rows() - 1, 0))) {
                break;
            }
            at = parent[at.row][at.column];
        }
        Collections.reverse(path);
        return path;
    }
}
