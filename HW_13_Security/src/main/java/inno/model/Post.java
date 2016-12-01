package inno.model;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.*;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "post")
@SequenceGenerator(sequenceName = "post_seq", name = "postSequence")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "postSequence")
    @Column(name = "id")
    private long id;

    @Column
    private String author;

    @Column
    private String title;

    @Column
    private String text;

    @Column(name = "creationDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Comment> comments;

    @Transient //Не мапить это поле
    @Enumerated(EnumType.STRING)
    private PostType type;

    public Post() {
        this.date = new Date();
    }

    public Post(String title, String text) {
        this();
        this.title = title;
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
