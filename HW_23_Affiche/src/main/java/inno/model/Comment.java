package inno.model;

import javax.persistence.*;
import java.util.Date;

//@Entity
//@Table(name = "comment")
//@SequenceGenerator(sequenceName = "comment_seq", name = "commentSequence")
public class Comment {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "commentSequence")
    private Long id;

    @Column
    private String text;
//    @Column(name = "post_id")

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
/*
    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
*/
}
