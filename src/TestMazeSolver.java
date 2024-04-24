import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import edu.uwm.cs.junit.LockedTestCase;
import edu.uwm.cs351.Maze;
import edu.uwm.cs351.MazeSolver;
import edu.uwm.cs351.PathSolutionDisplay;
import edu.uwm.cs351.SolutionDisplay;
import edu.uwm.cs351.VisitedSolutionDisplay;


public class TestMazeSolver extends LockedTestCase {
	
	protected static void assertContents(Collection<?> col, Object... as) {
		assertEquals(Arrays.toString(as) + ".size != " + col + ".size()",as.length,col.size());
		Iterator<?> it = col.iterator();
		for (Object a : as) {
			assertEquals(a,it.next());
		}
	}

	private Maze maze;
	private MazeSolver solver;
	private SolutionDisplay solution;
	
	protected Maze.Cell c(int i, int j) { return maze.makeCell(i, j); }
	
	protected void ask(String question, String answer) {}
	
	public void test() {
		// Answer the following questions about the design of MazeSolver
		ask("What is the name of the method that looks for a path?",
				Ts(86258809));
		// In the next two questions give the name of the class
		ask("What sort of solution display is returned if a solution is found?",
				Ts(390735482));
		ask("What if no path can be found?",
				Ts(859214686));
	}
	
