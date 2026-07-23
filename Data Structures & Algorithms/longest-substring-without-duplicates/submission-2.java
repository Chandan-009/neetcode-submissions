class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set=new HashSet<>();
        int j=0, res=0;
        for(int i=0;i<s.length();i++){
            //check if its contains in set and remove the char from start if present 
            char cur_char=s.charAt(i);
            while(set.contains(cur_char) && j<=i){
                char left_most_char=s.charAt(j);
                set.remove(left_most_char);
                j++;
            }
            set.add(cur_char);
            res=Math.max(res,set.size());
        }
        return res;
    }

    
}
