package maze.routing;

import maze.*;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;
import java.util.EmptyStackException;
import java.lang.ClassNotFoundException;

/** RouteFinder attempts to find a route from entrance to exit of a maze.
 * The state of the RouteFinder can be stepped through.
 *  @author Sam Zhen
 *  @version 28th April 2021
 */
public class RouteFinder implements java.io.Serializable
{
	private Maze maze;
	private Stack<Tile> route;
	private boolean finished;

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
		try
		{
			FileInputStream file = new FileInputStream(path);
			ObjectInputStream in = new ObjectInputStream(file);

			RouteFinder routefinder = (RouteFinder)in.readObject();

			in.close();
			file.close();

			return routefinder;
		}
		catch(IOException e)
		{
			System.out.println("IOException caught");
			return null;
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("ClassNotFoundException caught"); 
			return null;
		}
	}

	/** Loads a RouteFinder object from a file
	 *  @param filename: The name of the file and its path
	 */
	public void save(String filename)
	{
		try
		{
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);

			out.writeObject(this);

			out.close();
			file.close();
		}
		catch(IOException e)
		{
			System.out.println("IOException caught");
			System.err.println(e);
		}
	}

	/** Updates the stack (route).
	 *  A call to this method should make exactly one move through the maze
	 *  @return Returns true if the route is complete
	 *  @throws NoRouteFoundException If there is no possible route to solve the maze
	 */
	public boolean step() throws NoRouteFoundException
	{
		if (finished)
		{
			return finished;
		}
		Tile current;

		try
		{
			current = route.peek();
		}
		catch (EmptyStackException e)
		{
			throw new NoRouteFoundException("No route");
		}

		Maze.Direction[] directionlist = new Maze.Direction[4];

		directionlist[0] = Maze.Direction.EAST;
		directionlist[1] = Maze.Direction.SOUTH;
		directionlist[2] = Maze.Direction.WEST;
		directionlist[3] = Maze.Direction.NORTH;

		for (int i = 0; i < 4; i++)
		{
			Tile tile = maze.getAdjacentTile(current, directionlist[i]);

			if (tile != null)
			{	
				if (tile == maze.getExit())
				{	
					route.push(tile);
					finished = true;
					return finished;
				}
				else if (tile.isNavigable() == true && !routehistory.contains(tile))
				{
					routehistory.add(tile);
					route.push(tile);
					return finished;
				}

			}
		}

		route.pop();
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