package inno.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Альберт on 21.11.2016.
 */

@Entity
@Table
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String surname;

    private String lastname;

    @OneToMany(mappedBy = "student_id", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    //   @OrderColumn(name = "order")
    private List<Score> Score;

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<inno.model.Score> getScore() {
        return Score;
    }

    public void setScore(List<inno.model.Score> score) {
        Score = score;
    }
}
//    @ManyToMany
//    @JoinTable(name = "st_el", joinColumns = {
//            @JoinColumn(name = "student_id")
//    }, inverseJoinColumns = {
//            @JoinColumn(name = "elective_id")
//    })
//    private List<Elective> electives;




