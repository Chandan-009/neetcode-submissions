class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int r=Integer.MIN_VALUE;
        int l=1;
        for(int i:piles){
            r=Math.max(r,i);
        }
        int minNumberOfHours=Integer.MIN_VALUE;
        int minRate=0;
        while(l<=r){
            int mid=(l+r)/2;
            int noOfHours=calNoOfHours(piles,mid);   
            if(noOfHours > h){
                l=mid+1;
            }
            else{
                if(noOfHours >= minNumberOfHours){
                    minNumberOfHours=noOfHours;
                    minRate=mid;
                }
                r=mid-1;
            }
        }
        return minRate;
    }

    public int calNoOfHours(int[] piles, int rate){
        int totalHours=0;
        for(int i: piles) {
            int curHours=((i%rate)==0) ? (i/rate) : (i/rate)+1;
            totalHours=totalHours+curHours;
        }
        return totalHours;
    }
}
