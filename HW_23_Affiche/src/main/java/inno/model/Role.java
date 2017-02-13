package inno.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Альберт on 02.12.2016.
 */

@Entity
@Table(name="role")
@SequenceGenerator(name = "roleSeq",sequenceName = "role_seq")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roleSeq")
    @Column(name = "id")
    private Long id;

    @ManyToMany(mappedBy = "roles")
    private List<Suser> susers;

    @Column(unique = true, nullable = false)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Suser> getSusers() {
        return susers;
    }

    public void setSusers(List<Suser> susers) {
        this.susers = susers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        return name.equals(role.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

}
