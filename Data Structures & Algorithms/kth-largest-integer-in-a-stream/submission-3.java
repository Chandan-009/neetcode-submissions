class KthLargest {
    static PriorityQueue<Integer> pq;
    static int k;

    public KthLargest(int k, int[] nums) {
         pq = new PriorityQueue<>();
         this.k=k;
         for(int i:nums){
            addElement(pq,i);
         }
    }
    
    public int add(int val) {
        return addElement(pq,val);
    }

    //O(Log(k))
    public static int addElement(PriorityQueue<Integer> pq,int val){
            pq.add(val);
            while(pq.size()>k){
                pq.poll();
            }
            return pq.peek();
    }
}
