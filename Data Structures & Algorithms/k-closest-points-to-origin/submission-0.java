class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq=new  PriorityQueue<Pair>();
        for(int[] list:points){
            Pair p=new Pair(list[0],list[1]);
            System.out.println(p.toString());
            pq.add(p);
            while(pq.size()>k){
                pq.poll();
            }
        }
        System.out.println(pq.toString());
        int[][] res=new int[k][2];
        int j=0;
        while(pq.size()>0){
            Pair p1=pq.poll();
            res[j][0]=p1.x_axix;
            res[j][1]=p1.y_axix;
            j++;
        }
        return res;
    }

    class Pair implements Comparable<Pair> {
        int x_axix;
        int y_axix;
        double z;
        Pair(int x,int y){
            this.x_axix=x;
            this.y_axix=y;
            this.z=Math.sqrt((x_axix*x_axix)+(y_axix*y_axix));
        }

         @Override
         public int compareTo(Pair otherPair) {
             return Double.compare(otherPair.z,this.z);
         }

         @Override
         public String toString() {
             return this.x_axix+" "+this.y_axix+" "+z;
         }
     }
}
