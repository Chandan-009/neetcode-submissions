class Solution {
    public int[] twoSum(int[] nums, int target) {
        Set<Integer> set=new HashSet<>();
        int endIndex=0,find=0;
        int[] result=new int[2];
        for(int i=0;i<nums.length;i++) {
            if(set.contains(target-nums[i])){
                find=target-nums[i];
                endIndex=i;
                break;
            }
            else{
                set.add(nums[i]);
            }
        }
        for(int i=0;i<nums.length;i++) {
            if(find==nums[i]){
                result[0]=i;
                result[1]=endIndex;
                return result; 
            }
        }
        return result;
    }
}
