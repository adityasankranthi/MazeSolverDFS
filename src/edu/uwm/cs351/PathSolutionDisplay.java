package edu.uwm.cs351;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import edu.uwm.cs351.Maze.Cell;

/**
 * We found a path in the maze.
 */
public class PathSolutionDisplay extends AbstractSolutionDisplay {
	private List<Maze.Cell> path;
	/**
	 * A solution display with a path to mark
	 * @param m maze being solved, must not be null
	 * @param p path to show, must not be null
	 */
	public PathSolutionDisplay(Maze m, List<Maze.Cell> p) {
		super(m);
		path = p;
	}

	/**
	 * A short version of the other constructor, used by random testing
	 * @param m maze to create solution for, must not be null
	 * @param is indices of cells in path
	 */
	public PathSolutionDisplay(Maze m, int...is ) {
		super(m);
		path = new ArrayList<>();
		for (int i=0; i < is.length; i += 2) {
			path.add(m.new Cell(is[i],is[i+1]));
		}
	}
	
	@Override // required
	public void draw(Graphics g, int size) {
		int i = path.get(0).row;
		int j = path.get(0).column;
		g.fillRect((2*maze.columns()-1)*size,0,2*size,size);
		g.fillRect(0,(2*maze.rows()-1)*size,size,2*size);
		for (Cell c : path) {
			g.fillRect((j+c.column+1)*size,(i+c.row+1)*size,size,size);
			i = c.row;
			j = c.column;
			g.fillRect((j+c.column+1)*size,(i+c.row+1)*size,size,size);	
		}
	}

	/** Return the path for this solution. */
	public List<Cell> getPath() {
		return new ArrayList<>(path); // don't give clients MY copy.
	}
	
	@Override // implementation
	public boolean equals(Object x) {
		if (!(x instanceof PathSolutionDisplay)) return false;
		PathSolutionDisplay other = (PathSolutionDisplay)x;
		return path.equals(other.path);
	}
	
	@Override // implementation
	public int hashCode() {
		return path.hashCode();
	}

	@Override // implementation
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Maze.Cell c : path) {
			if (sb.length() > 0) sb.append("->");
			sb.append(c);
		}
		return sb.toString();
	}
}
