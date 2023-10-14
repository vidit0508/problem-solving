package src.main.java.topicwise.recursive;

public class CoinChangeRecursively {

    public static void main(String[] args) {
        int[] coins = {2, 5, 3, 1};
        int len = coins.length;
        int sum = 5;
        System.out.println(countPossibleCoinChange(coins, len, sum));
    }

    private static int countPossibleCoinChange(int[] coins, int len, int sum) {
        if (sum == 0) {
            return 1;
        }
        if (sum < 0) {
            return 0;
        }

        if (len == 0) {
            return 0;
        }

        return countPossibleCoinChange(coins, len, sum - coins[len - 1])
                + countPossibleCoinChange(coins, len - 1, sum);
    }
}
