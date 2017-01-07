package inno.model;

import javax.persistence.*;

@Entity
@Table
@SequenceGenerator(sequenceName = "suser_seq", name = "suserSequence")
public class Suser {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "suserSequence")
    @Column(name = "id")
    private Long id;

    @Column(unique = true, nullable = false)
    private String mail;

    @Column(nullable = false)
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
