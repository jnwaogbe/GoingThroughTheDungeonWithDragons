/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dragondungeongame;

import java.util.LinkedList;

public class PathFinder {

    Maze maze;

    public PathFinder(Maze iMaze) {
        maze = iMaze;
    }

    public boolean findPath(int r, int c, int dir, LinkedList<Coordinate> path) {

        boolean exit = false;
        
        if (maze.isExit(r, c)) {
            return true;
        } else {
            if (dir != 1 && !maze.hasNorthWall(r, c) && !exit) {
                exit = findPath(r - 1, c, 2, path);
            }
            
            if (dir != 2 && !maze.hasSouthWall(r, c) && !exit) {
                exit = findPath(r + 1, c, 1, path);
            }
            
            if (dir != 3 && !maze.hasEastWall(r, c) && !exit) {
                exit = findPath(r, c + 1, 4, path);
            }
            
            if (dir != 4 && !maze.hasWestWall(r, c) && !exit) {
                exit = findPath(r, c - 1, 3, path);
            }
            
            if (exit) {
                path.add(new Coordinate(r, c));
            }
            return exit;
        }
    }
    
    public LinkedList<Coordinate> findSolution (int startRow, int startColumn) {
        LinkedList<Coordinate> myPath = new LinkedList<Coordinate>();
        findPath(startRow, startColumn, 0, myPath);
        return myPath;
    }
        
}
        /*
        myPath.add(new Coordinate(startRow, startColumn));
        System.out.print("This cell has the following walls: ");
        if (maze.hasNorthWall(startRow, startColumn)) {
            System.out.print("North ");
        }
        if (maze.hasSouthWall(startRow, startColumn)) {
            System.out.print("South ");
        }
        if (maze.hasEastWall(startRow, startColumn)) {
            System.out.print("East ");
        }
        if (maze.hasWestWall(startRow, startColumn)) {
            System.out.print("West ");
        }
        System.out.println("");
        // end bogus code -----------------------
*/
        
      
