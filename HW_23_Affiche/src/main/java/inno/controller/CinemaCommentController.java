package inno.controller;

import inno.model.Cinema;
import inno.model.CinemaComment;
import inno.model.Suser;
import inno.repository.CinemaCommentRepository;
import inno.repository.CinemaRepository;
import inno.util.validators.CinemaCommentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/cinemas/{id}/comments")
@Transactional
public class CinemaCommentController {

    @Autowired
    CinemaRepository cinemaRepository;

    @Autowired
    CinemaCommentRepository cinemaCommentRepository;

    @Autowired
    CinemaCommentValidator validator;


    //"/cinemas/${cinema.id}/comment/${comment.id}
    //  "/cinemas/${cinema.id}/comments/add"


//    @RequestMapping
//    public String getAllCinemas(@RequestParam(value = "phraze", required = false) String phraze, ModelMap map) {
//        List<Cinema> cinemas = cinemaRepository.findAll();
////        List<Post> posts = new ArrayList<>();
////        for (Post postN : repository.findAll()) {
////            posts.add(postN);
////        }
////        System.out.println(posts.get(0).getSuser().getMail());
////        System.out.println(posts);
//
//        if (phraze != null) {
//            int l = cinemas.size();
//            for (int i = 0; i < l; i++) {
//                if (!(cinemas.get(i).getName().contains(phraze))) {
//                    cinemas.remove(i);
//                    i--;
//                    l--;
//                }
//            }
//        }
//        map.addAttribute("cinemas", cinemas);
//
//        return "cinemas/index";
//    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addNewCinemaCommentPage(@PathVariable("id") Long id, ModelMap map) {
//        map.addAttribute(new Cinema());
        map.addAttribute("comment", new CinemaComment());
//        return "cinemas/add";
        return "redirect:/cinemas/" + id;

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addNewCinemaComment(@PathVariable("id") Long id, @ModelAttribute CinemaComment comment, BindingResult rezult, ModelMap map) {
        validator.validate(comment, rezult);

        CinemaComment comment1 = new CinemaComment();
        comment1.setDate(comment.getDate());
        comment1.setRating(comment.getRating());
        comment1.setText(comment.getText());



//        if (rezult.hasErrors()) return "/cinemas/add";

//        Authentication auth =  SecurityContextHolder. getContext (). getAuthentication ();
//        String name = auth.getName();
        Suser suser = (Suser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        comment1.setSuser(suser);

        Cinema cinema = cinemaRepository.findOne(id);
        comment1.setCinema(cinema);

        cinemaCommentRepository.save(comment1);

        List<CinemaComment> comments = cinemaCommentRepository.findByCinemaId(id);
        float sumRating = 0;
        float countRating = 0;
        for (CinemaComment c : comments) {
            sumRating += c.getRating();
            countRating++;
        }
        cinema.setRating(Math.round(sumRating / countRating));

        long cinemaId = cinema.getId();
//        map.addAttribute("cinema", cinema);
//        map.addAttribute("cinemaComments", comments);
        return "redirect:/cinemas/" + cinemaId;
    }


//        return "redirect:/cinemas/"+id;    }

//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public String showcinema(@PathVariable("id") Long id, ModelMap map) {
//        map.addAttribute("cinema", cinemaRepository.findOne(id));
//        map.addAttribute("cinemaComments", cinemaCommentRepository.findByCinemaId(id));
//        return "/cinemas/show";
//    }
//
//    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
//    public String editcinema(@PathVariable("id") Long id, ModelMap map) {
//        Cinema cinema = cinemaRepository.findOne(id);
//        map.addAttribute("cinema", cinema);
////        map.addAttribute("cinema", cinema);
////        return "redirect:/cinemas";
//
//        return "/cinemas/edit";
//    }
//
//    @RequestMapping(value = "/{id}/save", method = RequestMethod.POST)
//    public String savecinema(@ModelAttribute @Valid Cinema cinema, BindingResult result) {
//        if (result.hasErrors()) {
//            return "redirect:/cinemas";
////            return "cinemas/edit";
//        }
////        List<Comment> ncom = new ArrayList<>();
////        if (cinema.getComments() == null) {
////        cinema.setComments(ncom);
////        }
////        Suser suser = (Suser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
////        cinema.setSuser(suser);
//
//        cinemaRepository.save(cinema);
//        return "redirect:/cinemas";
//    }

    @RequestMapping(value = "/{idc}/delete", method = RequestMethod.GET)
    public String delcinema(@PathVariable("idc") Long id, ModelMap map) {
        Cinema cinema = cinemaCommentRepository.findOne(id).getCinema();
        cinemaCommentRepository.delete(id);
        long cinemaId = cinema.getId();

        List<CinemaComment> comments = cinemaCommentRepository.findByCinemaId(cinemaId);
        float sumRating = 0;
        float countRating = 0;
        for (CinemaComment c : comments) {
            sumRating += c.getRating();
            countRating++;
        }
        cinema.setRating(Math.round(sumRating / countRating));

        return "redirect:/cinemas/" + cinemaId;

//        map.addAttribute("cinema", cinema);
//        map.addAttribute("cinemaComments", cinemaCommentRepository.findByCinemaId(cinema.getId()));
//        return "/cinemas/show";
    }

}
