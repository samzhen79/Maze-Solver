package maze;

/** A MultipleEntranceException is thrown when there are Multiple Entrance tiles in a maze
 *  @author Sam Zhen
 *  @version 25th April 2021
 */
public class MultipleEntranceException extends InvalidMazeException
{
	/** Constructs an MultipleEntranceException with the specified detail message 
	 */
	public MultipleEntranceException(String message)
	{
		super(message);
	} 
}