package maze;

/** A NoExitException is thrown when there are no Exit tiles in a maze
 *  @author Sam Zhen
 *  @version 25th April 2021
 */
public class NoExitException extends InvalidMazeException
{
	/** Constructs an NoExitException with the specified detail message 
	 */
	public NoExitException(String message)
	{
		super(message);
	} 
}