class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            int target =nums[i];
            int skipIndex=i;
            int startIndex=i+1;
            Set<List<Integer>> twoSum=twoSum(target,nums,skipIndex,startIndex);
            if(twoSum.size()!=0) {
                result.addAll(twoSum);
            }
        }
        return new ArrayList<>(result);
    }

    public static Set<List<Integer>> twoSum(int target, int[] nums, int skipIndex, int startIndex) {
        int i=startIndex,j=nums.length-1;
        Set<List<Integer>> result=new HashSet<>();
        while(i<j) {
            if(i==skipIndex) {
                i++;
                continue;
            }
               
            if(j==skipIndex) {
                 j--;
                 continue;
            }
            int sum=nums[i]+nums[j]+target;
            if(sum==0){
                List<Integer> r=new ArrayList<>();
                r.add(nums[i]);
                r.add(nums[j]);
                r.add(target);
                result.add(r);
                i++;
                j--;
            }
            if(sum>0){
                j--;
            }
            if(sum<0)
              i++;
        }
        return result;
    }
}
