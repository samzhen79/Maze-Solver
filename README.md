# Maze Solver
This is a simple maze solving application that goes through a step by step process accompanied by a visualisation of the maze and route.

![image](https://user-images.githubusercontent.com/75619220/159155589-d3f7f132-72cb-4401-9a78-f5f6f1009361.png)

## General Information
This application uses a stack and a brute force approach to solving the mazes. The route finder will always go left first and then if met with a dead end will return to the last junction and try a different clockwise direction.

The application reads a displays the maze from a text input.

![image](https://user-images.githubusercontent.com/75619220/159155864-059f804a-c11b-4879-93a2-af899192d8e4.png)

Symbol meaning:
* "#" : Wall
* "." : Corridor
* "e" : Entrance
* "x" : Exit

The application can also save/load a route.

## Usage

Use `javac.bat` to compile and `java.bat` to run the application on Windows.

```
$ ./javac.bat src/MazeApplication.java  
$ ./java.bat MazeApplication
```
To use the application you must first load a maze or route, some example maze/routes can be found in the resources folder. When a suitable maze/route has been loaded the step button will allow you to step through the route finder and you will be able to see the a solution being formed step by step.

Save Route will allow you to save the current state of the route along with the maze.

There are tests available to check proper functionality of the maze solver which can be run using `run_tests.bat`.

## Documentation
You can find the JavaDoc for the code here https://samzhen79.github.io/Maze-Solver/javadoc/
