package maze;

/** An InvalidMazeException indicates that a maze is invalid
 *  @author Sam Zhen
 *  @version 25th April 2021
 */
public class InvalidMazeException extends Exception 
{
	/** Constructs an InvalidMazeException with the specified detail message
	 */
	public InvalidMazeException(String message)
	{
		super(message);
	} 
}