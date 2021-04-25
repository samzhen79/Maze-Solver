package maze;

/** Tile class that represents one space within a maze
 *  @author Sam Zhen
 *  @version 25th April 2021
 */
public class Tile 
{

	/**
	 * Provides a representation of all the different tile types
	 */
	enum Type 
	{
		CORRIDOR,ENTRANCE,EXIT,WALL;
	}

	private Type type;

	private void Tile(Type t) 
	{

	}

	/** Constructs a Tile from an input character
	 *  @param c: The input character to be converted
	 *  @return Returns the Tile with type determined by the input character
	 */
	protected static Tile fromChar(char c) 
	{

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

	}

	/** Converts the tile into its string representation
	 *  @return Returns a string produced from the tile
	 */
	public String toString() 
	{

	}
}