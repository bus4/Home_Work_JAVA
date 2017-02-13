package inno.repository;

import inno.model.Cinema;
import inno.model.FilmComment;
import inno.model.Seance;
import inno.model.Suser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;


@Repository
@Transactional
public interface SeanceRepository extends JpaRepository <Seance, Long> {

    List<Seance> findByDate(Date date);


}
