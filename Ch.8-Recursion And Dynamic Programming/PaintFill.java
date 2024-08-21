public class PaintFill {
  public static void main(String[] args) {
    Color[][] screen = {
        { Color.Red, Color.Red, Color.Red, Color.Red, Color.Red },
        { Color.Red, Color.White, Color.White, Color.White, Color.Red },
        { Color.Red, Color.White, Color.Black, Color.White, Color.Red },
        { Color.Red, Color.White, Color.White, Color.White, Color.Red },
        { Color.Red, Color.Red, Color.Red, Color.Red, Color.Red }
    };

    paintFill(screen, 2, 2, Color.Yellow);
    
    for (int i = 0; i < screen.length; i++) {
      for (int j = 0; j < screen[i].length; j++) {
        System.out.print(screen[i][j] + " ");
      }
      System.out.println();
    }
  }

  enum Color {
    Black, White, Red, Yellow, Green
  }

  private static boolean paintFill(Color[][] screen, int r, int c, Color ncolor) {
    if (screen[r][c] == ncolor)
      return false;
    return paintFill(screen, r, c, screen[r][c], ncolor);
  }

  private static boolean paintFill(Color[][] screen, int r, int c, Color ocolor, Color ncolor) {
    if (r < 0 || r >= screen.length || c < 0 || c >= screen[0].length) {
      return false;
    }

    if (screen[r][c] == ocolor) {
      screen[r][c] = ncolor;
      paintFill(screen, r - 1, c, ocolor, ncolor); // up
      paintFill(screen, r + 1, c, ocolor, ncolor); // down
      paintFill(screen, r, c - 1, ocolor, ncolor); // left
      paintFill(screen, r, c + 1, ocolor, ncolor); // right
    }
    return true;
  }
}
