class Solution {
    public int findMin(int[] nums) {
        int l=0,r=nums.length-1;
        int min=Integer.MAX_VALUE,min_index=-1;
        while(l<=r){
            int mid=(l+r)/2;
            System.out.println(mid);
            if(nums[mid] > nums[r]){
                l=mid+1;
            }
            else {
                if(nums[mid]<=min){
                    min=nums[mid];
                    min_index=mid;
                }
                r=mid-1;
            }
        }
        return min;
    }
}
