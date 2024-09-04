import java.util.ArrayList;
import java.util.HashSet;

class Point {
  int x;
  int y;

  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

public class RobotInAGrid {
  public static void main(String[] args) {
    boolean[][] maze = {
        { true, true, true, true },
        { true, false, true, true },
        { true, true, false, true },
        { false, true, true, true }
    };

    RobotInAGrid robot = new RobotInAGrid();
    ArrayList<Point> path = robot.getPath(maze);

    if (path != null) {
      System.out.println("Path found:");
      for (Point p : path) {
        System.out.println("(" + p.x + ", " + p.y + ")");
      }
    } else {
      System.out.println("No path found.");
    }
  }

  private ArrayList<Point> getPath(boolean[][] maze) {
    if (maze == null || maze.length == 0) {
      return null;
    }
    ArrayList<Point> path = new ArrayList<Point>();
    if (getPath(maze, maze.length - 1, maze[0].length - 1, path)) {
      return path;
    }
    return null;
  }

  boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path) {
    if (col < 0 || row < 0 || !maze[row][col]) {
      return false;
    }

    boolean isAtOrigin = (row == 0) && (col == 0);

    if (isAtOrigin || getPath(maze, row, col - 1, path) || getPath(maze, row - 1, col, path)) {
      Point p = new Point(row, col);
      path.add(p);
      return true;
    }
    return false;
  }

  /////// OPTIMIZED WITH MEOIZATION

  ArrayList<Point> getPathOptimized(boolean[][] maze) {
    if (maze == null || maze.length == 0) {
      return null;
    }
    ArrayList<Point> path = new ArrayList<>();
    HashSet<Point> failedPoints = new HashSet<>();
    if (getPathOptimized(maze, maze.length - 1, maze[0].length - 1, path, failedPoints)) {
      return path;
    }
    return null;
  }

  boolean getPathOptimized(boolean[][] maze, int row, int col, ArrayList<Point> path, HashSet<Point> failedPoints) {
    // If out of bounds, return false
    if (col < 0 || row < 0 || !maze[row][col]) {
      return false;
    }
    Point p = new Point(row, col);

    // If we have already visited this cell, return
    if (failedPoints.contains(p)) {
      return false;
    }

    boolean isAtOrigin = row == 0 && col == 0;

    // If there is a path from start location to my current location, add my
    // location

    if (isAtOrigin || getPathOptimized(maze, row, col - 1, path, failedPoints)
        || getPathOptimized(maze, row - 1, col, path, failedPoints)) {
      path.add(p);
      return true;
    }

    failedPoints.add(p); // Cache result
    return false;
  }

}
