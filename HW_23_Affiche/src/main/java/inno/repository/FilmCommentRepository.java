package inno.repository;

import inno.model.FilmComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public interface FilmCommentRepository extends JpaRepository<FilmComment,Long> {

    List<FilmComment> findByFilmId(long id);


}
