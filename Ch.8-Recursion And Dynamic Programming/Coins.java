public class Coins {
  public static void main(String[] args) {
    int result = makeChange(100);
    System.out.println(result);

    int result2 = makeChangeOpt(10);
    System.out.println(result2);
  }

  private static int makeChange(int amount, int[] denoms, int index) {
    if (index >= denoms.length - 1)
      return 1; // last denom
    int denomAmount = denoms[index];
    int ways = 0;
    for (int i = 0; i * denomAmount <= amount; i++) {
      int amountRemaining = amount - i * denomAmount;
      ways += makeChange(amountRemaining, denoms, index + 1);
    }
    return ways;
  }

  private static int makeChange(int n) {
    int[] denoms = { 25, 10, 5, 1 };
    return makeChange(n, denoms, 0);
  }

  private static int makeChangeOpt(int n) {
    int[] denoms = { 25, 10, 5, 1 };
    int[][] map = new int[n + 1][denoms.length]; // precomputed vals
    return makeChangeOpt(n, denoms, 0, map);
  }

  private static int makeChangeOpt(int amount, int[] denoms, int index, int[][] map) {
    if (map[amount][index] > 0) {
      return map[amount][index]; // retrieve value
    }
    if (index >= denoms.length - 1)
      return 1; // one denom remaining
    int denomAmount = denoms[index];
    int ways = 0;
    for (int i = 0; i * denomAmount <= amount; i++) {
      // go to next denom, assuming i coins of denomAmount
      int amountRemaining = amount - i * denomAmount;
      ways += makeChangeOpt(amountRemaining, denoms, index + 1, map);
    }
    map[amount][index] = ways;
    return ways;
  }
}
