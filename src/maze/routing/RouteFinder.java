package maze.routing;

import maze.Maze;
import maze.Tile;
import java.util.List;
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;

/** RouteFinder attempts to find a route from entrance to exit of a maze.
 * The state of the RouteFinder can be stepped through.
 *  @author Sam Zhen
 *  @version 27th April 2021
 */
public class RouteFinder
{
	private Maze maze;
	private Stack<Tile> route;
	private boolean finished;

	private Tile back;
	private Set<Tile> routehistory;

	/** Constructs a RouteFinder with the specified maze
	 *  @param m: The maze for which the RouteFinder will find a route for
	 */
	public RouteFinder(Maze m)
	{
		maze = m;
		route = new Stack<Tile>();
		route.push(m.getEntrance());
		routehistory = new HashSet<Tile>();
		routehistory.add(m.getEntrance());
		finished = false;
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
	 *  @throws NoRouteFoundException If there is no possible route to solve the maze
	 */
	public boolean step() throws NoRouteFoundException
	{
		try
		{
			Tile current = route.peek();
		}
		catch (EmptyStackException e)
		{
			throw new NoRouteFoundException;
		}
		Tile[] tilelist = new Tile[4];

		tilelist[0] = maze.getAdjacent(current, Maze.Direction.EAST);
		tilelist[1] = maze.getAdjacent(current, Maze.Direction.SOUTH);
		tilelist[2] = maze.getAdjacent(current, Maze.Direction.WEST);
		tilelist[3] = maze.getAdjacent(current, Maze.Direction.NORTH);

		if (current == maze.getExit())
		{
			finished = true;
		}
		else
		{
			for (int i = 0; i < 4; i++)
			{
				Tile tile = tilelist[i];
				if (tile != null && !routehistory.contains(tile))
				{
					if (tile.isNavigable() == true)
					{
						routehistory.add(tile);
						route.push(tile);
						return finished;
					}

				}
			}
			back = route.pop();
		}
		
		return finished;
	}

	/** Visualises the entire maze and route-solving state as a string
	 *  @return Returns a string that is a representation of the maze and the route-solving state
	 */
	public String toString()
	{
		String string = new String();
		List<List<Tile>> tiles = maze.getTiles();

		for (int i = 0; i < tiles.size(); i++)
		{
			List<Tile> tilesList = tiles.get(i);

			for (int k = 0; k < tilesList.size(); k++)
			{
				if (route.contains(tilesList.get(k)))
				{
					string = string.concat("*");
				}
				else
				{
					string = string.concat(tilesList.get(k).toString());
				}
			}

			string = string.concat("\n");
		}

		return string;
	}
}