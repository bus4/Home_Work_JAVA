package inno.controller;

import inno.model.Film;
//import inno.model.FilmSeance;
import inno.model.Post;
import inno.model.Seance;
import inno.model.Suser;
import inno.repository.CinemaRepository;
//import inno.repository.FilmSeanceRepository;
import inno.repository.FilmRepository;
import inno.repository.SeanceRepository;
import inno.util.validators.FilmCommentValidator;
//import inno.util.validators.FilmSeanceValidator;
import inno.util.validators.SeanceValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import static java.lang.Math.toIntExact;

@Controller
@RequestMapping("/films/{id}/seances")
@Transactional
public class FilmSeanceController {

    @Autowired
    FilmRepository filmRepository;

    @Autowired
    CinemaRepository cinemaRepository;

    @Autowired
    SeanceRepository seanceRepository;

    @Autowired
    SeanceValidator validator;

    @PersistenceContext
    EntityManager em;


    @RequestMapping
    public String getAllSeances(@PathVariable("id") Long id, @RequestParam(value = "phraze", required = false) String phraze, ModelMap map) {

        TypedQuery<Seance> query = em.createQuery("SELECT seance FROM Seance seance WHERE seance.film.id=:id ORDER BY seance.cinema.id, seance.date", Seance.class);
        query.setParameter("id", id);
        List<Seance> seances = query.getResultList();
//        query.setParameter("id", id);


//        List<Seance> seances = seanceRepository.findAll();
//        List<Post> posts = new ArrayList<>();
//        for (Post postN : repository.findAll()) {
//            posts.add(postN);
//        }
//        System.out.println(posts.get(0).getSuser().getMail());
//        System.out.println(posts);

        if (phraze != null) {
//            int l = seances.size();
//            for (int i = 0; i < l; i++) {
//                if (!(seances.get(i).getName().contains(phraze))) {
//                    films.remove(i);
//                    i--;
//                    l--;
//                }
//            }
        }
//        seances.sort((o1, o2) -> toIntExact(o2.getId() - o1.getId()));
        map.addAttribute("seances", seances);
        map.addAttribute("cinemas", cinemaRepository.findAll());
        map.addAttribute("film", filmRepository.findOne(id));

        return "films/seances";
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addNewFilmSeancePage(@PathVariable("id") Long id, ModelMap map) {
//        map.addAttribute(new Film());
        map.addAttribute("seance", new Seance());
//        return "films/add";
        return "redirect:/films/" + id + "/seances";

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addNewFilmSeance(@PathVariable("id") Long id, @ModelAttribute Seance seance, BindingResult rezult, ModelMap map) throws ParseException {

        seance.setCinema(cinemaRepository.findOne(Long.parseLong(rezult.getFieldValue("cinema").toString())));
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm", Locale.ENGLISH);
        seance.setDate(format.parse(rezult.getFieldValue("date").toString()));
        Film film = filmRepository.findOne(id);
        seance.setFilm(film);

        validator.validate(seance, rezult);
//        if (rezult.hasErrors()) return "/films/add";

//        Authentication auth =  SecurityContextHolder. getContext (). getAuthentication ();
//        String name = auth.getName();

//        Suser suser = (Suser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

//        seance.setSuser(suser);
        seanceRepository.save(seance);

//        List<FilmSeance> seances = filmSeanceRepository.findByFilmId(id);
//        float sumRating = 0;
//        float countRating = 0;
//        for (FilmSeance c : seances) {
//            sumRating += c.getRating();
//            countRating++;
//        }
//        film.setRating(Math.round(sumRating / countRating));
//
//        long filmId = film.getId();
//        map.addAttribute("film", film);
//        map.addAttribute("filmSeances", seances);
        return "redirect:/films/" + id + "/seances";
    }


//        return "redirect:/films/"+id;    }

//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public String showfilm(@PathVariable("id") Long id, ModelMap map) {
//        map.addAttribute("film", filmRepository.findOne(id));
//        map.addAttribute("filmSeances", filmSeanceRepository.findByFilmId(id));
//        return "/films/show";
//    }
//
//    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
//    public String editfilm(@PathVariable("id") Long id, ModelMap map) {
//        Film film = filmRepository.findOne(id);
//        map.addAttribute("film", film);
////        map.addAttribute("film", film);
////        return "redirect:/films";
//
//        return "/films/edit";
//    }
//
//    @RequestMapping(value = "/{id}/save", method = RequestMethod.POST)
//    public String savefilm(@ModelAttribute @Valid Film film, BindingResult result) {
//        if (result.hasErrors()) {
//            return "redirect:/films";
////            return "films/edit";
//        }
////        List<Seance> ncom = new ArrayList<>();
////        if (film.getSeances() == null) {
////        film.setSeances(ncom);
////        }
////        Suser suser = (Suser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
////        film.setSuser(suser);
//
//        filmRepository.save(film);
//        return "redirect:/films";
//    }

    @RequestMapping(value = "/{idc}/delete", method = RequestMethod.GET)
    public String delfilm(@PathVariable("idc") Long id, ModelMap map) {
//        Film film = filmSeanceRepository.findOne(id).getFilm();
//        filmSeanceRepository.delete(id);
//        long filmId = film.getId();
//
//        List<FilmSeance> seances = filmSeanceRepository.findByFilmId(filmId);
//        float sumRating = 0;
//        float countRating = 0;
//        for (FilmSeance c : seances) {
//            sumRating += c.getRating();
//            countRating++;
//        }
//        film.setRating(Math.round(sumRating / countRating));

        return "redirect:/films/" + id;

//        map.addAttribute("film", film);
//        map.addAttribute("filmSeances", filmSeanceRepository.findByFilmId(film.getId()));
//        return "/films/show";
    }

}
