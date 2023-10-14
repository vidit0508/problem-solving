package src.main.java.topicwise.dp;

public class FibonacciMemoization {

    static int[] dp = null;
    public static void main(String[] args) {
        int n = 5;
        dp = new int[n + 1];
        System.out.println(fibonacci(n));
    }

    private static int fibonacci(int n) {

        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }

        if (dp[n] == -1) {
            if (n <= 1) {
                return n;
            } else {
                dp[n] = fibonacci(n - 1) + fibonacci(n - 2);
            }
        }
        return dp[n];
    }
}
