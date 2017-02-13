package inno.model;

import inno.repository.CinemaRepository;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "seance")
@SequenceGenerator(sequenceName = "seance_seq", name = "seanceSequence")
public class Seance {

//    @Transient
//    @Autowired
//    CinemaRepository cinemaRepository;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seanceSequence")
    @Column(name = "id")
    private long id;

    @Column(name = "seanceDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "cinema_id")
    private Cinema cinema;

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;

    public Seance() {
    }

//    public Seance(String date, String id) {
//        this();
//        this.date = new Date();
//        this.cinema = cinemaRepository.findOne(Long.parseLong(id));
//
//    }


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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
}
