package maze.visualisation;
import maze.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

/** Container for the visualisation of a Tile in the routefinder maze
  * @author Sam Zhen
  * @version 29th April 2021
  * @see javafx.scene.shape.Rectangle
  */
public class TileRectangle extends javafx.scene.shape.Rectangle
{
	private Tile tile;

	/** Constructs a TileRectangle with the given size, tile and if it is in the route
	 *  @param size: This is the size of the rectangle as double, passed to super as both width and height
	 *  @param inTile: The input tile, the color of the rectangle is determined by the tile type using findColor() method
	 *  @param inRoute: True if tile is part of the route, false otherwise. Used to help determine the rectangle color
	 *  @see #findColor(Tile, boolean)
	 */
	public TileRectangle(double size, Tile inTile, boolean inRoute)
	{
		super(size, size, TileRectangle.findColor(inTile, inRoute));
		tile = inTile;
	}

	/** Chooses the color for the rectangle
	  * Entrance: Blue
	  * Exit: Red
	  * Corridor: Green
	  * Wall: Black
	  * Route: Yellow
	  * @param inTile: The input tile in which its type will be used to determine color
	  * @param inRoute: True if the tile is in the route, false otherwise. If true then color will yellow
	  * @return Returns the decided color of the rectangle
	  */
	public static Color findColor(Tile inTile, boolean inRoute)
	{
		Color color = null;

		if (inRoute)
		{
			color = Color.YELLOW;
		}
		else
		{
			switch (inTile.getType())
			{
				case ENTRANCE:
					color = Color.BLUE;
					break;

				case EXIT:
					color = Color.RED;
					break;

				case CORRIDOR:
					color = Color.GREEN;
					break;

				case WALL:
					color = Color.BLACK;
					break;

				default:
			}
		}

		return color;
	}

	/** Gets the tile attribute
	 *  @return Returns the tile Tile attribute
	 */
	public Tile getTile()
	{
		return tile;
	}
}