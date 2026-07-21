class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> leftSet=new HashSet<>();
        Set<Integer> startSet=new HashSet<>();
        for(int i: nums){
            leftSet.add(i);
        }
        for(int i: nums){
            if(!leftSet.contains(i-1)){
                startSet.add(i);
            }
        }


        int maxCount=0;

        for(int i: startSet){
            int currentCount=1;
            while(leftSet.contains(i+1)){
                currentCount++;
                i++;
            }
            maxCount=Math.max(maxCount,currentCount);
        }
        
        return maxCount;

    }


    // calculating sequence count of each start 
    public static int countSquence(int[] nums, int startIndex, int startElement){
        int count=0;
        System.out.println(startElement+" "+startIndex);
        for(int i=startIndex;i<nums.length;i++){
            System.out.println(startElement+" "+nums[i]+" "+count);
            if(startElement==nums[i]){
                count++;
            }
            if (startElement+1==nums[i]){
                startElement++;
                count++;
            }

        }
        System.out.println(" "+count);
        return count;

    }
}
