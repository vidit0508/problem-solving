package src.main.java.top.onefifty.medium.arraystrings;

public class BestTimeToBuyAndSellStockII {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minIndex = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[minIndex]) {
                minIndex = i;
            } else {
                maxProfit = maxProfit + (prices[i] - prices[minIndex]);
                minIndex = i;
            }
        }
        return maxProfit;
    }
}
