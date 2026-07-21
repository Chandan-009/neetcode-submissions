class Solution {
    public boolean isAnagram(String s, String t) {
        int[] charArray=new int[26];
        for(char c: s.toCharArray()){
            charArray[c-'a']=charArray[c-'a']+1;
        }
        for(char c: t.toCharArray()){
            charArray[c-'a']=charArray[c-'a']-1;
        }
        for(int i:charArray){
            if(i!=0)
              return false;
        }
        return true;
    }
}
