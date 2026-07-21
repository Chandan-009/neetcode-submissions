class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i:stones){
            pq.add(i);
        }
        while(pq.size()>1){
            int ele1=pq.poll();
            int ele2=pq.poll();
            int res=(ele1>ele2)? ele1-ele2:ele2-ele1;
            pq.add(res);
        }
        return pq.peek();
    }
}
