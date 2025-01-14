import java.util.*;

public class EightQueens {

  private static int GRID_SIZE = 8;

  public static void main(String[] args) {
    Integer[] columns = new Integer[GRID_SIZE];
    ArrayList<Integer[]> results = new ArrayList<>();
    placeQueens(0, columns, results);
    printResults(results);
  }

  private static void printResults(ArrayList<Integer[]> results) {
    for (Integer[] solution : results) {
      printBoard(solution);
      System.out.println(); // Separate different solutions
    }
  }

  private static void printBoard(Integer[] columns) {
    for (int row = 0; row < GRID_SIZE; row++) {
      for (int col = 0; col < GRID_SIZE; col++) {
        if (columns[row] == col) {
          System.out.print("Q "); // Print 'Q' for a queen
        } else {
          System.out.print(". "); // Print '.' for an empty space
        }
      }
      System.out.println(); // Newline after each row
    }
  }

  private static void placeQueens(int row, Integer[] columns, ArrayList<Integer[]> results) {
    if (row == GRID_SIZE) {
      results.add(columns.clone()); // Found valid placement
    } else {
      for (int col = 0; col < GRID_SIZE; col++) {
        // Look into next row
        if (checkValid(columns, row, col)) {
          columns[row] = col; // Place Queen
          placeQueens(row + 1, columns, results);
        }
      }
    }
  }

  /*
   * Check if (rowl, column) is a valid spot for a queen by checking if there is a
   * queen in the same column or diagonal. We don't need to check it for
   * queens in the same row because the calling placeQueen only attempts to place one
   * queen at a time. We know this row is empty.
   */
  private static boolean checkValid(Integer[] columns, int row, int column) {
    for (int rowOld = 0; rowOld < row; rowOld++) {
      int columnOld = columns[rowOld];
      /* Check if (rowOld, columnsOld) invalidates (row, column) as a queen spot */

      /* Check if rows have a queen in the same column */
      if (column == columnOld) {
        return false;
      }

      /*
       * Check diagonals: if the distance between the columns equals the distance
       * between the rows, then they're in the same diagonal.
       */
      int columnDistance = Math.abs(columnOld - column);

      /* row > rowOld, so no need for abs */
      int rowDistance = row - rowOld;
      if (columnDistance == rowDistance) {
        return false;
      }
    }
    return true;
  }
}
