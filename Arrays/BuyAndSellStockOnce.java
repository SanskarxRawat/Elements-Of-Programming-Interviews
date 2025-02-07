import java.util.List;

public class BuyAndSellStockOnce {


    /**
     * Intuition:
     * - To maximize profit, we need to buy at the lowest price and sell at the highest price
     * after the buying day.
     * - As we iterate through the list of prices:
     * - We keep track of the minimum price encountered so far.
     * - For each price, we calculate the profit if we were to sell the stock at that price,
     * and update the maximum profit if this profit is greater than the previous maximum.
     * - This approach ensures that we only check for profitable transactions in a single pass,
     * making it efficient.
     * <p>
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    public static double maxProfit(List<Double> prices) {

        double minPrice = Double.MAX_VALUE, maxProfit = 0.0;


        for (Double price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }
}
