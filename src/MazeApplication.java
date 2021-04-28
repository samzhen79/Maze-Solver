import maze.*;
import maze.routing.*;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox; 
import javafx.scene.layout.GridPane;
import javafx.scene.Scene; 
import javafx.scene.control.Button;
import javafx.stage.Stage; 
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

/** The MazeApplication class is a JavaFX application.
 *  Allows the user to specify a text file containing a maze representation.
 *  The graphical representation of the maze is displayed to the user.
 *  The user will be able to:
 *  (i) Step through the solving process with the visualisation updating to the current state.
 *  (ii) Save the current route-solving state to a file.
 *  (iii) Load route-solving state froma file.
 *  @author Sam Zhen
 *  @version 25th April 2021
 */
public class MazeApplication extends Application 
{
	private RouteFinder routefinder;
	private GridPane mazegrid;

	public static void main(String[] args) 
	{
		launch(args);
	}

	@Override
	public void start(Stage stage) 
	{
		BorderPane border = new BorderPane();

		Scene scene = new Scene(border, 600, 600);

		Button loadmaze = new Button("Load Maze");
		Button loadroute = new Button("Load Route");
		Button saveroute = new Button("Save Route");
		Button step = new Button("Step");

		loadmaze.setOnAction(new EventHandler<ActionEvent>() 
		{
			@Override
			public void handle(ActionEvent e)
			{
				FileChooser filechooser = new FileChooser();
				filechooser.setTitle("Open Map Text File");
				File file = filechooser.showOpenDialog(stage);
				Maze maze = null;
				try
				{
					maze = Maze.fromTxt(file.getAbsolutePath());
				}
		    	catch(FileNotFoundException ex)
		    	{
		    		System.err.print(ex);
		    	}
		    	catch(IOException ex)
		    	{
		    		System.err.print(ex);
		    	}
		    	catch(InvalidMazeException ex)
		    	{
		    		System.err.print(ex);
		    	}

		    	routefinder = new RouteFinder(maze);

		    	updateGrid();
			}
		});

		step.setOnAction(new EventHandler<ActionEvent>() 
		{
			@Override
			public void handle(ActionEvent e)
			{
				try
				{
					routefinder.step();
				}
				catch(NoRouteFoundException ex)
				{
					System.err.print(ex);
				}

				updateGrid();
			}
		});

		HBox hbox = new HBox(loadmaze, loadroute, saveroute, step);
		hbox.setPadding(new Insets(0, 10, 15, 10));
		hbox.setSpacing(10);

		mazegrid = new GridPane();
		mazegrid.setPadding(new Insets(0, 10, 10, 10));

		border.setTop(hbox);
		border.setCenter(mazegrid);

		stage.setTitle("MazeApplication");
		stage.setScene(scene);
		stage.show();
	}

	public void updateGrid()
	{
		List<List<Tile>> tiles = routefinder.getMaze().getTiles();

		for (int i = 0; i < tiles.size(); i++)
		{

			for (int k = 0; k < tiles.get(i).size(); k++)
			{
				Tile tile = tiles.get(i).get(k);
				Color color = null;

				if (routefinder.getRoute().contains(tile))
				{
					color = Color.BLUE;
				}
				else
				{
					switch (tile.getType())
					{
						case ENTRANCE:
							color = Color.BLUE;
							break;

						case EXIT:
							color = Color.RED;
							break;

						case CORRIDOR:
							color = Color.GREEN;
							break;

						case WALL:
							color = Color.BLACK;
							break;

						default:
					}
				}

				mazegrid.add(new Rectangle(25, 25, color), k, i);
			}
		}
	}

}
