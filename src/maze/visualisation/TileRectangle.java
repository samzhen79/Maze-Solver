package maze.visualisation;
import maze.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class TileRectangle extends javafx.scene.shape.Rectangle
{
	private Tile tile;

	public TileRectangle(double size, Tile inTile, boolean inRoute)
	{
		super(size, size, TileRectangle.findColor(inTile, inRoute));
		tile = inTile;
	}

	private static Color findColor(Tile inTile, boolean inRoute)
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

	public Tile getTile()
	{
		return tile;
	}
}