package maze.routing;

import java.util.Stack;

/** RouteFinder attempts to find a route from entrance to exit of a maze.
 * The state of the RouteFinder can be stepped through.
 *  @author Sam Zhen
 *  @version 26th April 2021
 */
public class RouteFinder
{
	private Maze maze;
	private Stack<Tile> route;
	private boolean finished;

	/** Constructs a RouteFinder with the specified maze
	 *  @param m: The maze for which the RouteFinder will find a route for
	 */
	public RouteFinder(Maze m)
	{

	}

	/** Gets the maze that the RouteFinder is finding a route for
	 *  @return Returns the maze attribute
	 */
	public Maze getMaze()
	{
		return maze;
	}

	/** Gets the current route
	 *  @return Returns the route attribute which is a list of Tile objects
	 */
	public List<Tile> getRoute()
	{
		return route;
	}

	/** Checks if the route is complete
	 *  @return Returns the finished attribute, true for finished and false otherwise
	 */
	public boolean isFinished()
	{
		return finished;
	}

	/** Loads a RouteFinder object from a text file
	 *  @param path: The full file path to the text file
	 *  @return Returns the RouteFinder object that was loaded from the text file
	 */
	public static RouteFinder load(String path)
	{
		return null;
	}

	/** Loads a RouteFinder object from a text file
	 *  @param filename: The name of the text file
	 *  @return Returns the RouteFinder object that was loaded from the text file
	 */
	public void save(String filename)
	{

	}

	/** Updates the stack (route).
	 *  A call to this method should make exactly one move through the maze
	 *  @return Returns true if the maze is complete
	 *  @throws NoRouteFoundException If the method gets stuck in a circular route
	 * 								  or otherwise finds that no route is possible.
	 */
	public boolean step() throws NoRouteFoundException
	{
		return finished;
	}

	/** Visualises the entire maze and route-solving state as a string
	 *  @return Returns a string that is a representation of the maze and the route-solving state
	 */
	public String toString()
	{
		return null;
	}
}