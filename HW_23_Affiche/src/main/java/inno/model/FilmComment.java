package inno.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "film_comment")
@SequenceGenerator(sequenceName = "film_comment_seq", name = "filmCommentSequence")
public class FilmComment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "filmCommentSequence")
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
    @JoinColumn(name = "film_id")
    private Film film;

    @ManyToOne
    @JoinColumn(name = "suser_id")
    private Suser suser;

    public FilmComment() {
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

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Suser getSuser() {
        return suser;
    }

    public void setSuser(Suser suser) {
        this.suser = suser;
    }
}
