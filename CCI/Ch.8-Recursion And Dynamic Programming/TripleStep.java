import java.util.Arrays;

public class TripleStep {
    public static void main(String[] args) {
        int result = countWays(5);
        System.out.println(result);

        int result2 = memoizedCountWays(5);
        System.out.println(result2);

    }

    private static int countWays(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else {
            return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
        }
    }

    private static int memoizedCountWays(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return memoizedCountWays(n, memo);
    }

    private static int memoizedCountWays(int n, int[] memo) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else if (memo[n] > -1) {
            return memo[n];
        } else {
            memo[n] = memoizedCountWays(n - 1, memo) + memoizedCountWays(n - 2, memo) + memoizedCountWays(n - 3, memo);
            return memo[n];
        }
    }
}
