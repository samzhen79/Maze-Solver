package maze;

/** A MultipleExitException is thrown when there are Multiple Exit tiles in a maze
 *  @author Sam Zhen
 *  @version 25th April 2021
 */
public class MultipleExitException extends InvalidMazeException
{
	/** Constructs an MultipleExitException with the specified detail message 
	 */
	public MultipleExitException(String message)
	{
		super(message);
	} 
}