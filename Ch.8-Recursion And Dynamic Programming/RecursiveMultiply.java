public class RecursiveMultiply {
  public static void main(String[] args) {
    int result = minProducts(5, 3);
    System.out.println(result);

    int result2 = memoMinProduct(5, 3);
    System.out.println(result2);

    int result3 = minProduct(5, 3);
    System.out.println(result3);
  }

  private static int minProducts(int a, int b) {
    int bigger = a > b ? a : b;
    int smaller = a < b ? a : b;
    return minProductHelper(smaller, bigger);
  }

  private static int minProductHelper(int smaller, int bigger) {
    if (smaller == 0) {
      return 0;
    } else if (smaller == 1) {
      return bigger;
    }

    // Compute half. If uneven, compute other half. If evn, double it.
    int s = smaller >> 1; // Divide by 2
    int side1 = minProducts(s, bigger);
    int side2 = side1;

    if (smaller % 2 == 1) {
      side2 = minProductHelper(smaller - s, bigger);
    }

    return side1 + side2;
  }

  private static int memoMinProduct(int a, int b) {
    int bigger = a > b ? a : b;
    int smaller = a < b ? a : b;

    int[] memo = new int[smaller + 1];
    return memoMinProduct(smaller, bigger, memo);
  }

  private static int memoMinProduct(int smaller, int bigger, int[] memo) {
    if (smaller == 0) {
      return 0;
    } else if (smaller == 1) {
      return bigger;
    } else if (memo[smaller] > 0) {
      return memo[smaller];
    }

    int s = smaller >> 1; // Divide by 2
    int side1 = memoMinProduct(s, bigger, memo);
    int side2 = side1;

    if (smaller % 2 == 1) {
      side2 = memoMinProduct(smaller - s, bigger, memo);
    }

    memo[smaller] = side1 + side2;
    return memo[smaller];
  }

  /// Even more optimized

  private static int minProduct(int a, int b) {
    int bigger = a > b ? a : b;
    int smaller = a < b ? a : b;

    return minProductHelper2(smaller, bigger);
  }

  private static int minProductHelper2(int smaller, int bigger) {
    if (smaller == 0) return 0;
    else if (smaller == 1) return bigger;

    int s = smaller >> 1;
    int halfProd = minProductHelper2(s, bigger);

    if (smaller % 2 == 0) {
      return halfProd + halfProd;
    } else {
      return halfProd + halfProd + bigger;
    }
  }
}
