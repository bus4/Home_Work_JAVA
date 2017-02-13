package inno.repository;

import inno.model.Cinema;
import inno.model.Film;
import inno.model.Suser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface CinemaRepository extends JpaRepository <Cinema, Long> {

    Suser findByName(String name);


}
