class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        if (k >= prices.length / 2){
            int res = 0;
            for (int i = 1; i < prices.length; i++)
                res += Math.max(0, prices[i] - prices[i-1]);
            return res;
        }
        int []buy = new int[k+1];
        int []sell  =new int[k+1];
        Arrays.fill(buy, Integer.MIN_VALUE);
        for(int i = 0;i < prices.length; i++){
            for (int j = 0; j < k; j++) {
                buy[j+1] = Math.max(buy[j+1], sell[j] - prices[i]);
                sell[j+1] = Math.max(buy[j+1] + prices[i], sell[j+1]);
            }

        }
        return sell[k];
    }
}
/*
class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        if (k > prices.length){
            int res = 0;
            for (int i = 1; i < prices.length; i++)
                res += Math.max(0, prices[i] - prices[i-1]);
            return res;
        }
        int[] local = new int[k+1];
        int[] global = new int[k+1];
        for (int i = 0; i < prices.length - 1; i++) {
            int diff = prices[i+1] - prices[i];
            for (int j = k; j >= 1; j--){
                local[j] = Math.max(global[j-1] + (diff > 0 ? diff : 0), local[j] + diff);
                global[j] = Math.max(local[j], global[j]);
            }
        }
        return global[k];
    }
}
*/