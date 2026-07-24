class Solution {
    public int characterReplacement(String s, int k) {

        int maxWindowSize=0;
        Map<Character,Integer> map=new HashMap<>();
        int i=0,j=0;
        char maxChar=s.charAt(0);
        for(char c: s.toCharArray()) { 
            map.put(c,map.getOrDefault(c,0)+1);
            maxChar=getMaxChar(map);
           // int windowSize = ;
            while((j - i + 1)-map.get(maxChar)>k){
               char left_most_char=s.charAt(i);
               map.computeIfPresent(left_most_char,(key,v)->{
                v=v-1;
                if(v==0){
                    return null;
                }
                else{
                    return v;
                }
               });
                maxChar=getMaxChar(map);
                i++;
            }
            maxWindowSize=Math.max(maxWindowSize,j - i + 1);
            j++;
            
        }
        return maxWindowSize;
        
    }

    public static char getMaxChar(Map<Character, Integer> map) {
    char maxChar = ' ';
    int maxCount = 0;

    for(Character c: map.keySet()){
        if(map.get(c)>maxCount){
            maxCount=map.get(c);
            maxChar=c;
        }

    }



    return maxChar;
   }
}
