class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length())
            return "";
        Map<Character,Integer> map_of_s=new HashMap<>();
        Map<Character,Integer> map_of_window=new HashMap<>();
        int start_index=-1,end_index=-1,min_window_size=Integer.MAX_VALUE, left_most_index=0;

        for(char t_char: t.toCharArray()){
            map_of_s.put(t_char,map_of_s.getOrDefault(t_char,0)+1);
        }

        for(int j=0;j<s.length();j++){
            //get cur char
            char cur_char=s.charAt(j);
            // put in map
            map_of_window.put(cur_char,map_of_window.getOrDefault(cur_char,0)+1);
            //expand window till the condition matches then shrink the wiondow
            System.out.println(s.substring(left_most_index,j+1));
            while(checkIfBothMapsAreEqual(map_of_s,map_of_window) && left_most_index<=j){
                if((j-left_most_index+1) < min_window_size){
                    start_index=left_most_index;
                    end_index=j;
                    min_window_size=(j-left_most_index+1);
                }
                char left_most_char=s.charAt(left_most_index);
                map_of_window.computeIfPresent(left_most_char,(key,value)->(value==1)? null:value-1);
                left_most_index++;
            }
        }
            if(start_index==-1)
              return "";
            return s.substring(start_index,end_index+1);
    }

    public static boolean checkIfBothMapsAreEqual(Map<Character,Integer> map_of_s, Map<Character,Integer>  map_of_window){
        if(map_of_window.size()<map_of_s.size())
           return false;
        
        for(Character ch :map_of_s.keySet()) {
            if(!map_of_window.containsKey(ch) || !(map_of_window.get(ch)>=map_of_s.get(ch)))
                return false;
        }

        return true;
    }
}
