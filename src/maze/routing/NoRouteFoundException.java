package maze.routing;

/** An NoRouteFoundException indicates that not route is available for the maze
 *  @author Sam Zhen
 *  @version 26th April 2021
 */
public class NoRouteFoundException extends Exception 
{
	/** Constructs an NoRouteFoundException with the specified detail message
	 */
	public NoRouteFoundException(String message)
	{
		super(message);
	} 
}