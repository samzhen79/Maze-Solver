package maze.visualisation;
import maze.*;
import maze.routing.*;
import maze.visualisation.TileRectangle;
import java.util.List;
import java.util.ArrayList;
import javafx.scene.layout.GridPane;

/** Container for the visualisation of the routefinder using TileRectangle objects
  * @author Sam Zhen
  * @version 29th April 2021
  * @see javafx.scene.layout.GridPane
  */
public class RouteFinderGrid extends javafx.scene.layout.GridPane
{
	private RouteFinder routefinder;

	/** Constructs a RouteFinderGrid object using the given RouteFinder object
	  * @param inRouteFinder: The routefinder that will be viusalised
	  */
	public RouteFinderGrid(RouteFinder inRouteFinder)
	{
		super();
		routefinder = inRouteFinder;
		updateGrid();
	}

	/** Constructs an empty RouteFinderGrid
	 */
	public RouteFinderGrid()
	{
		super();
		routefinder = null;
	}

	/** Updates the grid using the routefinder attribute
	  */
	public void updateGrid()
	{
		List<List<Tile>> tiles = routefinder.getMaze().getTiles();

		for (int i = 0; i < tiles.size(); i++)
		{
			for (int k = 0; k < tiles.get(i).size(); k++)
			{
				Tile tile = tiles.get(i).get(k);
				this.add(new TileRectangle(25, tile, routefinder.getRoute().contains(tile)), k, i);
			}
		}
	}

	/** Gets the routefinder attribute
	  * @return Returns the routefinder RouteFinder attribute
	  */
	public RouteFinder getRouteFinder()
	{
		return routefinder;
	}

	/** Steps through the routefinder
	 *  @return Returns true if the route is finished, false otherwise
	 *  @throws NoRouteFoundException if no route is found
	 */
	public boolean step() throws NoRouteFoundException
	{
		try
		{
			if (routefinder.step())
			{
				updateGrid();
				return true;
			}
			else
			{
				updateGrid();
				return false;
			}
		}
		catch(NoRouteFoundException e)
		{
			throw e;
		}
	}
}
