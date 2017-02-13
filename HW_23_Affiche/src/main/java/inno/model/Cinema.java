package inno.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cinema")
@SequenceGenerator(sequenceName = "cinema_seq", name = "cinemaSequence")
public class Cinema {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cinemaSequence")
    @Column(name = "id")
    private long id;

    @Column
    @NotEmpty
    private String name;

    @Column
    private String description;

    @Column
    private long rating;

    @ManyToMany(mappedBy = "cinemas")
    private List<Film> films = new ArrayList<>();

    @OneToMany(mappedBy = "cinema", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Seance> seances = new ArrayList<>();

    @OneToMany(mappedBy = "cinema", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<CinemaComment> comments = new ArrayList<>();

    public Cinema() {
        this.rating = 0;
    }

    public Cinema(String name, String description) {
        this();
        this.name = name;
        this.description = description;
        this.films = new ArrayList<>();
        this.seances = new ArrayList<>();
        this.comments = new ArrayList<>();
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getRating() {
        return rating;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    public List<Seance> getSeances() {
        return seances;
    }

    public void setSeances(List<Seance> seances) {
        this.seances = seances;
    }

    public List<CinemaComment> getComments() {
        return comments;
    }

    public void setComments(List<CinemaComment> comments) {
        this.comments = comments;
    }
}
