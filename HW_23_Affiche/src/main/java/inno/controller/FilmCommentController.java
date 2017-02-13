package inno.controller;

import inno.model.Film;
import inno.model.FilmComment;
import inno.model.Seance;
import inno.model.Suser;
import inno.repository.FilmCommentRepository;
import inno.repository.FilmRepository;
import inno.repository.SeanceRepository;
import inno.util.validators.FilmCommentValidator;
import inno.util.validators.FilmValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

import static java.lang.Math.toIntExact;

@Controller
@RequestMapping("/films/{id}/comments")
@Transactional
public class FilmCommentController {

    @Autowired
    FilmRepository filmRepository;

    @Autowired
    FilmCommentRepository filmCommentRepository;

    @Autowired
    SeanceRepository seanceRepository;

    @Autowired
    FilmCommentValidator validator;

    @PersistenceContext
    EntityManager em;

    public ArrayBlockingQueue<Film> filmQueue = new ArrayBlockingQueue<Film>(10);
    //Deck ????


    //"/films/${film.id}/comment/${comment.id}
    //  "/films/${film.id}/comments/add"


    //    @RequestMapping
//    public String getAllFilms(@RequestParam(value = "phraze", required = false) String phraze, ModelMap map) {
//        List<Film> films = filmRepository.findAll();
////        List<Post> posts = new ArrayList<>();
////        for (Post postN : repository.findAll()) {
////            posts.add(postN);
////        }
////        System.out.println(posts.get(0).getSuser().getMail());
////        System.out.println(posts);
//
//        if (phraze != null) {
//            int l = films.size();
//            for (int i = 0; i < l; i++) {
//                if (!(films.get(i).getName().contains(phraze))) {
//                    films.remove(i);
//                    i--;
//                    l--;
//                }
//            }
//        }
//        map.addAttribute("films", films);
//
//        return "films/index";
//    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addNewFilmCommentPage(@PathVariable("id") Long id, ModelMap map) {
//        map.addAttribute(new Film());
        map.addAttribute("comment", new FilmComment());
//        return "films/add";
        return "redirect:/films/" + id;

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addNewFilmComment(@PathVariable("id") Long id, @ModelAttribute FilmComment comment, BindingResult rezult, ModelMap map) {
        comment.setRating(Long.parseLong(rezult.getFieldValue("rating").toString()));

        System.out.println(rezult.getFieldValue("rating"));
        validator.validate(comment, rezult);
//        if (rezult.hasErrors()) return "/films/add";

//        Authentication auth =  SecurityContextHolder. getContext (). getAuthentication ();
//        String name = auth.getName();
        Suser suser = (Suser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        comment.setSuser(suser);

        Film film = filmRepository.findOne(id);
        comment.setFilm(film);

        filmCommentRepository.save(comment);
        filmQueue.add(film);

        setRating();


//        film.setRating(Math.round(sumRating / countRating));

//        long filmId = film.getId();
//        map.addAttribute("film", film);
//        map.addAttribute("filmComments", comments);
        return "redirect:/films/" + id;
    }


//        return "redirect:/films/"+id;    }

//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public String showfilm(@PathVariable("id") Long id, ModelMap map) {
//        map.addAttribute("film", filmRepository.findOne(id));
//        map.addAttribute("filmComments", filmCommentRepository.findByFilmId(id));
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
////        List<Comment> ncom = new ArrayList<>();
////        if (film.getComments() == null) {
////        film.setComments(ncom);
////        }
////        Suser suser = (Suser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
////        film.setSuser(suser);
//
//        filmRepository.save(film);
//        return "redirect:/films";
//    }

    @RequestMapping(value = "/{idc}/delete", method = RequestMethod.GET)
    public String delfilm(@PathVariable("idc") Long id, ModelMap map) {
        Film film = filmCommentRepository.findOne(id).getFilm();
        filmCommentRepository.delete(id);
        long filmId = film.getId();

        List<FilmComment> comments = filmCommentRepository.findByFilmId(filmId);
        float sumRating = 0;
        float countRating = 0;
        for (FilmComment c : comments) {
            sumRating += c.getRating();
            countRating++;
        }
        film.setRating(Math.round(sumRating / countRating));

        return "redirect:/films/" + filmId;

//        map.addAttribute("film", film);
//        map.addAttribute("filmComments", filmCommentRepository.findByFilmId(film.getId()));
//        return "/films/show";
    }

    @Transactional(propagation = Propagation.NESTED)
    public void setRating() {
        new Thread(new Runnable() {
            @Override
            public void run() {
//        TypedQuery<Float> query = em.createQuery("SELECT AVG (rating) FROM FilmComment ", Long.class);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

//                int n=1;
//                for (int i = 0; i < 100000; i++) {
//                    n = n*2;
//                }


                Film nfilm = filmQueue.poll();
                Long nid = nfilm.getId();
                Query query = em.createNativeQuery("SELECT AVG(Rating) FROM film_comment WHERE film_id=:id");

//        TypedQuery<Float> query = em.createQuery("SELECT AVG(film_comment.rating) FROM film_comment WHERE film_id.id = :id", Float.class);
                query.setParameter("id", nid);
                Float rating = Float.parseFloat(query.getSingleResult().toString());
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//        List<FilmComment> comments = filmCommentRepository.findByFilmId(id);
//        float sumRating = 0;
//        float countRating = 0;
//        for (FilmComment c : comments) {
//            sumRating += c.getRating();
//            countRating++;
//        }
                nfilm.setRating(Math.round(rating));
                filmRepository.save(nfilm);
            }
        }).start();


    }


}
