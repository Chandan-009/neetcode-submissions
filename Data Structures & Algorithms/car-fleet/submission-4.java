class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        if(position.length==1)
             return 1;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<position.length;i++) {
            map.put(position[i],speed[i]);
        }
        Arrays.sort(position);
        int feet=1;
        double preCarTime = (double)(target-position[position.length-1])/map.get(position[position.length-1]);
        for(int j=position.length-2;j>=0;j--){
            double curCarTime = (double)(target-position[j])/map.get(position[j]);
            System.out.println(position[j]+" "+map.get(position[j])+" "+curCarTime+" "+preCarTime);
            if(curCarTime>preCarTime) {
                preCarTime=curCarTime;
                feet++;
            }
               
        }
        return feet;
        
    }
}
