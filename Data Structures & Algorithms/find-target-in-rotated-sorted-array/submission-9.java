class Solution {
    public int search(int[] nums, int target) {
        int l=0,h=nums.length-1;
        int min_index=findMinIndex(nums);
        if(target>=nums[min_index] && target<=nums[h]){
            l=min_index;
        }
        else {
            h=min_index-1;
        }
        int ans=-1;
         while(l<=h){
            int mid=(l+h)/2;
            if(nums[mid] == target){
                ans=mid;
                break;
            }
            else if(target> nums[mid]){
                l=mid+1;
            }
            else {
                h=mid-1;
            }
        }
        return ans;
        
    }

    public int findMinIndex(int[] nums){
        int l=0,h=nums.length-1;
        int min=Integer.MAX_VALUE,min_index=-1;
        while(l<=h){
            int mid=(l+h)/2;
            if(nums[mid] > nums[h]){
                l=mid+1;
            }
            else {
                if(min>=nums[mid]){
                    min=nums[mid];
                    min_index=mid;
                }
                h=mid-1;
            }
        }
        return min_index;
    }
}
