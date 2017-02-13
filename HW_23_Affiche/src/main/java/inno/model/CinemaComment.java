package inno.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cinema_comment")
@SequenceGenerator(sequenceName = "cinema_comment_seq", name = "cinemaCommentSequence")
public class CinemaComment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cinemaCommentSequence")
    @Column(name = "id")
    private long id;

    @Column(name = "creationDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column
//    @Range(min = 0, max = 100)
    private long rating;

    @NotEmpty
    @Column
    private String text;

    @ManyToOne
    @JoinColumn(name = "cinema_id")
    private Cinema cinema;

    @ManyToOne
    @JoinColumn(name = "suser_id")
    private Suser suser;

    public CinemaComment() {
        this.date = new Date();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getRating() {
        return rating;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public Suser getSuser() {
        return suser;
    }

    public void setSuser(Suser suser) {
        this.suser = suser;
    }
}
