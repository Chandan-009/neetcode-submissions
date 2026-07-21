class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for(String s:strs){
            String key=getKey(s);
            System.out.println(key);
            List<String> list=map.getOrDefault(key,new ArrayList<>());
            list.add(s);
            map.put(key,list);
        }
        return new ArrayList<>(map.values()); 
    }

    public static String getKey(String s) {

        int[] charArray=new int[26];
        for(char c: s.toCharArray()){
            charArray[c-'a']++;
        }

        String key="";
        for(int i=0;i<26;i++){
            if(charArray[i]!=0){
                char r=(char)('a'+i);
                key=key+r;
                key=key+charArray[i];
            }
        }
        return key;
    }
}
