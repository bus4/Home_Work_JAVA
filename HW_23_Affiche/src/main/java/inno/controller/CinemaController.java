package inno.controller;

import inno.model.Cinema;
import inno.model.CinemaComment;
import inno.repository.CinemaCommentRepository;
import inno.repository.CinemaRepository;
import inno.util.validators.CinemaValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static java.lang.Math.toIntExact;

@Controller
@RequestMapping("/cinemas")
@Transactional
public class CinemaController {

    @Autowired
    CinemaRepository cinemaRepository;

    @Autowired
    CinemaCommentRepository cinemaCommentRepository;

    @Autowired
    CinemaValidator validator;

    @RequestMapping
    public String getAllCinemas(@RequestParam(value = "phraze", required = false) String phraze, ModelMap map) {
        List<Cinema> cinemas = cinemaRepository.findAll();
//        List<Post> posts = new ArrayList<>();
//        for (Post postN : repository.findAll()) {
//            posts.add(postN);
//        }
//        System.out.println(posts.get(0).getSuser().getMail());
//        System.out.println(posts);

        if (phraze != null) {
            int l = cinemas.size();
            for (int i = 0; i < l; i++) {
                if (!(cinemas.get(i).getName().contains(phraze))) {
                    cinemas.remove(i);
                    i--;
                    l--;
                }
            }
        }
        cinemas.sort((o1, o2) -> toIntExact(o2.getId() - o1.getId()));
        map.addAttribute("cinemas", cinemas);

        return "cinemas/index";
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addNewcinemaPage(ModelMap map) {
        map.addAttribute(new Cinema());
//        return "cinemas/add";
        return "redirect:/cinemas";

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addNewcinema(@ModelAttribute Cinema cinema, BindingResult rezult) {
        validator.validate(cinema, rezult);
        if (rezult.hasErrors()) return "/cinemas/add";
//        Authentication auth =  SecurityContextHolder. getContext (). getAuthentication ();
//        String name = auth.getName();
//        cinema.setAuthor(name);

//        Suser suser = (Suser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        cinema.setSuser(suser);

        cinemaRepository.save(cinema);
        return "redirect:/cinemas";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String showcinema(@PathVariable("id") Long id, ModelMap map) {
        List<CinemaComment> comments = cinemaCommentRepository.findByCinemaId(id);
        comments.sort((o1, o2) -> toIntExact(o2.getId() - o1.getId()));

        map.addAttribute("cinema", cinemaRepository.findOne(id));
        map.addAttribute("cinemaComments",comments);
        return "/cinemas/show";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String editcinema(@PathVariable("id") Long id, ModelMap map) {
        Cinema cinema = cinemaRepository.findOne(id);
        map.addAttribute("cinema", cinema);
//        map.addAttribute("cinema", cinema);
//        return "redirect:/cinemas";

        return "/cinemas/edit";
    }

    @RequestMapping(value = "/{id}/save", method = RequestMethod.POST)
    public String savecinema(@ModelAttribute @Valid Cinema cinema, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/cinemas";
//            return "cinemas/edit";
        }
//        List<Comment> ncom = new ArrayList<>();
//        if (cinema.getComments() == null) {
//        cinema.setComments(ncom);
//        }
//        Suser suser = (Suser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        cinema.setSuser(suser);

        cinemaRepository.save(cinema);
        return "redirect:/cinemas";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String delcinema(@PathVariable("id") Long id, ModelMap map) {
        cinemaRepository.delete(id);
        return "redirect:/cinemas";
    }

}
