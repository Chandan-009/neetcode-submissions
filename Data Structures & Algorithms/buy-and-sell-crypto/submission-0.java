class Solution {
    public int maxProfit(int[] prices) {

        int leftMostMinElement=prices[0];
        int maxSum=0;
        for(int i=0;i<prices.length;i++) {
            if(leftMostMinElement< prices[i]){
                maxSum=Math.max(maxSum,prices[i]-leftMostMinElement);
            }
            if(leftMostMinElement > prices[i]) {
                leftMostMinElement=prices[i];
            }
        }

        return maxSum;
        
    }
}
