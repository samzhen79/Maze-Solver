package maze.routing;

/** A NoRouteFoundException indicates that no route is available for the maze
 *  @author Sam Zhen
 *  @version 27th April 2021
 */
public class NoRouteFoundException extends Exception 
{
	/** Constructs a NoRouteFoundException with the specified detail message
	 */
	public NoRouteFoundException(String message)
	{
		super(message);
	} 
}