package edu.uwm.cs351;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import edu.uwm.cs351.Maze.Cell;

/**
 * Try to solve a maze.
 */
public class MazeSolver {
	private final Maze maze;
	private Stack<Maze.Cell> pending = new Stack<Cell>();
	private Cell[][] visited;
	
	/**
	 * Create a maze solver for this maze.
	 * @param m maze to solve, must not be null
	 */
	public MazeSolver(Maze m) {
		maze = m;
		visited = new Cell[maze.rows()][maze.columns()];
	}

	/**
	 * Try to find a path, and return a solution display:
	 * either a path solution display, if a path was found,
	 * or a visited solution display if no path was found.
	 * @return solution display (must not be null)
	 */
	public SolutionDisplay findPath() {
		int rows = maze.rows();
		int columns = maze.columns();
		// TODO: Look for a path using depth-first search.
		// If one is found, return a PathSolutionDIsplay.
		
		// Otherwise, we return a display that shows what 
		// we visited;
		boolean[][] marked = new boolean[rows][columns];
		// TODO: initialize the "marked" array with visited information
		return new VisitedSolutionDisplay(maze,marked);
	}
	// Our solution uses a helper method to avoid repeating code.  This is optional.
}
