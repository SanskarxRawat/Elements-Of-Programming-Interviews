import java.util.List;

public class BuyAndSellStockOnce {


    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    public static double maxProfit(List<Double> prices) {

        double minPrice=Double.MAX_VALUE,maxProfit=0.0;


        for(Double price:prices) {
            minPrice=Math.min(minPrice,price);
            maxProfit=Math.max(maxProfit,price-minPrice);
        }
        return maxProfit;
    }
}
