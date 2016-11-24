package inno.model;


import javax.persistence.*;

@Entity
@Table
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private SubjektType subjekt_type;

    private Long score;

 //   private Long student_id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student_id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SubjektType getSubjekt_type() {
        return subjekt_type;
    }

    public void setSubjekt_type(SubjektType subjekt_type) {
        this.subjekt_type = subjekt_type;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public Student getStudent() {
        return student_id;
    }

    public void setStudent(Student student) {
        this.student_id = student;
    }
}
