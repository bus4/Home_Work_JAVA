package inno.repository;

import inno.model.Post;
import inno.model.Student;
import inno.model.SubjektType;
import inno.model.Suser;

import java.util.List;

/**
 * Created by Альберт on 13.11.2016.
 */
public interface PostReepository {

    List<Post> findAll();

    void save(Post post);

    List<Student> findAllS();

    Post find(Long id);

    boolean add(Post post);

    boolean remove(Long id);

    Student findS(Long id);

    boolean addS(Student student);

    boolean removeS(Long id);

    Long sumScore (Long id);

    //    Средний балл по всем предметам
    Long avgScore(Long id);

    //    Балл по определенному предмету
    Long avgScoreP(Long id, SubjektType subjekt_type);


    Suser findU(String mail);

    boolean addSuser(Suser suser);

//    //    Балл по определенному предмету
//    Long avfScoreP(Long id);
}
