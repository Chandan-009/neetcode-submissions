class Solution {
    public int[] productExceptSelf(int[] nums) {
        int r=1;
        int[] result=new int[nums.length];
        int count=0;
        for(int i:nums) {
            if(i==0){
                count++;
            }
            else{
                r=r*i;
            }
            if(count>1){
               return result;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(count>0){
                if(nums[i]==0){
                    result[i]=r;
                }
            }
            else{
                result[i]=r/nums[i];
            }
        }
        return result;

    }
}  
