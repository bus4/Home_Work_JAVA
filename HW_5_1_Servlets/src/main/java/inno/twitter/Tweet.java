package inno.twitter;

import java.util.Date;
import java.util.List;

/**
 * Created by Альберт on 09.11.2016.
 */
public class Tweet {
    private long id;
    private String messege;
    private Date createdAt;
    private List<String> comments;


    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }




    public String getMessege() {
        return messege;
    }

    public void setMessege(String messege) {
        this.messege = messege;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "message='" + messege + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

}
