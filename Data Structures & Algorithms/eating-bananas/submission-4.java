class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int r=Integer.MIN_VALUE;
        int l=1;
        for(int i:piles){
            r=Math.max(r,i);
        }
        int result=Integer.MIN_VALUE;
        int res=0;
        while(l<=r){
            int mid=(l+r)/2;
            System.out.println("low high mid :"+l+" "+r+" "+mid);
            int hours=noOfHours(piles,mid);
            //System.out.println("low+high "+l+" "+r);
            System.out.println("caLhours  result :"+hours+" "+result);
            
            if (hours > h){
                l=mid+1;
            }
            else {
                if(hours >= result){
                    result=hours;
                    res=mid;
                }
                r=mid-1;
            }
            
        }
        return res;
    }

    public int noOfHours(int[] piles, int rate){
        int sum=0;
        for(int i: piles) {
           // System.out.println("rate :"+rate);
         if((i%rate)==0)
            sum=sum+(i/rate);
        else
            sum=sum+(i/rate)+1;
        }
        return sum;
    }
}
