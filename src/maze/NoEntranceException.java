package maze;

/** A NoEntranceException is thrown when there are no entrance tiles in a maze
 *  @author Sam Zhen
 *  @version 25th April 2021
 */
public class NoEntranceException extends InvalidMazeException
{
	/** Constructs an NoEntranceException with the specified detail message 
	 */
	public NoEntranceException(String message)
	{
		super(message);
	} 
}