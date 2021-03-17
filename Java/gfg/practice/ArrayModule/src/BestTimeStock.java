public class BestTimeStock {

    public static int maxProfit(int[] prices) {
        int minSoFar = prices[0], max = 0;

        for(int i = 0; i < prices.length; i++) {
            minSoFar = Math.min(prices[i], minSoFar);
            int profit = prices[i] - minSoFar;
            max = Math.max(profit, max);
        }

        return max;
    }

    public static int maxProfitBrute(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        int n = prices.length;
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                int profit = prices[j] - prices[i];
                maxProfit = Math.max(profit, maxProfit);
            }
        }
        return maxProfit;
    }

    public static int maxProfitSpace(int[] prices) {
        int n = prices.length;
        int[] temp = new int[n];
        temp[n-1] = prices[n-1];
        for(int i = n-2; i >= 0; i--) {
            temp[i] = Math.max(prices[i], temp[i+1]);
        }
        int maxProfit = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            int profit = temp[i] - prices[i];
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};

        System.out.println(maxProfit(prices));
        System.out.println(maxProfitBrute(prices));
        System.out.println(maxProfitSpace(prices));
    }
}
