class TimeMap {
    class Pair{
        int timestamp;
        String value;
        Pair(int timestamp, String value){
    this.timestamp = timestamp;
    this.value = value;
       }
    } 
    Map<String,List<Pair>> map;

    public TimeMap() {
        map=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Pair pair=new Pair(timestamp, value);
        List<Pair> list = map.getOrDefault(key, new ArrayList<>());
        list.add(pair);         
        map.put(key, list);
    }
    
    public String get(String key, int target) {
        List<Pair> list=map.get(key);
        if (list == null)
            return "";
        int l=0,r=list.size()-1,mid=-1;
        int res=-1;
        while(l<=r){
            mid=(l+r)/2;
            if(list.get(mid).timestamp==target){
                res=mid;
                break;
            }
            else if(target > list.get(mid).timestamp){
                res=mid;
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return res == -1 ? "" : list.get(res).value;
    }



    
}
