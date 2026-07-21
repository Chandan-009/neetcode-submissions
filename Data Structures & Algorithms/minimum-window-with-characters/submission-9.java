class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> map_t=new HashMap<>();
        Map<Character,Integer> map_s=new HashMap<>();
        if(s.length()<t.length())
            return "";
        
        
        for(char c:t.toCharArray()){
            map_t.merge(c, 1, Integer::sum);
        }
        int j=0,minWindow=s.length(),startIndex=0,endIndex=-1;

        for(int i=0;i<s.length();i++) {
            char cur_char=s.charAt(i);
            map_s.merge(cur_char,1,Integer::sum);
            System.out.println(map_s.toString()+" "+map_t.toString());
            while(compareTwoMaps(map_s,map_t) && j<=i){
                System.out.println(map_s.size()+" "+minWindow);
                if(map_s.size() <= minWindow){
                    startIndex=j;
                    endIndex=i;
                    minWindow=map_s.size();
                }
                char start_char=s.charAt(j);
                if(map_s.get(start_char)==1)
                     map_s.remove(start_char);
                else
                   map_s.put(start_char,map_s.get(start_char)-1);
                System.out.println(cur_char+" "+start_char+" "+startIndex+" ");
                j++;
               
            }
            
        }

        String result="";
        for(int k=startIndex;k<=endIndex;k++){
            result=result+s.charAt(k);
        }
        return result;
    }

    public static boolean compareTwoMaps(Map<Character,Integer> map_s, Map<Character,Integer> map_t){
       // System.out.println(map_s.toString()+" "+map_t.toString());
        for(Character ch:map_t.keySet()) {
            if(map_s.containsKey(ch)){
                System.out.println(ch);
                if(map_t.get(ch)>map_s.get(ch))
                   return false;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
