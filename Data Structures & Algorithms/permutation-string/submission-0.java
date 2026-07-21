class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s1.length()>s2.length()) return false;

        Map<Character,Integer> map1=new HashMap<>();
        for(char c: s1.toCharArray()) {
            map1.put(c,map1.getOrDefault(c,0)+1);
        }

        Map<Character,Integer> map2=new HashMap<>();
        int i=0;
        while(i<s1.length()){
            char c1=s2.charAt(i);
            map2.put(c1,map2.getOrDefault(c1,0)+1);
            i++;
        }

        int k=0;

        // check first window
        if(compareMaps(map1,map2))
            return true;
        else{
            for(int j=s1.length();j<s2.length();j++){
                //add new char
                char c2=s2.charAt(j);
                map2.put(c2,map2.getOrDefault(c2,0)+1);
    

                // remove window start char 
                char c3=s2.charAt(k);
                k++;
                if(map2.get(c3)>1)
                   map2.put(c3,map2.get(c3)-1);
                else
                  map2.remove(c3);
                if(compareMaps(map1,map2))
                   return true;
            }
        }

        return false;
        
    }

    public static boolean compareMaps(Map<Character,Integer> map1,Map<Character,Integer> map2){

        for(char c: map1.keySet())
        {
            //contains and frequncy equal
            if(map2.containsKey(c) && map2.get(c)==map1.get(c)){
                continue;
            }
            else{
                return false;
            }
        }
        return true;

    }


    
}
