package maze.visualisation;
import maze.*;
import maze.routing.*;
import maze.visualisation.TileRectangle;
import java.util.List;
import java.util.ArrayList;
import javafx.scene.layout.GridPane;

public class RouteFinderGrid extends javafx.scene.layout.GridPane
{
	private RouteFinder routefinder;

	public RouteFinderGrid(RouteFinder inRouteFinder)
	{
		super();
		routefinder = inRouteFinder;
		updateGrid();
	}

	public RouteFinderGrid()
	{
		super();
		routefinder = null;
	}

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

	public RouteFinder getRouteFinder()
	{
		return routefinder;
	}

	public boolean step() throws NoRouteFoundException
	{
		try
		{
			if (routefinder.step())
			{
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
