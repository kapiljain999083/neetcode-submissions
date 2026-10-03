class Twitter {

    public Twitter() {
        
    }

    Map<Integer, Set<Integer>> followers = new HashMap<>();
    Map<Integer, Set<Tweet>> posts = new HashMap<>();
    int timeStamp = 0;
 
   Comparator<Tweet> cmp = new Comparator<Tweet>() {
        @Override
        public int compare(Tweet o1, Tweet o2) {
            if (o1.createdAt < o2.createdAt) return 1;
            if (o1.createdAt > o2.createdAt) return -1;
            return 0;
        }
    };


    public void postTweet(int userId, int tweetId) {
        Set<Tweet> set = posts.get(userId);
        if (set == null) {
            set = new HashSet<>();
        }
        set.add(new Tweet(tweetId, userId, timeStamp++));
        posts.put(userId, set);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<>();
        Set<Integer> userIds = followers.get(userId);
        if (userIds == null) userIds = new HashSet<>();
        userIds.add(userId);
        PriorityQueue<Tweet> pq = new PriorityQueue<>(cmp);
        for (int user : userIds) {
            Set<Tweet> posted = posts.get(user);
            if (posted != null) {
                for (Tweet t : posted) {
                    pq.add(t);
                }
            }
        }
        int count = 0;
        while (!pq.isEmpty() && count < 10) {
            ans.add(pq.remove().tweetId);
            count++;
        }
        return ans;
    }

        public void follow(int followerId, int followeeId) {
        Set<Integer> set = followers.get(followerId);
        if (set == null) {
            set = new HashSet<>();
        }
        set.add(followeeId);
        followers.put(followerId, set);
    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> set = followers.get(followerId);
        if (set != null && set.contains(followeeId)) {
            set.remove(followeeId);
            followers.put(followerId, set);
        }
    }
}

class Tweet {
    int tweetId;
    int userId;
    int createdAt;

    public Tweet(int tweetId, int userId, int timeStamp) {
        this.tweetId = tweetId;
        this.userId = userId;
        this.createdAt = timeStamp;
    }
}