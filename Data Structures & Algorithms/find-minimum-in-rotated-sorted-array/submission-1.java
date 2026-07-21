class Solution {
    public int findMin(int[] nums) {
        int l=0,r=nums.length-1;
        int min=Integer.MAX_VALUE;
        while(l<=r){
            int mid=(l+r)/2;
            if(nums[mid]>=nums[l] && nums[mid]>=nums[r]){
                l=mid+1;
            }
            else {
                r=mid-1;
            }            
            min=Math.min(min,nums[mid]);
            }
    return min;
    }
}
