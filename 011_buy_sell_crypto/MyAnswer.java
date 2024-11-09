    
public class MyAnswer {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int l = 0; int r = 1;
        while (r < prices.length) {
            if (prices[l] > prices[r]) {
                l = r;
            } else {
                maxProfit = Math.max(prices[r] - prices[l], maxProfit);
            }
            r++;
        }

        return maxProfit;
    }

}
