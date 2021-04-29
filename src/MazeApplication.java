import maze.*;
import maze.routing.*;
import maze.visualisation.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene; 
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox; 
import javafx.stage.Stage; 
import javafx.stage.FileChooser;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;

/** The MazeApplication class is a JavaFX application.
 *  Allows the user to specify a text file containing a maze representation.
 *  The graphical representation of the maze is displayed to the user.
 *  The user will be able to:
 *  (i) Step through the solving process with the visualisation updating to the current state.
 *  (ii) Save the current route-solving state to a file.
 *  (iii) Load route-solving state froma file.
 *  @author Sam Zhen
 *  @version 29th April 2021
 */
public class MazeApplication extends Application 
{
	private RouteFinderGrid grid;

	/** Launches a standalone application
	 *  @param args the command line arguments
	 */
	public static void main(String[] args) 
	{
		launch(args);
	}

	/** The entry point of the application.
	 *  A 600x600 scene is prepared 
	 *  A HBox of 4 buttons is prepared and added to the scene
	 *  A RouteFinderGrid is prepared and added to the scene
	 *  The stage is prepared and the scene is added to the stage
	 *  The stage is displayed
	 *  @param stage: The stage of the application, onto which the application scene is set.
	 */
	@Override
	public void start(Stage stage) 
	{
		BorderPane border = new BorderPane();

		Scene scene = new Scene(border, 600, 600);

		Button loadmaze = new Button("Load Maze");
		Button loadroute = new Button("Load Route");
		Button saveroute = new Button("Save Route");
		Button step = new Button("Step");

		Alert a = new Alert(AlertType.NONE);

		loadmaze.setOnAction(e ->
		{
			FileChooser filechooser = new FileChooser();
			filechooser.setTitle("Open Maze Text File");
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            filechooser.getExtensionFilters().add(extFilter);

			File file = filechooser.showOpenDialog(stage);
			try
			{
				Maze maze = Maze.fromTxt(file.getAbsolutePath());
		    	RouteFinder routefinder = new RouteFinder(maze);
		    	grid = new RouteFinderGrid(routefinder);
		    	border.setCenter(grid);

			}
	    	catch(FileNotFoundException ex)
	    	{
	    		a.setAlertType(AlertType.INFORMATION);
	    		a.setContentText("File could not be found.");
	    		a.show();
	    	}
	    	catch(IOException ex)
	    	{
	    		a.setAlertType(AlertType.INFORMATION);
	    		a.setContentText("File could not be accessed.");
	    		a.show();
	    	}
	    	catch(InvalidMazeException ex)
	    	{
	    		a.setAlertType(AlertType.INFORMATION);
	    		a.setContentText("The maze is invalid.\n" + ex);
	    		a.show();
	    	}
	    	catch(NullPointerException ex)
	    	{
	    	}
		});

		loadroute.setOnAction(e ->
		{
			FileChooser filechooser = new FileChooser();
			filechooser.setTitle("Open Route File");
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("ROUTE files (*.route)", "*.route");
            filechooser.getExtensionFilters().add(extFilter);

			File file = filechooser.showOpenDialog(stage);
			try
			{
				RouteFinder routefinder = RouteFinder.load(file.getAbsolutePath());
		    	grid = new RouteFinderGrid(routefinder);
		    	border.setCenter(grid);

			}
	    	catch(IOException ex)
	    	{
	    		a.setAlertType(AlertType.INFORMATION);
	    		a.setContentText("File could not be deserialized.");
	    		a.show();
	    	}
	    	catch(ClassNotFoundException ex)
	    	{
	    		a.setAlertType(AlertType.INFORMATION);
	    		a.setContentText("File could not be deserialized.");
	    		a.show();
	    	}
	    	catch(NullPointerException ex)
	    	{
	    	}
		});

		saveroute.setOnAction(e ->
		{

			if (grid != null)
			{
				FileChooser filechooser = new FileChooser();
				filechooser.setTitle("Save Route");
	            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("ROUTE files (*.route)", "*.route");
	            filechooser.getExtensionFilters().add(extFilter);

				File file = filechooser.showSaveDialog(stage);
				try
				{
					grid.getRouteFinder().save(file.getAbsolutePath());
				}
		    	catch(IOException ex)
		    	{
		    		a.setAlertType(AlertType.INFORMATION);
		    		a.setContentText("File could not be saved.");
		    		a.show();
		    	}
		    	catch(NullPointerException ex)
		    	{

		    	}
		    }
		    else
		    {
	    		a.setAlertType(AlertType.INFORMATION);
	    		a.setContentText("No route to save.");
	    		a.show();
		    }
		});

		step.setOnAction(e ->
		{
			try
			{
				if(grid.step())
				{
		    		a.setAlertType(AlertType.INFORMATION);
		    		a.setContentText("Route finished.");
		    		a.show();
				}
			}
			catch(NoRouteFoundException ex)
			{
	    		a.setAlertType(AlertType.INFORMATION);
	    		a.setContentText("No route found.");
	    		a.show();
			}

			
		});

		HBox hbox = new HBox(loadmaze, loadroute, saveroute, step);
		hbox.setPadding(new Insets(0, 10, 15, 10));
		hbox.setSpacing(10);

		grid = new RouteFinderGrid();
		grid.setPadding(new Insets(0, 10, 10, 10));

		border.setTop(hbox);
		border.setCenter(grid);

		stage.setTitle("MazeApplication");
		stage.setScene(scene);
		stage.show();
	}

}
