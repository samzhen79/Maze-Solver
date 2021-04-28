package maze;

import maze.InvalidMazeException;
import java.io.Serializable;

/** Tile class that represents one space within a maze
 *  @author Sam Zhen
 *  @version 28th April 2021
 */
public class Tile implements Serializable
{

	/**
	 * Provides a representation of all the different tile types
	 */
	public enum Type 
	{
		CORRIDOR,ENTRANCE,EXIT,WALL;
	}

	private Type type;

	private Tile(Type t) 
	{
		type = t;
	}

	/** Constructs a Tile from an input character
	 *  @param c: The input character to be converted
	 *  @return Returns the Tile with type determined by the input character
	 */
	protected static Tile fromChar(char c) throws InvalidMazeException
	{	
		switch(c)
		{
			case '.':
				return new Tile(Tile.Type.CORRIDOR);

			case 'e':
				return new Tile(Tile.Type.ENTRANCE);

			case 'x':
				return new Tile(Tile.Type.EXIT);
				
			case '#':
				return new Tile(Tile.Type.WALL);

			default:
				throw new InvalidMazeException("Invalid char");
		}

	}

	/** Gets the type of the tile
	 *  @return Returns the type of the tile
	 */
	public Type getType() 
	{
		return type;
	}

	/** Checks if the tile is navigable
	 *  @return Returns True if the tile is navigable, otherwise return false.
	 */
	public boolean isNavigable() 
	{
		if (type == Tile.Type.WALL)
		{
			return false;
		}
		else
		{
			return true;
		}
	}	

	/** Converts the tile into its string representation
	 *  @return Returns a string produced from the tile
	 */
	public String toString() 
	{	
		switch(type)
		{
			case CORRIDOR:
				return new String(".");

			case ENTRANCE:
				return new String("e");

			case EXIT:
				return new String("x");

			case WALL:
				return new String("#");

			default:
				System.out.println("oh no, bad type");
				return null;

		}
	}
}