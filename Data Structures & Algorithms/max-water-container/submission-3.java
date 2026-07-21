class Solution {
    public int maxArea(int[] heights) {

        int i=0,j=heights.length-1;
        int max=0;
        while(i<=j){
            int min=Math.min(heights[i],heights[j]);
           // System.out.println(min);
            max=Math.max(max,(j-i)*min);
          //  System.out.println("max :"+max);
            if(heights[i]<heights[j]){
                i++;
            }
            else{
                j--;
            }
            
           // System.out.println(i+" "+j);
        }
        return max;
    }
}
