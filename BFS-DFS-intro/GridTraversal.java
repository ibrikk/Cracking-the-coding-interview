import java.util.*;

public class GridTraversal {

  private static int ROWS = 3;
  private static int COLS = 3;

  // Directions: up, down, left, right
  private static final int[] rowDirections = { -1, 1, 0, 0 };
  private static final int[] colDirections = { 0, 0, -1, 1 };

  public static void main(String[] args) {
    int[][] grid = {
        { 1, 2, 3 },
        { 4, 5, 6 },
        { 7, 8, 9 },
    };

    bfs(grid, 0, 0);

    System.out.println();

    boolean[][] visited = new boolean[ROWS][COLS];
    
    dfs(grid, 0, 0, visited);
  }

  private static void bfs(int[][] grid, int startRow, int startCol) {
    boolean[][] visited = new boolean[ROWS][COLS];
    Queue<int[]> queue = new LinkedList<>();

    visited[startRow][startCol] = true;
    int[] enqueue = new int[] { startRow, startCol };
    queue.offer(enqueue);

    while (!queue.isEmpty()) {
      int[] cell = queue.poll();
      int row = cell[0];
      int col = cell[1];

      System.out.print(grid[row][col] + " ");

      for (int i = 0; i < 4; i++) {
        int newRow = row + rowDirections[i];
        int newCol = col + colDirections[i];

        if (isValid(newRow, newCol, visited)) {
          visited[newRow][newCol] = true;
          queue.offer(new int[] { newRow, newCol });
        }
      }
    }
  }

  private static void dfs(int[][] grid, int row, int col, boolean[][] visited) {
    visited[row][col] = true;
    System.out.print(grid[row][col] + " ");

    for (int i = 0; i < 4; i++) {
      int newRow = row + rowDirections[i];
      int newCol = col + colDirections[i];

      if (isValid(newRow, newCol, visited)) {
        dfs(grid, newRow, newCol, visited);
      }
    }
  }

  private static boolean isValid(int row, int col, boolean[][] visited) {
    return (row >= 0 && row < ROWS) && (col >= 0 && col < COLS) && !visited[row][col];
  }
}
