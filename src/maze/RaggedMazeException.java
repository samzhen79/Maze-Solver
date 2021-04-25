package maze;

/** A RaggedMazeException is thrown when each row of a maze do not have the same nunber of tiles
 *  @author Sam Zhen
 *  @version 25th April 2021
 */
public class RaggedMazeException extends InvalidMazeException
{
	/** Constructs an RaggedMazeException with the specified detail message 
	 */
	public RaggedMazeException(String message)
	{
		super(message);
	} 
}