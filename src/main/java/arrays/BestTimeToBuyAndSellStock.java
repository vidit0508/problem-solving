package src.main.java.arrays;

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        System.out.println(maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {
        int minIndex = 0;
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[minIndex] >= prices[i]) {
                minIndex = i;
            } else if (prices[minIndex] < prices[i]) {
                maxProfit = Math.max(maxProfit, prices[i] - prices[minIndex]);
            }
        }
        return maxProfit;
    }
}
