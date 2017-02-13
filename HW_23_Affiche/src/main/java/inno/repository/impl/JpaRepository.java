package inno.repository.impl;

import inno.model.*;
import inno.repository.PostReepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class JpaRepository implements PostReepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Post> findAll() {
        TypedQuery<Post> query = em.createQuery("SELECT post FROM Post post", Post.class);

        return query.getResultList();
    }

    @Override
    public Post find(Long id) {
        Post post = em.find(Post.class, id);
        post.getComments().size();
        return post;
    }

    @Override
    public boolean add(Post post) {
        em.persist(post);
        return true;
    }

    @Override
    public boolean remove(Long id) {
        em.remove(em.find(Post.class, id));
        return true;
    }

    @Override
    public void save(Post post) {
        em.merge(post);
    }


//    @Override
//    public Suser findU(String mail) {
//        Suser suser = null;
//        try {
//            suser = em.find(Suser.class, mail);
//        } catch (Exception e) {
//            return suser;
//        }
//        return suser;
//    }
//
//    @Override
//    public boolean addSuser(Suser suser) {
//        em.persist(suser);
//        return true;
//    }

}































