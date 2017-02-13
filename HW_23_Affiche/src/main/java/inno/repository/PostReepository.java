package inno.repository;

import inno.model.Post;
import inno.model.Suser;

import java.util.List;

/**
 * Created by Альберт on 13.11.2016.
 */
public interface PostReepository {

    List<Post> findAll();

    void save(Post post);

    Post find(Long id);

    boolean add(Post post);

    boolean remove(Long id);

//    Suser findU(String mail);
//
//    boolean addSuser(Suser suser);

}
