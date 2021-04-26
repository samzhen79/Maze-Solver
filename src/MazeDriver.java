import maze.Maze;
import maze.Maze.Coordinate;
import maze.Tile;
import maze.InvalidMazeException;
import java.io.Console;
import java.io.FileNotFoundException;
import java.io.IOException;

/** MazeDriver that can print Maze and RouteFinder state to the console/terminal
 *  @author Sam Zhen
 *  @version 26th April 2021
 */
public class MazeDriver 
{
    public static void main(String args[]) 
    {	
    	String path = null;
    	boolean done = false;
    	Maze maze = null;

    	while (!done)
    	{
	    	try
	    	{
				Console keyboardConsole = System.console();
				path = keyboardConsole.readLine("\nEnter file path: ");

				maze = Maze.fromTxt("C:/Users/samba/gitrepos/comp16412-coursework-2_x74717zz/resources/mazes/maze1.txt");
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

    	Coordinate c  = maze.new Coordinate(0,0);
		Tile tile = maze.getTileAtLocation(c);
    	System.out.println(maze.toString());
    	if (tile != null)
    	{
    		System.out.println(tile.toString());
    	}
    	else
    	{
    		System.out.println("null tile");
    	}

    	System.out.println(c.toString());
    	Coordinate d = maze.getTileLocation(maze.getEntrance());
    	System.out.println(d.toString());

    	

    }
}
