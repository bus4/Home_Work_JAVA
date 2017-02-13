package inno.controller;

import inno.model.Film;
import inno.model.FilmComment;
import inno.model.Post;
import inno.model.Suser;
import inno.repository.FilmCommentRepository;
import inno.repository.FilmRepository;
import inno.repository.PostReepository;
import inno.util.validators.FilmValidator;
import inno.util.validators.PostValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static java.lang.Math.toIntExact;

@Controller
@RequestMapping("/films")
@Transactional
public class FilmController {

    @Autowired
    FilmRepository filmRepository;

    @Autowired
    FilmCommentRepository filmCommentRepository;

    @Autowired
    FilmValidator validator;

    @RequestMapping
    public String getAllFilms(@RequestParam(value = "phraze", required = false) String phraze, ModelMap map) {
        List<Film> films = filmRepository.findAll();
//        List<Post> posts = new ArrayList<>();
//        for (Post postN : repository.findAll()) {
//            posts.add(postN);
//        }
//        System.out.println(posts.get(0).getSuser().getMail());
//        System.out.println(posts);

        if (phraze != null) {
            int l = films.size();
            for (int i = 0; i < l; i++) {
                if (!(films.get(i).getName().contains(phraze))) {
                    films.remove(i);
                    i--;
                    l--;
                }
            }
        }
        films.sort((o1, o2) -> toIntExact(o2.getId() - o1.getId()));
        map.addAttribute("films", films);

        return "films/index";
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addNewfilmPage(ModelMap map) {
        map.addAttribute(new Film());
//        return "films/add";
        return "redirect:/films";

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addNewfilm(@ModelAttribute Film film, BindingResult rezult) {
        validator.validate(film, rezult);
        if (rezult.hasErrors()) return "/films/add";
//        Authentication auth =  SecurityContextHolder. getContext (). getAuthentication ();
//        String name = auth.getName();
//        film.setAuthor(name);

//        Suser suser = (Suser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        film.setSuser(suser);

        filmRepository.save(film);
        return "redirect:/films";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String showfilm(@PathVariable("id") Long id, ModelMap map) {
        List<FilmComment> comments = filmCommentRepository.findByFilmId(id);
        comments.sort((o1, o2) -> toIntExact(o2.getId() - o1.getId()));

        map.addAttribute("film", filmRepository.findOne(id));
        map.addAttribute("filmComments",comments);
        return "/films/show";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String editfilm(@PathVariable("id") Long id, ModelMap map) {
        Film film = filmRepository.findOne(id);
        map.addAttribute("film", film);
//        map.addAttribute("film", film);
//        return "redirect:/films";

        return "/films/edit";
    }

    @RequestMapping(value = "/{id}/save", method = RequestMethod.POST)
    public String savefilm(@ModelAttribute @Valid Film film, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/films";
//            return "films/edit";
        }
//        List<Comment> ncom = new ArrayList<>();
//        if (film.getComments() == null) {
//        film.setComments(ncom);
//        }
//        Suser suser = (Suser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        film.setSuser(suser);

        filmRepository.save(film);
        return "redirect:/films";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String delfilm(@PathVariable("id") Long id, ModelMap map) {
        filmRepository.delete(id);
        return "redirect:/films";
    }

}
