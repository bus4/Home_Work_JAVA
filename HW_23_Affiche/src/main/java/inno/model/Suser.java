package inno.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table
@SequenceGenerator(sequenceName = "suser_seq", name = "suserSequence")
public class Suser {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "suserSequence")
    @Column(name = "id")
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "suser", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<CinemaComment> cinemacomments;

    @OneToMany(mappedBy = "suser", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<FilmComment> filmcomments;

    @ManyToMany
    @JoinTable(name = "roles",
            joinColumns = {@JoinColumn(name = "suser_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "role_id", nullable = false)})
    private Set<Role> roles;


    public List<CinemaComment> getCinemacomments() {
        return cinemacomments;
    }

    public void setCinemacomments(List<CinemaComment> cinemacomments) {
        this.cinemacomments = cinemacomments;
    }

    public List<FilmComment> getFilmcomments() {
        return filmcomments;
    }

    public void setFilmcomments(List<FilmComment> filmcomments) {
        this.filmcomments = filmcomments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {

        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
