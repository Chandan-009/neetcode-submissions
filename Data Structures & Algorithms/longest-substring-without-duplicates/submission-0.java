class Solution {
    public int lengthOfLongestSubstring(String s) {

        Set<Character> set=new HashSet<>();
        int i=0,j=0,max=0;;
        for(char c:s.toCharArray()) {
            if(set.contains(c)){
                while(set.contains(c)){
                    set.remove(s.charAt(i));
                    i++;
                }
                set.add(c);
            }
            else{
                set.add(c);
                max=Math.max(max,set.size());
            }
            j++;
        }
        return max;
        
    }
}
