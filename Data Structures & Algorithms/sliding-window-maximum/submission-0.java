class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> heap=new PriorityQueue<>((a,b)->b-a);
        int i=0;
        int max_element=Integer.MIN_VALUE;
        while(i<k){
            heap.add(nums[i]);
            i++;
        }
        List<Integer> res=new ArrayList<>();
        res.add(heap.peek());
        for(int j=k;j<nums.length;j++){
           heap.remove(nums[j-k]);
           heap.add(nums[j]);
           res.add(heap.peek());
        }
        int[] result=new int[res.size()];
        for(int m=0;m<res.size();m++){
            result[m]=res.get(m);
        }
        return result;

        
    }
}
