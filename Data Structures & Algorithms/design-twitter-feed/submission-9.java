public class Twitter {

     Map<Integer,Set<Integer>> following_map;
     Map<Integer,List<Tweet>> tweet_map;
     int c=0;

    public Twitter() {
        following_map=new HashMap<>();
        tweet_map=new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        // compute this if absent or else add new list
        Tweet tweet=new Tweet(tweetId,0);
        if(tweet_map.get(userId)!=null) {
            tweet.index=tweet_map.get(userId).size();
            tweet_map.get(userId).add(tweet);
        }
        else {
            List<Tweet> tweets=new ArrayList<>();
            tweets.add(tweet);
            tweet_map.put(userId,tweets);
        }

    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> queue=new PriorityQueue<>(Comparator.comparing(Tweet::getPostId).reversed());
        if(following_map.get(userId)==null || !following_map.get(userId).contains(userId))
             following_map.computeIfAbsent(userId, k-> new HashSet<>()).add(userId);
        List<List<Tweet>> tweet_list=new ArrayList<>();
        // add list of posts associated to the follwer
        for(Integer i :following_map.get(userId)){
            tweet_list.add(tweet_map.get(i));
        }

        // insert last index of all posts in the queue and remove from original list
        for(int i=0; i<tweet_list.size(); i++) {
            List<Tweet> cur_tweet_list=tweet_list.get(i);
            if(cur_tweet_list!=null && cur_tweet_list.size() > 0){
                Tweet last_tweet=cur_tweet_list.getLast();
                last_tweet.poisition=i;
                queue.add(last_tweet);
            }
        }
        int count=0;
        List<Integer> result=new ArrayList<>();
        while(queue.size()>0 && count<10){
            Tweet tweet=queue.poll();
            result.add(tweet.value);
            List<Tweet> cur_tweet_list=tweet_list.get(tweet.poisition);
            if(tweet.index > 0){
                int last_index_processed=tweet.index;
                Tweet cur_tweet=cur_tweet_list.get(last_index_processed-1);
                cur_tweet.poisition=tweet.poisition;
                queue.add(cur_tweet);
            }
            count++;
        }
        //result.sort(Comparator.comparing(Integer::intValue));
        return result;
    }

    public void follow(int followerId, int followeeId) {
        // compute this if absent or else get it
        if(followerId!=followeeId)
          following_map.computeIfAbsent(followerId, k-> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> cur_following_map= following_map.get(followerId);
        if(cur_following_map!=null){
            cur_following_map.remove(Integer.valueOf(followeeId));
        }
    }


    class Tweet {
        int poisition;
        long post_id;
        int value;
        int index;

        Tweet(int value, int index){
            this.index=index;
            this.value=value;
            c++;
            this.post_id= c;
        }

        public long getPostId() {
            return post_id;
        }
        public int getValue() {
            return value;
        }
    }



}