package maze;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/** Maze class to provide the representation of the maze
 *  @author Sam Zhen
 *  @version 25th April 2021
 */
public class Maze 
{
	/**
	 * Provides a representation of the four cardinal directions
	 */
	public enum Direction 
	{
		NORTH,SOUTH,EAST,WEST;
	}

	private Tile entrance;
	private Tile exit;
	private List<List<Tile>> tiles;

	private Maze() 
	{

	}

	/** Constructs a maze from a given text file
	 * @param path: The full file path to the text file
	 * @return Returns a maze produced by converting the given string found in the text file
	 */
	public static Maze fromTxt(String path) throws FileNotFoundException, IOException, InvalidMazeException
	{
		Maze maze = new Maze();

		ArrayList<List<Tile>> list = new ArrayList<List<Tile>>();

		BufferedReader reader = new BufferedReader(new FileReader(path));

		String line;

		while ((line = reader.readLine()) != null)
		{
			ArrayList<Tile> sublist = new ArrayList<Tile>();

			for (int i = 0; i < line.length(); i++)
			{
				Tile t = Tile.fromChar(line.charAt(i));
				switch(t.getType())
				{
					case ENTRANCE:
						if (maze.getEntrance() == null)
						{
							maze.setEntrance(t);
						}
						else
						{
							throw new MultipleEntranceException("Too many entrances");
						}
						break;

					case EXIT:
						if (maze.getExit() == null)
						{
							maze.setExit(t);
						}
						else
						{
							throw new MultipleExitException("Too many exits");
						}
						break;

					default:

				}

				sublist.add(t);
			}

			list.add(sublist);
		}

		if (maze.getEntrance() == null)
		{
			throw new NoEntranceException("No entrance");
		}
		else if (maze.getExit() == null)
		{
			throw new NoExitException("No exit");
		}

		int length = list.get(0).size();

		for (int i = 1; i < list.size(); i++)
		{
			if (length != list.get(i).size())
			{
				throw new RaggedMazeException("Ragged maze");
			}
		}

		maze.setTiles(list);

		return maze;
	}

	/** Gets the tile adjacent to a tile
	 * @param t: The origin tile
	 * @param d: The direction from the origin tile
	 * @return Returns the tile that is in the direction of the origin tile
	 */
	public Tile getAdjacent(Tile t, Direction d)
	{
		switch (d)
		{
			case NORTH:
				for(int i = 0; i < tiles.size(); i++)
				{
					if (tiles.get(i).contains(t))
					{
						int index = tiles.get(i).indexOf(t);
						try
						{
							return tiles.get(i - 1).get(index);
						}
						catch(IndexOutOfBoundsException e)
						{
							return null;
						}
					}
				}
				break;

			case SOUTH:
				for(int i = 0; i < tiles.size(); i++)
				{
					if (tiles.get(i).contains(t))
					{
						int index = tiles.get(i).indexOf(t);
						try
						{
							return tiles.get(i + 1).get(index);
						}
						catch(IndexOutOfBoundsException e)
						{
							return null;
						}
					}
				}
				break;

			case EAST:
				for(int i = 0; i < tiles.size(); i++)
				{
					if (tiles.get(i).contains(t))
					{
						int index = tiles.get(i).indexOf(t) + 1;
						try
						{
							return tiles.get(i).get(index + 1);
						}
						catch(IndexOutOfBoundsException e)
						{
							return null;
						}
					}
				}
				break;

			case WEST:
				for(int i = 0; i < tiles.size(); i++)
				{
					if (tiles.get(i).contains(t))
					{
						int index = tiles.get(i).indexOf(t) - 1;
						try
						{
							return tiles.get(i).get(index - 1);
						}
						catch(IndexOutOfBoundsException e)
						{
							return null;
						}
					}
				}
				break;

			default:

				return null;
		}
		return null;
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
		return null;
	}

	/** Gets the location of a given tile
	 * @param t: The tile to find the location for
	 * @return Returns the coordinates of the location of the tile
	 */
	public Coordinate getTileLocation(Tile t) 
	{
		return null;
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

	private void setTiles(List<List<Tile>> list)
	{
		tiles = list;
	}

	/** Converts the maze into its text representation
	 * @return Returns a String produced from the maze
	 */
	public String toString() 
	{
		String string = new String();

		for (int i = 0; i < tiles.size(); i++)
		{
			List<Tile> tilesList = tiles.get(i);
			for (int k = 0; k < tilesList.size(); k++)
			{
				string = string.concat(tilesList.get(k).toString());
			}

			string = string.concat("\n");
		}

		return string;
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
			return null;
		}
	}
}