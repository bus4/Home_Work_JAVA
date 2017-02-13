package inno.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "film")
@SequenceGenerator(sequenceName = "film_seq", name = "filmSequence")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "filmSequence")
    @Column(name = "id")
    private long id;

    @Column
    @NotEmpty
    private String name;

    @Column
    private String description;

    @Column
    private long rating;

    @ManyToMany
    @JoinTable(name = "cinemas",
            joinColumns = {@JoinColumn(name = "film_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "cinema_id", nullable = false)})
    private List<Cinema> cinemas;

    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Seance> seances;

    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<FilmComment> comments;

    public Film() {
        this.rating = 0;
    }

    public Film(String name, String description) {
        this();
        this.name = name;
        this.description = description;
        this.cinemas = new ArrayList<>();
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

    public List<Cinema> getCinemas() {
        return cinemas;
    }

    public void setCinemas(List<Cinema> cinemas) {
        this.cinemas = cinemas;
    }

    public List<Seance> getSeances() {
        return seances;
    }

    public void setSeances(List<Seance> seances) {
        this.seances = seances;
    }

    public List<FilmComment> getComments() {
        return comments;
    }

    public void setComments(List<FilmComment> comments) {
        this.comments = comments;
    }
}
