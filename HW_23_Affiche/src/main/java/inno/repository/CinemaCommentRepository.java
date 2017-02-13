package inno.repository;

import inno.model.CinemaComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public interface CinemaCommentRepository extends JpaRepository<CinemaComment,Long> {

    List<CinemaComment> findByCinemaId(long id);

}
