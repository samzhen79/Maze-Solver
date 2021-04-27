import maze.Maze;
import maze.Maze.Coordinate;
import maze.Tile;
import maze.InvalidMazeException;
import maze.routing.RouteFinder;
import maze.routing.NoRouteFoundException;
import java.io.Console;
import java.io.FileNotFoundException;
import java.io.IOException;

/** MazeDriver that can print Maze and RouteFinder state to the console/terminal
 *  @author Sam Zhen
 *  @version 27th April 2021
 */
public class MazeDriver 
{
    public static void main(String args[]) 
    {	
    	String path = null;
    	String step = null;
    	boolean done = false;
    	boolean finished = false;
    	Maze maze = null;

    	while (!done)
    	{
	    	try
	    	{
				Console keyboardConsole = System.console();
				path = keyboardConsole.readLine("\nEnter file path: ");

				maze = Maze.fromTxt("C:/Users/samba/gitrepos/comp16412-coursework-2_x74717zz/resources/mazes/testmaze.txt");
				done = true;
	    	}
	    	catch(FileNotFoundException e)
	    	{
	    		System.err.print(e);
	    	}
	    	catch(IOException e)
	    	{
	    		System.err.print(e);
	    	}
	    	catch(InvalidMazeException e)
	    	{
	    		System.err.print(e);
	    	}
    	}
    	
    	RouteFinder routefinder = new RouteFinder(maze);

    	while (!finished)
    	{
			Console keyboardConsole = System.console();
			step = keyboardConsole.readLine("\nStep");
			
			try
			{
				finished = routefinder.step();
				System.out.println(routefinder.toString());
			}
			catch (NoRouteFoundException e)
			{
				System.out.println("No route found");
			}
			
    	}
    	System.out.println("Exit found");

    }
}
