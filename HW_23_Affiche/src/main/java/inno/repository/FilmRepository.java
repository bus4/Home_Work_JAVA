package inno.repository;

import inno.model.Film;
import inno.model.Seance;
import inno.model.Suser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface FilmRepository extends JpaRepository <Film, Long> {

//    Suser findByName(String name);


}
