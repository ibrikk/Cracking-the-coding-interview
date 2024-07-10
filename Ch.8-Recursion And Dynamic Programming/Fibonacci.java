public static void main(String[] args) {
    int result = fibonacci(5);
    System.out.println(result);

    int optResult = optFib(5);
    System.out.println(optResult);

    int result2 = fib2(5);
    System.out.println(result2);

    int optResult2 = optFib2(5);
    System.out.println(optResult2);
}

private static int fibonacci(int n) {
    if (n == 0)
        return 0;
    if (n == 1)
        return 1;
    return fibonacci(n - 1) + fibonacci(n - 2);
}

// Optimized with Memoizaion (Top-Down approach)
private static int optFib(int n) {
    return optFib(n, new int[n + 1]);
}

private static int optFib(int n, int[] memo) {
    if (n == 0 || n == 1) {
        return n;
    }

    if (memo[n] == 0) {
        memo[n] = optFib(n - 1, memo) + optFib(n - 2, memo);
    }
    return memo[n];
}

// Bottom-Up Dynamic Programming

private static int fib2(int n) {
    if (n == 0) {
        return 0;
    } else if (n == 1) {
        return 1;
    }

    int[] memo = new int[n];
    memo[0] = 0;
    memo[1] = 1;
    for (int i = 2; i < n; i++) {
        memo[i] = memo[i - 1] + memo[i - 2];
    }
    return memo[n - 1] + memo[n - 2];
}

// More optimized version of Bottom-Up Dynamic Programming
private static int optFib2(int n) {
    if (n == 0) {
        return 0;
    }
    int a = 0;
    int b = 1;
    for (int i = 2; i < n; i++) {
        int c = a + b;
        a = b;
        b = c;
    }
    return a + b;
}