	public void testA0() {
		maze = new Maze(1,1);
		solver = new MazeSolver(maze);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(),c(0,0));
	}

	public void testA1() {
		maze = new Maze(1,2);
		solver = new MazeSolver(maze);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 1));
		assertTrue(vsd.isVisited(0, 0));
	}

	public void testA2() {
		maze = new Maze(2,1);
		solver = new MazeSolver(maze);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertTrue(vsd.isVisited(1, 0));
	}
	
	public void testA3() {
		maze = new Maze(1,2);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(),c(0,0),c(0,1));
	}
	
	public void testA4() {
		maze = new Maze(2,1);
		solver = new MazeSolver(maze);
		maze.setOpenDown(0, 0, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(),c(1,0),c(0,0));
	}
	
	public void testB0() {
		maze = new Maze(1,3);
		solver = new MazeSolver(maze);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertTrue(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
	}
	
	public void testB1() {
		maze = new Maze(1,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 1, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertTrue(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
	}
	
	public void testB2() {
		maze = new Maze(1,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertTrue(vsd.isVisited(0, 0));
		assertTrue(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
	}
	
	public void testB3() {
		maze = new Maze(1,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(0, 1, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(), c(0,0), c(0,1), c(0,2));
	}
	
	public void testB4() {
		maze = new Maze(3,1);
		solver = new MazeSolver(maze);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(1, 0));
		assertTrue(vsd.isVisited(2, 0));
	}
	
	public void testB5() {
		maze = new Maze(3,1);
		solver = new MazeSolver(maze);
		maze.setOpenDown(0, 0, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(1, 0));
		assertTrue(vsd.isVisited(2, 0));
	}
	
	public void testB6() {
		maze = new Maze(3,1);
		solver = new MazeSolver(maze);
		maze.setOpenDown(1, 0, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertTrue(vsd.isVisited(1, 0));
		assertTrue(vsd.isVisited(2, 0));
	}
	
	public void testB7() {
		maze = new Maze(3,1);
		solver = new MazeSolver(maze);
		maze.setOpenDown(0, 0, true);
		maze.setOpenDown(1, 0, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(), c(2,0), c(1,0), c(0,0));
	}
	
	public void testC0() {
		maze = new Maze(2,2);
		solver = new MazeSolver(maze);
		maze.setOpenDown(0, 0, true);
		maze.setOpenRight(1, 0, true);
		solver = new MazeSolver(maze);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertTrue(vsd.isVisited(0, 0));
		assertTrue(vsd.isVisited(1, 0));
		assertTrue(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(0, 1));
	}
	
	public void testC1() {
		maze = new Maze(2,2);
		solver = new MazeSolver(maze);
		maze.setOpenDown(0, 0, true);
		maze.setOpenRight(0, 0, true);
		solver = new MazeSolver(maze);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(),c(1,0),c(0,0),c(0,1));
	}
	
	public void testC2() {
		maze = new Maze(2,2);
		solver = new MazeSolver(maze);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
	}
	
	public void testC3() {
		maze = new Maze(2,2);
		solver = new MazeSolver(maze);
		maze.setOpenDown(0, 1, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
	}
	
	public void testC4() {
		maze = new Maze(2,2);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
	}
	
	public void testC5() {
		maze = new Maze(2,2);
		solver = new MazeSolver(maze);
		maze.setOpenRight(1, 0, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertTrue(vsd.isVisited(1, 0));
		assertTrue(vsd.isVisited(1, 1));
	}
	
	public void testC6() {
		maze = new Maze(2,2);
		solver = new MazeSolver(maze);
		maze.setOpenDown(0, 0, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertTrue(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
	}
	
	public void testC7() {
		maze = new Maze(2,2);
		solver = new MazeSolver(maze);
		maze.setOpenDown(0, 0, true);
		maze.setOpenDown(0, 1, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertTrue(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
	}
	
	public void testC8() {
		maze = new Maze(2,2);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(1, 0, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertTrue(vsd.isVisited(1, 0));
		assertTrue(vsd.isVisited(1, 1));
	}
	
	public void testC9() {
		maze = new Maze(2,2);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenDown(0, 1, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
	}
	
	public void testD0() {
		maze = new Maze(2,2);
		solver = new MazeSolver(maze);
		maze.setOpenRight(1, 0, true);
		maze.setOpenDown(0, 1, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(), c(1,0), c(1,1), c(0,1));
	}
	
	public void testD1() {
		maze = new Maze(2,2);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(1, 0, true);
		maze.setOpenDown(0, 0, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(), c(1,0), c(0,0), c(0,1));
	}
	
	public void testD2() {
		maze = new Maze(2,2);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(1, 0, true);
		maze.setOpenDown(0, 1, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(), c(1,0), c(1,1), c(0,1));
	}
	
	public void testD3() {
		maze = new Maze(2,2);
		solver = new MazeSolver(maze);
		maze.setOpenRight(1, 0, true);
		maze.setOpenDown(0, 0, true);
		maze.setOpenDown(0, 1, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(), c(1,0), c(1,1), c(0,1));
	}
	
	public void testD4() {
		maze = new Maze(2,2);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenDown(0, 0, true);
		maze.setOpenDown(0, 1, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(), c(1,0), c(0,0), c(0,1));
	}
	
	public void testD5() {
		maze = new Maze(2,2);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(1, 0, true);
		maze.setOpenDown(0, 0, true);
		maze.setOpenDown(0, 1, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(), c(1,0), c(1,1), c(0,1));
	}
	
	public void testE0() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testE1() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testE2() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 1, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testE3() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(1, 0, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertTrue(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testE4() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(1, 1, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testE5() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenDown(0, 0, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertTrue(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testE6() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenDown(0, 1, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testE7() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testF0() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(0, 1, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testF1() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(1, 0, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertTrue(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testF2() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(1, 1, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testF3() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenDown(0, 0, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertTrue(vsd.isVisited(0, 0));
		assertTrue(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testF4() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenDown(0, 1, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testF5() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testF6() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(1, 0, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertTrue(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testF7() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(1, 1, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testF8() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 1, true);
		maze.setOpenDown(0, 0, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertTrue(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testF9() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 1, true);
		maze.setOpenDown(0, 1, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testG0() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 1, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testG1() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(1, 0, true);
		maze.setOpenRight(1, 1, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertTrue(vsd.isVisited(1, 1));
		assertTrue(vsd.isVisited(1, 2));
	}
	
	public void testG2() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(1, 0, true);
		maze.setOpenDown(0, 0, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertTrue(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertTrue(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testG3() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(1, 0, true);
		maze.setOpenDown(0, 1, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertTrue(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertTrue(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testG4() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(1, 0, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertTrue(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testG5() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(1, 1, true);
		maze.setOpenDown(0, 0, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertTrue(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testG6() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(1, 1, true);
		maze.setOpenDown(0, 1, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testG7() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(1, 1, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testG8() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenDown(0, 0, true);
		maze.setOpenDown(0, 1, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertTrue(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testG9() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenDown(0, 0, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertTrue(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testH0() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenDown(0, 1, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testI0() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(1, 0, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertTrue(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testI1() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(1, 1, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testI2() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(0, 1, true);
		maze.setOpenDown(0, 0, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(), c(1,0), c(0,0), c(0,1), c(0,2));
	}
	
	public void testI3() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(0, 1, true);
		maze.setOpenDown(0, 1, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testI4() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(0, 1, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testI5() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(1, 0, true);
		maze.setOpenRight(1, 1, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertTrue(vsd.isVisited(1, 1));
		assertTrue(vsd.isVisited(1, 2));
	}
	
	public void testI6() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(1, 0, true);
		maze.setOpenDown(0, 0, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertTrue(vsd.isVisited(0, 0));
		assertTrue(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertTrue(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testI7() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(1, 0, true);
		maze.setOpenDown(0, 1, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertTrue(vsd.isVisited(0, 0));
		assertTrue(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertTrue(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testI8() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(1, 0, true);
		maze.setOpenDown(0, 1, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertTrue(vsd.isVisited(0, 0));
		assertTrue(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertTrue(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testI9() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(1, 1, true);
		maze.setOpenDown(0, 0, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertTrue(vsd.isVisited(0, 0));
		assertTrue(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testJ0() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(1, 1, true);
		maze.setOpenDown(0, 1, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testJ1() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(1, 1, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testJ2() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(1, 1, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testJ3() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenDown(0, 0, true);
		maze.setOpenDown(0, 1, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertTrue(vsd.isVisited(0, 0));
		assertTrue(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertTrue(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testJ4() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenDown(0, 0, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertTrue(vsd.isVisited(0, 0));
		assertTrue(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testJ5() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenDown(0, 1, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testJ6() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(1, 0, true);
		maze.setOpenRight(1, 1, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertTrue(vsd.isVisited(1, 1));
		assertTrue(vsd.isVisited(1, 2));
	}
	
	public void testJ7() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(1, 0, true);
		maze.setOpenDown(0, 0, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertTrue(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertTrue(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testJ8() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(1, 0, true);
		maze.setOpenDown(0, 1, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(), c(1,0), c(1,1), c(0,1), c(0,2));
	}
	
	public void testJ9() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(1, 0, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertTrue(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testK0() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(1, 1, true);
		maze.setOpenDown(0, 0, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertTrue(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testK1() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(1, 1, true);
		maze.setOpenDown(0, 1, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testK2() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(1, 1, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testK3() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 1, true);
		maze.setOpenDown(0, 0, true);
		maze.setOpenDown(0, 1, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertTrue(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testK4() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 1, true);
		maze.setOpenDown(0, 0, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertTrue(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testK5() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 1, true);
		maze.setOpenDown(0, 1, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testK6() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(1, 0, true);
		maze.setOpenRight(1, 1, true);
		maze.setOpenDown(0, 0, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertTrue(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertTrue(vsd.isVisited(1, 1));
		assertTrue(vsd.isVisited(1, 2));
	}
	
	public void testK7() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(1, 0, true);
		maze.setOpenRight(1, 1, true);
		maze.setOpenDown(0, 1, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertTrue(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertTrue(vsd.isVisited(1, 1));
		assertTrue(vsd.isVisited(1, 2));
	}
	
	public void testK8() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(1, 0, true);
		maze.setOpenRight(1, 1, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(), c(1,0), c(1,1), c(1,2), c(0,2));
	}
	
	public void testK9() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(1, 0, true);
		maze.setOpenDown(0, 0, true);
		maze.setOpenDown(0, 1, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertTrue(vsd.isVisited(0, 0));
		assertTrue(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertTrue(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testL0() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(1, 0, true);
		maze.setOpenDown(0, 0, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertTrue(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertTrue(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testL1() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(1, 0, true);
		maze.setOpenDown(0, 1, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertTrue(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertTrue(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testL2() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(1, 1, true);
		maze.setOpenDown(0, 0, true);
		maze.setOpenDown(0, 1, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertTrue(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testL3() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(1, 1, true);
		maze.setOpenDown(0, 0, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertTrue(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testL4() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(1, 1, true);
		maze.setOpenDown(0, 1, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testL5() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenDown(0, 0, true);
		maze.setOpenDown(0, 1, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertTrue(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testM0() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(1, 0, true);
		maze.setOpenRight(1, 1, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertTrue(vsd.isVisited(1, 1));
		assertTrue(vsd.isVisited(1, 2));
	}
	
	public void testM1() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(1, 0, true);
		maze.setOpenDown(0, 0, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(), c(1,0), c(0,0), c(0,1), c(0,2));
	}
	
	public void testM2() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(1, 0, true);
		maze.setOpenDown(0, 1, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(), c(1,0), c(1,1), c(0,1), c(0,2));
	}
	
	public void testM3() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(1, 0, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertTrue(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testM4() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(1, 1, true);
		maze.setOpenDown(0, 0, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(), c(1,0), c(0,0), c(0,1), c(0,2));
	}
	
	public void testM5() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(1, 1, true);
		maze.setOpenDown(0, 1, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testM6() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(1, 1, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testM7() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(0, 1, true);
		maze.setOpenDown(0, 0, true);
		maze.setOpenDown(0, 1, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(), c(1,0), c(0,0), c(0,1), c(0,2));
	}
	
	public void testM8() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(0, 1, true);
		maze.setOpenDown(0, 0, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(), c(1,0), c(0,0), c(0,1), c(0,2));
	}
	
	public void testM9() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(0, 1, true);
		maze.setOpenDown(0, 1, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testN0() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(1, 1, true);
		maze.setOpenDown(0, 0, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(), c(1,0), c(0,0), c(0,1), c(0,2));
	}
	
	public void testN1() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(1, 1, true);
		maze.setOpenDown(0, 1, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testN2() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(1, 1, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testN3() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(0, 1, true);
		maze.setOpenDown(0, 0, true);
		maze.setOpenDown(0, 1, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(), c(1,0), c(0,0), c(0,1), c(0,2));
	}
	
	public void testN4() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(0, 1, true);
		maze.setOpenDown(0, 0, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(), c(1,0), c(0,0), c(0,1), c(0,2));
	}
	
	public void testN5() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(1, 1, true);
		maze.setOpenDown(0, 1, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testN6() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(1, 1, true);
		maze.setOpenDown(0, 0, true);
		maze.setOpenDown(0, 1, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertTrue(vsd.isVisited(0, 0));
		assertTrue(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertTrue(vsd.isVisited(1, 1));
		assertTrue(vsd.isVisited(1, 2));
	}
	
	public void testN7() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(1, 1, true);
		maze.setOpenDown(0, 0, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertTrue(vsd.isVisited(0, 0));
		assertTrue(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testN8() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(1, 1, true);
		maze.setOpenDown(0, 1, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testN9() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenDown(0, 0, true);
		maze.setOpenDown(0, 1, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertTrue(vsd.isVisited(0, 0));
		assertTrue(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertTrue(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testO0() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(1, 0, true);
		maze.setOpenRight(1, 1, true);
		maze.setOpenDown(0, 0, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertTrue(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertTrue(vsd.isVisited(1, 1));
		assertTrue(vsd.isVisited(1, 2));
	}
	
	public void testO1() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(1, 0, true);
		maze.setOpenRight(1, 1, true);
		maze.setOpenDown(0, 1, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(), c(1,0), c(1,1), c(0,1), c(0,2));
	}
	
	public void testO2() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(1, 0, true);
		maze.setOpenRight(1, 1, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(), c(1,0), c(1,1), c(1,2), c(0,2));
	}
	
	public void testO3() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(1, 0, true);
		maze.setOpenDown(0, 0, true);
		maze.setOpenDown(0, 1, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(), c(1,0), c(1,1), c(0,1), c(0,2));
	}
	
	public void testO4() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(1, 0, true);
		maze.setOpenDown(0, 0, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertTrue(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertTrue(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testO5() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(1, 0, true);
		maze.setOpenDown(0, 1, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(), c(1,0), c(1,1), c(0,1), c(0,2));
	}
	
	public void testO6() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(1, 1, true);
		maze.setOpenDown(0, 0, true);
		maze.setOpenDown(0, 1, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertTrue(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testO7() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(1, 1, true);
		maze.setOpenDown(0, 0, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertTrue(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testO8() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(1, 1, true);
		maze.setOpenDown(0, 1, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testO9() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 1, true);
		maze.setOpenDown(0, 0, true);
		maze.setOpenDown(0, 1, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertTrue(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testP0() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(1, 0, true);
		maze.setOpenRight(1, 1, true);
		maze.setOpenDown(0, 0, true);
		maze.setOpenDown(0, 1, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertTrue(vsd.isVisited(0, 0));
		assertTrue(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertTrue(vsd.isVisited(1, 1));
		assertTrue(vsd.isVisited(1, 2));
	}
	
	public void testP1() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(1, 0, true);
		maze.setOpenRight(1, 1, true);
		maze.setOpenDown(0, 0, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(), c(1,0), c(1,1), c(1,2), c(0,2));
	}
	
	public void testP2() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(1, 0, true);
		maze.setOpenRight(1, 1, true);
		maze.setOpenDown(0, 1, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(), c(1,0), c(1,1), c(1,2), c(0,2));
	}
	
	public void testP3() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(1, 0, true);
		maze.setOpenDown(0, 0, true);
		maze.setOpenDown(0, 1, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertTrue(vsd.isVisited(0, 0));
		assertTrue(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertTrue(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testP4() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(1, 1, true);
		maze.setOpenDown(0, 0, true);
		maze.setOpenDown(0, 1, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertTrue(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testQ0() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(1, 0, true);
		maze.setOpenRight(1, 1, true);
		maze.setOpenDown(0, 0, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(), c(1,0), c(0,0), c(0,1), c(0,2));
	}
	
	public void testQ1() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(1, 0, true);
		maze.setOpenRight(1, 1, true);
		maze.setOpenDown(0, 1, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(), c(1,0), c(1,1), c(0,1), c(0,2));
	}
	
	public void testQ2() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(1, 0, true);
		maze.setOpenRight(1, 1, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(), c(1,0), c(1,1), c(1,2), c(0,2));
	}
	
	public void testQ3() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(1, 0, true);
		maze.setOpenDown(0, 0, true);
		maze.setOpenDown(0, 1, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(), c(1,0), c(1,1), c(0,1), c(0,2));
	}
	
	public void testQ4() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(1, 0, true);
		maze.setOpenDown(0, 0, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(), c(1,0), c(0,0), c(0,1), c(0,2));
	}
	
	public void testQ5() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(1, 0, true);
		maze.setOpenDown(0, 1, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(), c(1,0), c(1,1), c(0,1), c(0,2));
	}
	
	public void testQ6() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(1, 1, true);
		maze.setOpenDown(0, 0, true);
		maze.setOpenDown(0, 1, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(), c(1,0), c(0,0), c(0,1), c(0,2));
	}
	
	public void testQ7() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(1, 1, true);
		maze.setOpenDown(0, 0, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(), c(1,0), c(0,0), c(0,1), c(0,2));
	}
	
	public void testQ8() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(1, 1, true);
		maze.setOpenDown(0, 1, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertFalse(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testQ9() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(1, 0, true);
		maze.setOpenRight(1, 1, true);
		maze.setOpenDown(0, 0, true);
		maze.setOpenDown(0, 1, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertTrue(vsd.isVisited(0, 0));
		assertTrue(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertTrue(vsd.isVisited(1, 1));
		assertTrue(vsd.isVisited(1, 2));
	}
	
	public void testR0() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(1, 0, true);
		maze.setOpenRight(1, 1, true);
		maze.setOpenDown(0, 0, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(), c(1,0), c(1,1), c(1,2), c(0,2));
	}
	
	public void testR1() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(1, 0, true);
		maze.setOpenRight(1, 1, true);
		maze.setOpenDown(0, 1, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(), c(1,0), c(1,1), c(1,2), c(0,2));
	}
	
	public void testR2() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(1, 0, true);
		maze.setOpenDown(0, 0, true);
		maze.setOpenDown(0, 1, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertTrue(vsd.isVisited(0, 0));
		assertTrue(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertTrue(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testR3() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(1, 1, true);
		maze.setOpenDown(0, 0, true);
		maze.setOpenDown(0, 1, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(), c(1,0), c(0,0), c(0,1), c(1,1), c(1,2), c(0,2));
	}
	
	public void testR4() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(1, 0, true);
		maze.setOpenRight(1, 1, true);
		maze.setOpenDown(0, 0, true);
		maze.setOpenDown(0, 1, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(), c(1,0), c(1,1), c(0,1), c(0,2));
	}
	
	public void testR5() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(1, 0, true);
		maze.setOpenRight(1, 1, true);
		maze.setOpenDown(0, 0, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(), c(1,0), c(1,1), c(1,2), c(0,2));
	}
	
	public void testR6() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(1, 0, true);
		maze.setOpenRight(1, 1, true);
		maze.setOpenDown(0, 1, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(), c(1,0), c(1,1), c(1,2), c(0,2));
	}
	
	public void testR7() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(1, 0, true);
		maze.setOpenDown(0, 0, true);
		maze.setOpenDown(0, 1, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(), c(1,0), c(1,1), c(0,1), c(0,2));
	}
	
	public void testR8() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(1, 1, true);
		maze.setOpenDown(0, 0, true);
		maze.setOpenDown(0, 1, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertTrue(vsd.isVisited(0, 0));
		assertFalse(vsd.isVisited(0, 1));
		assertFalse(vsd.isVisited(0, 2));
		assertTrue(vsd.isVisited(1, 0));
		assertFalse(vsd.isVisited(1, 1));
		assertFalse(vsd.isVisited(1, 2));
	}
	
	public void testR9() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(1, 0, true);
		maze.setOpenRight(1, 1, true);
		maze.setOpenDown(0, 0, true);
		maze.setOpenDown(0, 1, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(), c(1,0), c(1,1), c(1,2), c(0,2));
	}
	
	public void testS0() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(1, 0, true);
		maze.setOpenRight(1, 1, true);
		maze.setOpenDown(0, 0, true);
		maze.setOpenDown(0, 1, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(), c(1,0), c(1,1), c(0,1), c(0,2));
	}
	
	public void testS1() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(1, 0, true);
		maze.setOpenRight(1, 1, true);
		maze.setOpenDown(0, 0, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(), c(1,0), c(1,1), c(1,2), c(0,2));
	}
	
	public void testS2() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(1, 0, true);
		maze.setOpenRight(1, 1, true);
		maze.setOpenDown(0, 1, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(), c(1,0), c(1,1), c(1,2), c(0,2));
	}
	
	public void testS3() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(1, 0, true);
		maze.setOpenDown(0, 0, true);
		maze.setOpenDown(0, 1, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(), c(1,0), c(1,1), c(0,1), c(0,2));
	}
	
	public void testS4() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(1, 1, true);
		maze.setOpenDown(0, 0, true);
		maze.setOpenDown(0, 1, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(), c(1,0), c(0,0), c(0,1), c(0,2));
	}
	
	public void testS5() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(1, 0, true);
		maze.setOpenRight(1, 1, true);
		maze.setOpenDown(0, 0, true);
		maze.setOpenDown(0, 1, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(), c(1,0), c(1,1), c(1,2), c(0,2));
	}
	
	public void testS6() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(1, 0, true);
		maze.setOpenRight(1, 1, true);
		maze.setOpenDown(0, 0, true);
		maze.setOpenDown(0, 1, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(), c(1,0), c(1,1), c(1,2), c(0,2));
	}
	
	public void testS7() {
		maze = new Maze(2,3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(1, 0, true);
		maze.setOpenRight(1, 1, true);
		maze.setOpenDown(0, 0, true);
		maze.setOpenDown(0, 1, true);
		maze.setOpenDown(0, 2, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(), c(1,0), c(1,1), c(1,2), c(0,2));
	}
	
	
	public void testT0() {
		// see test62 in TestMaze
		maze = new Maze(3,5);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(0, 2, true);
		maze.setOpenRight(1, 0, true);
		maze.setOpenRight(1, 3, true);
		maze.setOpenRight(2, 1, true);
		maze.setOpenRight(2, 2, true);
		maze.setOpenRight(2, 3, true);
		maze.setOpenDown(0, 1, true);
		maze.setOpenDown(0, 3, true);
		maze.setOpenDown(0, 4, true);
		maze.setOpenDown(1, 0, true);
		maze.setOpenDown(1, 2, true);
		maze.setOpenDown(1, 4, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(),
				c(2,0),c(1,0),c(1,1),
				c(0,1),c(0,2),c(0,3),
				c(1,3),c(1,4),c(0,4));
	}
	
	public void testT1() { // has block
		maze = new Maze(3, 5);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(1, 0, true);
		maze.setOpenRight(1, 1, true);
		maze.setOpenRight(1, 2, true);
		maze.setOpenRight(2, 0, true);
		maze.setOpenRight(2, 1, true);
		maze.setOpenRight(2, 2, true);
		maze.setOpenDown(0, 0, true);
		maze.setOpenDown(0, 1, true);
		maze.setOpenDown(0, 2, true);
		maze.setOpenDown(1, 0, true);
		maze.setOpenDown(1, 1, true);
		maze.setOpenDown(1, 2, true);
		maze.setOpenDown(1, 3, true);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertTrue(vsd.isVisited(0, 0));
		assertTrue(vsd.isVisited(0, 1));
		assertTrue(vsd.isVisited(0, 2));
		assertFalse(vsd.isVisited(0, 3));
		assertTrue(vsd.isVisited(1, 0));
		assertTrue(vsd.isVisited(1, 1));
		assertTrue(vsd.isVisited(1, 2));
		assertTrue(vsd.isVisited(1, 3));
		assertTrue(vsd.isVisited(2, 0));
		assertTrue(vsd.isVisited(2, 1));
		assertTrue(vsd.isVisited(2, 2));
		assertTrue(vsd.isVisited(2, 3));
	}
	
	public void testT2() {
		// see test60 in TestMaze
		maze = new Maze(3, 3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(1, 0, true);
		maze.setOpenRight(1, 1, true);
		maze.setOpenRight(2, 1, true);
		maze.setOpenDown(0, 0, true);
		maze.setOpenDown(0, 2, true);
		maze.setOpenDown(1, 0, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(),
				c(2,0), c(1,0), c(1,1),
				c(1,2), c(0,2));
	}
	
	public void testT3() {
		// see test63 in TestMaze
		maze = new Maze(3, 5);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(0, 2, true);
		maze.setOpenRight(1, 0, true);
		maze.setOpenRight(1, 3, true);
		maze.setOpenRight(2, 1, true);
		maze.setOpenRight(2, 2, true);
		maze.setOpenRight(2, 3, true);
		maze.setOpenDown(0, 1, true);
		maze.setOpenDown(0, 3, true);
		maze.setOpenDown(0, 4, true);
		maze.setOpenDown(1, 0, true);
		maze.setOpenDown(1, 4, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(),
				c(2,0),c(1,0),c(1,1),
				c(0,1),c(0,2),c(0,3),
				c(1,3),c(1,4),c(0,4));
	}
	
	public void testT4() {
		// see test64 in TestMaze
		maze = new Maze(3, 5);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(0, 2, true);
		maze.setOpenRight(1, 1, true);
		maze.setOpenRight(1, 3, true);
		maze.setOpenRight(2, 1, true);
		maze.setOpenRight(2, 2, true);
		maze.setOpenRight(2, 3, true);
		maze.setOpenDown(0, 0, true);
		maze.setOpenDown(0, 2, true);
		maze.setOpenDown(0, 4, true);
		maze.setOpenDown(1, 0, true);
		maze.setOpenDown(1, 1, true);
		maze.setOpenDown(1, 3, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(),
				c(2,0), c(1,0), c(0,0), c(0,1),
				c(0,2), c(1,2), c(1,1), c(2,1),
				c(2,2), c(2,3), c(1,3), c(1,4),
				c(0,4));
	}
	
	public void testT5() {
		// see test66 in TestMaze
		maze = new Maze(5, 3);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(1, 0, true);
		maze.setOpenRight(1, 1, true);
		maze.setOpenRight(2, 0, true);
		maze.setOpenRight(2, 1, true);
		maze.setOpenRight(3, 0, true);
		maze.setOpenRight(3, 1, true);
		maze.setOpenRight(4, 0, true);
		maze.setOpenRight(4, 1, true);
		maze.setOpenDown(0, 0, true);
		maze.setOpenDown(1, 2, true);
		maze.setOpenDown(2, 0, true);
		maze.setOpenDown(3, 2, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(),
				c(4,0), c(4,1), c(4,2),
				c(3,2), c(3,1), c(3,0),
				c(2,0), c(2,1), c(2,2),
				c(1,2), c(1,1), c(1,0),
				c(0,0), c(0,1), c(0,2));
	}
	
	public void testT6() {
		// see test67 in TestMaze
		maze = new Maze(5, 4);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(0, 2, true);
		maze.setOpenRight(1, 0, true);
		maze.setOpenRight(1, 1, true);
		maze.setOpenRight(2, 1, true);
		maze.setOpenRight(2, 2, true);
		maze.setOpenRight(3, 0, true);
		maze.setOpenRight(3, 1, true);
		maze.setOpenRight(4, 1, true);
		maze.setOpenRight(4, 2, true);
		maze.setOpenDown(0, 0, true);
		maze.setOpenDown(0, 1, true);
		maze.setOpenDown(0, 3, true);
		maze.setOpenDown(1, 0, true);
		maze.setOpenDown(1, 2, true);
		maze.setOpenDown(2, 1, true);
		maze.setOpenDown(2, 3, true);
		maze.setOpenDown(3, 0, true);
		maze.setOpenDown(3, 2, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(),
				c(4,0), c(3,0), c(3,1), c(2,1),
				c(2,2), c(1,2), c(1,1), c(0,1),
				c(0,2), c(0,3));
	}
	
	public void testT7() {
		// see test68 in TestMaze
		maze = new Maze(6, 6);
		solver = new MazeSolver(maze);
		maze.setOpenRight(1, 0, true);
		maze.setOpenRight(2, 0, true);
		maze.setOpenRight(2, 1, true);
		maze.setOpenRight(3, 0, true);
		maze.setOpenRight(3, 1, true);
		maze.setOpenRight(3, 2, true);
		maze.setOpenRight(4, 0, true);
		maze.setOpenRight(4, 1, true);
		maze.setOpenRight(4, 2, true);
		maze.setOpenRight(4, 3, true);
		maze.setOpenRight(5, 0, true);
		maze.setOpenRight(5, 1, true);
		maze.setOpenRight(5, 2, true);
		maze.setOpenRight(5, 3, true);
		maze.setOpenRight(5, 4, true);
		
		maze.setOpenDown(0, 1, true);
		maze.setOpenDown(0, 2, true);
		maze.setOpenDown(0, 3, true);
		maze.setOpenDown(0, 4, true);
		maze.setOpenDown(0, 5, true);
		maze.setOpenDown(1, 2, true);
		maze.setOpenDown(1, 3, true);
		maze.setOpenDown(1, 4, true);
		maze.setOpenDown(1, 5, true);
		maze.setOpenDown(2, 3, true);
		maze.setOpenDown(2, 4, true);
		maze.setOpenDown(2, 5, true);
		maze.setOpenDown(3, 4, true);
		maze.setOpenDown(3, 5, true);
		maze.setOpenDown(4, 5, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(),
				c(5,0), c(5,1), c(5,2), c(5,3),
				c(5,4), c(5,5), c(4,5), c(3,5),
				c(2,5), c(1,5), c(0,5));
	}
	
	public void testT8() {
		// see test69 in TestMaze
		maze = new Maze(10, 10);
		solver = new MazeSolver(maze);
		maze.setOpenRight(0, 0, true);
		maze.setOpenRight(0, 1, true);
		maze.setOpenRight(0, 3, true);
		maze.setOpenRight(0, 4, true);
		maze.setOpenRight(0, 5, true);
		maze.setOpenRight(0, 7, true);
		maze.setOpenRight(0, 8, true);
		maze.setOpenRight(2, 0, true);
		maze.setOpenRight(2, 1, true);
		maze.setOpenRight(2, 2, true);
		maze.setOpenRight(2, 4, true);
		maze.setOpenRight(2, 6, true);
		maze.setOpenRight(2, 7, true);
		maze.setOpenRight(2, 8, true);
		maze.setOpenRight(3, 0, true);
		maze.setOpenRight(3, 1, true);
		maze.setOpenRight(3, 5, true);
		maze.setOpenRight(3, 8, true);
		maze.setOpenRight(4, 0, true);
		maze.setOpenRight(4, 4, true);
		maze.setOpenRight(4, 6, true);
		maze.setOpenRight(4, 7, true);
		maze.setOpenRight(5, 0, true);
		maze.setOpenRight(5, 2, true);
		maze.setOpenRight(5, 3, true);
		maze.setOpenRight(5, 4, true);
		maze.setOpenRight(5, 5, true);
		maze.setOpenRight(5, 6, true);
		maze.setOpenRight(5, 7, true);
		maze.setOpenRight(5, 8, true);
		maze.setOpenRight(6, 2, true);
		maze.setOpenRight(6, 3, true);
		maze.setOpenRight(6, 4, true);
		maze.setOpenRight(6, 5, true);
		maze.setOpenRight(6, 6, true);
		maze.setOpenRight(6, 7, true);
		maze.setOpenRight(6, 8, true);
		maze.setOpenRight(7, 3, true);
		maze.setOpenRight(7, 4, true);
		maze.setOpenRight(7, 5, true);
		maze.setOpenRight(7, 8, true);
		maze.setOpenRight(8, 1, true);
		maze.setOpenRight(8, 4, true);
		maze.setOpenRight(9, 0, true);
		maze.setOpenRight(9, 1, true);
		maze.setOpenRight(9, 2, true);
		maze.setOpenRight(9, 6, true);
		maze.setOpenRight(9, 7, true);
		maze.setOpenRight(9, 8, true);
		
		maze.setOpenDown(0, 0, true);
		maze.setOpenDown(0, 2, true);
		maze.setOpenDown(0, 4, true);
		maze.setOpenDown(0, 6, true);
		maze.setOpenDown(0, 9, true);
		maze.setOpenDown(1, 0, true);
		maze.setOpenDown(1, 2, true);
		maze.setOpenDown(1, 4, true);
		maze.setOpenDown(1, 5, true);
		maze.setOpenDown(1, 6, true);
		maze.setOpenDown(1, 8, true);
		maze.setOpenDown(1, 9, true);
		maze.setOpenDown(2, 0, true);
		maze.setOpenDown(2, 3, true);
		maze.setOpenDown(2, 4, true);
		maze.setOpenDown(2, 6, true);
		maze.setOpenDown(3, 2, true);
		maze.setOpenDown(3, 3, true);
		maze.setOpenDown(3, 4, true);
		maze.setOpenDown(3, 6, true);
		maze.setOpenDown(3, 8, true);
		maze.setOpenDown(3, 9, true);
		maze.setOpenDown(4, 0, true);
		maze.setOpenDown(4, 2, true);
		maze.setOpenDown(4, 9, true);
		maze.setOpenDown(5, 0, true);
		maze.setOpenDown(5, 1, true);
		maze.setOpenDown(5, 2, true);
		maze.setOpenDown(6, 0, true);
		maze.setOpenDown(6, 1, true);
		maze.setOpenDown(6, 7, true);
		maze.setOpenDown(6, 8, true);
		maze.setOpenDown(7, 0, true);
		maze.setOpenDown(7, 1, true);
		maze.setOpenDown(7, 2, true);
		maze.setOpenDown(7, 3, true);
		maze.setOpenDown(7, 6, true);
		maze.setOpenDown(7, 7, true);
		maze.setOpenDown(7, 8, true);
		maze.setOpenDown(7, 9, true);
		maze.setOpenDown(8, 1, true);
		maze.setOpenDown(8, 3, true);
		maze.setOpenDown(8, 4, true);
		maze.setOpenDown(8, 5, true);
		maze.setOpenDown(8, 6, true);
		maze.setOpenDown(8, 9, true);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(),
				c(9,0), c(9,1), c(9,2), c(9,3),
				c(8,3), c(7,3), c(7,4), c(7,5),
				c(7,6), c(8,6), c(9,6), c(9,7),
				c(9,8), c(9,9), c(8,9), c(7,9),
				c(7,8), c(6,8), c(6,7), c(6,6),
				c(6,5), c(6,4), c(6,3), c(6,2),
				c(5,2), c(5,3), c(5,4), c(5,5),
				c(5,6), c(5,7), c(5,8), c(5,9),
				c(4,9), c(3,9), c(3,8), c(4,8),
				c(4,7), c(4,6), c(3,6), c(2,6),
				c(2,7), c(2,8), c(2,9), c(1,9),
				c(0,9));
	}
	
	public void testU0() throws IOException {
		maze = Maze.fromFile("lib"+File.separator+"noway.txt");
		solver = new MazeSolver(maze);
		solution = solver.findPath();
		VisitedSolutionDisplay vsd = (VisitedSolutionDisplay)solution;
		assertTrue(vsd.isVisited(0, 0));
		assertTrue(vsd.isVisited(0, 1));
		assertTrue(vsd.isVisited(1, 0));
		assertTrue(vsd.isVisited(1, 1));
		assertTrue(vsd.isVisited(2, 0));
		assertFalse(vsd.isVisited(2, 1));
		assertFalse(vsd.isVisited(2, 2));
		assertFalse(vsd.isVisited(2, 3));
		assertFalse(vsd.isVisited(1, 2));
		assertFalse(vsd.isVisited(1, 3));
		assertFalse(vsd.isVisited(0, 2));
		assertFalse(vsd.isVisited(0, 3));
	}
	
	public void testU1() throws IOException {
		maze = Maze.fromFile("lib"+File.separator+"medium.txt");
		solver = new MazeSolver(maze);
		solution = solver.findPath();
		PathSolutionDisplay psd = (PathSolutionDisplay)solution;
		assertContents(psd.getPath(),
				c(9,0), c(9,1), c(9,2), c(8,2), c(7,2), 
				c(7,3), c(7,4), c(8,4), c(9,4), c(9,5), 
				c(9,6), c(9,7), c(9,8), c(9,9), c(8,9), 
				c(7,9), c(6,9), c(6,8), c(7,8), c(7,7), 
				c(6,7), c(6,6), c(5,6), c(4,6), c(4,5), 
				c(3,5), c(3,4), c(4,4), c(5,4), c(5,3), 
				c(5,2), c(5,1), c(4,1), c(3,1), c(2,1), 
				c(2,0), c(1,0), c(0,0), c(0,1), c(0,2), 
				c(1,2), c(2,2), c(3,2), c(3,3), c(2,3), 
				c(2,4), c(2,5), c(2,6), c(1,6), c(1,7), 
				c(2,7), c(2,8), c(1,8), c(0,8), c(0,9), 
				c(0,10), c(0,11), c(1,11), c(2,11), c(3,11), 
				c(4,11), c(4,12), c(4,13), c(3,13), c(3,12), 
				c(2,12), c(1,12), c(0,12), c(0,13), c(0,14));
	}
	
}
