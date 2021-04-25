package maze;

/** Maze class to provide the representation of the maze
 *  @author Sam Zhen
 *  @version 25th April 2021
 */
public class Maze 
{
	/**
	 * Provides a representation of the four cardinal directions
	 */
	enum Direction 
	{
		NORTH,SOUTH,EAST,WEST;
	}

	private Tile entrance;
	private Tile exit;
	private List<List<Tile>> tiles;

	private void Maze() 
	{

	}

	/** Constructs a maze from a given text file
	 * @param s: The full file path to the text file
	 * @return Returns a maze produced by converting the given string
	 */
	public static Maze fromTxt(String s) 
	{

	}

	/** Gets the tile adjacent to a tile
	 * @param t: The origin tile
	 * @param d: The direction from the origin tile
	 * @return Returns the tile that is in the direction of the origin tile
	 */
	public Tile getAdjacent(Tile t, Direction d) 
	{

	}

	/** Gets the entrance tile
	 * @return Returns the entrance Tile attribute
	 */
	public Tile getEntrance() 
	{
		return entrance;
	}

	/** Gets the exit tile
	 * @return Returns the exit Tile attribute
	 */
	public Tile getExit() 
	{
		return exit;
	}

	/** Gets the tile at a given location
	 * @param c: The coordinates of the location
	 * @return Returns the Tile found at the given location
	 */
	public Tile getTileAtLocation(Coordinate c) 
	{

	}

	/** Gets the location of a given tile
	 * @param t: The tile to find the location for
	 * @return Returns the coordinates of the location of the tile
	 */
	public Coordinate getTileLocation(Tile t) 
	{

	}

	/** Gets the tiles of the maze
	 * @return Returns a list of lists of the tiles in the maze
	 */
	public List<List<Tile>> getTiles() 
	{
		return tiles;
	}

	private void setEntrance(Tile t) 
	{
		entrance = t;
	}

	private void setExit(Tile t) 
	{
		exit = t;
	}

	/** Converts the maze into its text representation
	 * @return Returns a String produced from the maze
	 */
	public String toString() 
	{

	}

	/** Coordinate class to manage 2D coordinates of the maze
	 */
	public class Coordinate 
	{
		/**
		 * x represents the column number (indexed from 0, where 0 is the left of the maze)
		 */
		private int x;
		/**
		 * y represents the row number (indexed from 0, where 0 is the bottom of the maze)
		 */
		private int y;

		/** Sets the Coordinate attributes to input parameters
		 * @param xIn: The x-coordinate input
		 * @param yIn: The y-coordinate input
		 */
		public void Coordinate(int xIn, int yIn) 
		{
			x = xIn;
			y = yIn;
		}

		/** Gets the x-coordinate
		 * @return Returns the x int attribute
		 */
		public int getX() 
		{
			return x;
		}

		/** Gets the y-coordinate
		 * @return Returns the y int attribute
		 */
		public int getY() 
		{
			return y;
		}

		/** Converts the coordinate attributes into their string form
		 * @return Returns a "(x,y)" where x and y are the coordinate attributes
		 */
		public String toString() 
		{

		}
	}
}