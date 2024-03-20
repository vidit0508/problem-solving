package src.main.java.topicwise.recursive;

public class MinimumCoinsNeededForChange {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount < 0) {
            return 0;
        }
        return coinChange(coins, amount, new int[amount]);
    }

    private static int coinChange(int[] coins, int rem, int[] dp) {
        if (rem < 0) {
            return -1;
        }

        if (rem == 0) {
            return 0;
        }

        if (dp[rem - 1] != 0) {
            return dp[rem - 1];
        }

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, dp);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        dp[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return dp[rem - 1];
    }
}
