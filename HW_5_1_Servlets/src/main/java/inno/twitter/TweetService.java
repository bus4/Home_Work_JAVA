package inno.twitter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Альберт on 09.11.2016.
 */
public class TweetService {
    private static int ids = 0;
    private List<Tweet> tweets = new ArrayList<Tweet>();

    public List<Tweet> getAll() {
        return tweets;
    }

    public boolean add(String message) {
        Tweet tweet = new Tweet();
        tweet.setMessege(message);
        tweet.setCreatedAt(new Date());
        tweet.setId(++ids);
        List<String> comments = new ArrayList<String>();
//        TweetService comments = new TweetService();
        tweet.setComments(comments);
        return tweets.add(tweet);
    }

    public boolean del(long id) {
        Tweet tweet = getByID(id);
        return tweets.remove(tweet);
    }

    public Tweet getByID(long id) {
        for (Tweet tweet : tweets
                ) {
            if (tweet.getId() == id) {
                return tweet;
            }
        }
        return null;
    }

    public boolean addComment(long idL, String comment) {
//        Tweet tweet = new Tweet();
//        tweet.setMessege(comment);
//        tweet.setCreatedAt(new Date());
//        tweet.setId(++ids);
//     //   TweetService comments = new TweetService();
//      //  tweet.setComments(comments);
//        return tweets.comments.add(tweet);
//
//


  //      System.out.println("Добавил коммент" + getByID(idL).getComments().add(comment) );
        return getByID(idL).getComments().add(comment);
    }
    // public Tweet

}
