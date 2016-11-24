package inno.repository;

import inno.model.Student;
import inno.model.SubjektType;

import java.util.List;

/**
 * Created by Альберт on 13.11.2016.
 */
public interface PostReepository {

    List<Student> findAllS();

    Student findS(Long id);

    boolean addS(Student student);

    boolean removeS(Long id);

    Long sumScore (Long id);

    //    Средний балл по всем предметам
    Long avgScore(Long id);

    //    Балл по определенному предмету
    Long avgScoreP(Long id, SubjektType subjekt_type);

//    //    Балл по определенному предмету
//    Long avfScoreP(Long id);
}
