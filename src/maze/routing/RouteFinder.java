package maze.routing;
import java.util.Stack;

public class RouteFinder
{
	private Maze maze;
	private Stack<Tile> route;
	private boolean finished;

	public RouteFinder(Maze)
	{

	}

	public Maze getMaze()
	{
		return maze;
	}

	public List<Tile> getRoute()
	{
		return route;
	}

	public boolean isFinished()
	{
		return finished;
	}

	public static RouteFinder load(String path)
	{
		return null;
	}

	public void save(String filename)
	{

	}

	public boolean step()
	{
		return false;
	}

	public String toString()
	{
		return null;
	}
}