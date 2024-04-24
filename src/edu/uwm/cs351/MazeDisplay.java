package edu.uwm.cs351;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MazeDisplay extends JPanel {
	/**
	 * Keep Eclipse happy
	 */
	private static final long serialVersionUID = 1L;
	
	private final Maze maze;
	private SolutionDisplay solution;	
	private final int squareSize;
	
	/**
	 * Create a graphical panel that shows this maze.
	 * @param maze maze to show
	 * @param size how many pixels wide to make the walls/paths
	 */
	MazeDisplay(Maze maze, int size) {
		this.maze = maze;
		squareSize = size;
	}

	/**
	 * Set the displayed solution to the argument
	 * @param sd (may be null -- show no solution)
	 */
	public void setSolution(SolutionDisplay sd) {
		solution = sd;
	}

	@Override // decorate
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i=0; i < this.maze.rows(); ++i) {
			for (int j=0; j < this.maze.columns(); ++j) {
				g.fillRect(2*squareSize*j, 2*squareSize*i, squareSize, squareSize);
				if (!this.maze.isOpenUp(i,j))
					g.fillRect((2*j+1)*squareSize, 2*squareSize*i, squareSize, squareSize);
				if (!this.maze.isOpenLeft(i,j))
					g.fillRect(2*squareSize*j, (2*i+1)*squareSize, squareSize, squareSize);
			}
		}
		g.fillRect(squareSize, squareSize*this.maze.rows()*2, 2*this.maze.columns()*squareSize, squareSize);
		g.fillRect(squareSize*this.maze.columns()*2, squareSize, squareSize, 2*this.maze.rows()*squareSize);
		g.setColor(Color.YELLOW);
		if (solution != null) solution.draw(g, squareSize);
	}
	
}