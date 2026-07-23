class Solution {
    public int trap(int[] height) {
        int[] right_most_heights=new int[height.length];
        int max_height_right=-1;
        for(int i=height.length-1;i>=0;i--){
            max_height_right=Math.max(max_height_right,height[i]);
            right_most_heights[i]=max_height_right;
           // System.out.print(max_height_right+" ");
        }
        
        int left_most_height=-1;
        int sum=0,res=-1;
        for(int i=0;i<height.length;i++){
            left_most_height=Math.max(left_most_height,height[i]);
            int right_most_height=right_most_heights[i];
            int cur_sum=Math.min(left_most_height,right_most_height)-height[i];
           // System.out.println(left_most_height+" "+cur_sum+" "+right_most_height);
            
            sum=sum+cur_sum;
            //res=Math.max(sum,res);
        }
        return sum;
    }
}
