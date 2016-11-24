package inno.repository.impl;

import inno.model.Student;
import inno.model.SubjektType;
import inno.repository.PostReepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class JpaRepository implements PostReepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Student> findAllS() {
        TypedQuery<Student> query = em.createQuery("SELECT student FROM Student student", Student.class);

        return query.getResultList();
    }

    @Override
    public Student findS(Long id) {
        Student student = em.find(Student.class, id);
        //  Student.getComments().size();
        return student;
    }

    @Override
    public boolean addS(Student student) {
        em.persist(student);
        return true;
    }

    @Override
    public boolean removeS(Long id) {
        em.remove(em.find(Student.class, id));
        return true;
    }


    //    Свой суммарный балл за все предметы
    @Override
    public Long sumScore(Long id) {
        TypedQuery<Long> query = em.createQuery("SELECT SUM(score.score) FROM Score score WHERE score.student_id.id = :id", Long.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    //    Средний балл по всем предметам
    @Override
    public Long avgScore(Long id) {
        TypedQuery<Double> query = em.createQuery("SELECT AVG (score.score) FROM Score score WHERE score.student_id.id=:id", Double.class);
        query.setParameter("id", id);
        Long rezult =  Math.round(query.getSingleResult());
        return rezult;
    }

    //    Балл по определенному предмету
    @Override
    public Long avgScoreP(Long id, SubjektType subjekt_type) {
        TypedQuery<Double> query = em.createQuery("SELECT AVG(score.score) FROM Score score WHERE score.student_id.id=:id AND score.subjekt_type = :subjekt_type", Double.class);
        query.setParameter("id", id);
        query.setParameter("subjekt_type", subjekt_type);
        Long rezult =  Math.round(query.getSingleResult());
        return rezult;
    }
}































