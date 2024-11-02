import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BuyAndSellStockTwice {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */

    public static double buyAndSellStockTwice(List<Double> prices) {

        double maxTotalProfit=0.0;

        double minPriceSoFar=Double.MAX_VALUE;

        List<Double> firstBuySellProfit=new ArrayList<>();

        for(Double price:prices) {
            maxTotalProfit=Math.max(maxTotalProfit,price-minPriceSoFar);
            minPriceSoFar=Math.min(minPriceSoFar,price);
            firstBuySellProfit.add(maxTotalProfit);
        }

        double maxPriceSoFar=Double.MIN_VALUE;

        for(int i=prices.size()-1;i>=0;i--) {
            maxPriceSoFar=Math.max(maxPriceSoFar,prices.get(i));
            maxTotalProfit=Math.max(maxTotalProfit,maxPriceSoFar-prices.get(i)+firstBuySellProfit.get(i-1));
        }
        return maxTotalProfit;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;

        int[][] curr = new int[3][2];
        int[][] next = new int[3][2];

        // Iterate from the last day to the first
        for (int i = n - 1; i >= 0; i--) {
            for (int k = 1; k <= 2; k++) {

                // Calculate for buy state
                curr[k][1] = Math.max(-prices[i] + next[k][0],
                        next[k][1]);

                // Calculate for sell state
                curr[k][0] = Math.max(prices[i] + next[k - 1][1],
                        next[k][0]);
            }

            // Move current state to next, for the
            // next iteration
            next = Arrays.copyOf(curr, curr.length);
        }

        // The result is the maximum profit starting
        // from day 0, with 2 transactions, and in
        // buy state = 1
        return curr[2][1];
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    static int maxProfitOptimized(int[] price) {

        // Variables to store the maximum profit after
        // the first and second transactions
        int firstBuy = Integer.MIN_VALUE;
        int firstSell = 0;
        int secondBuy = Integer.MIN_VALUE;
        int secondSell = 0;

        // Iterate over each day's stock price
        for (int p : price) {

            // Calculate maximum profit after first
            // buy (negative price to track spending)
            firstBuy = Math.max(firstBuy, -p);

            // Calculate maximum profit after first sell
            firstSell = Math.max(firstSell, firstBuy + p);

            // Calculate maximum profit after second buy
            secondBuy = Math.max(secondBuy, firstSell - p);

            // Calculate maximum profit after second sell
            secondSell = Math.max(secondSell, secondBuy + p);
        }

        // The result is the maximum profit after the second sell
        return secondSell;
    }
}
