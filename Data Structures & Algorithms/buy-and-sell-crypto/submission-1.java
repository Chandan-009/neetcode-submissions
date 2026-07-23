class Solution {
    public int maxProfit(int[] prices) {
        int max_integer=Integer.MIN_VALUE;
        int res=Integer.MIN_VALUE;
        for(int i=prices.length-1;i>=0;i--){
            max_integer=Math.max(max_integer,prices[i]);
            res=Math.max(max_integer-prices[i],res);
        }
        return res;
    }
}
