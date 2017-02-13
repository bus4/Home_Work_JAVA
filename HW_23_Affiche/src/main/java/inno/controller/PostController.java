package inno.controller;

import inno.model.Post;
import inno.model.Suser;
import inno.repository.PostReepository;
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
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/posts")
@Transactional
public class PostController {

    @Autowired
    PostReepository repository;

    @Autowired
    PostValidator validator;

    @RequestMapping
    public String getAllPosts(@RequestParam(value = "phraze", required = false) String phraze, ModelMap map) {
        List<Post> posts = repository.findAll();
//        List<Post> posts = new ArrayList<>();
//        for (Post postN : repository.findAll()) {
//            posts.add(postN);
//        }
//        System.out.println(posts.get(0).getSuser().getMail());
//        System.out.println(posts);

        if (phraze != null) {
            int l = posts.size();
            for (int i = 0; i < l; i++) {
                if (!(posts.get(i).getText().contains(phraze))) {
                    posts.remove(i);
                    i--;
                    l--;
                }
            }
        }
        map.addAttribute("posts", posts);

        return "posts/index";
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addNewPostPage(ModelMap map) {
        map.addAttribute(new Post());
//        return "posts/add";
        return "redirect:/posts";

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addNewPost(@ModelAttribute Post post, BindingResult rezult) {
        validator.validate(post, rezult);
        if (rezult.hasErrors()) return "/posts/add";
        Authentication auth =  SecurityContextHolder. getContext (). getAuthentication ();
        String name = auth.getName();
        post.setAuthor(name);

        Suser suser = (Suser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setSuser(suser);

        repository.add(post);
        return "redirect:/posts";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String showPost(@PathVariable("id") Long id, ModelMap map) {
        map.addAttribute("post", repository.find(id));
        return "/posts/show";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String editPost(@PathVariable("id") Long id, ModelMap map) {
        Post post = repository.find(id);
        map.addAttribute("post", post);
//        map.addAttribute("post", post);
//        return "redirect:/posts";

        return "/posts/edit";
    }


    @RequestMapping(value = "/{id}/save", method = RequestMethod.POST)
    public String savePost(@ModelAttribute @Valid Post post, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/posts";
//            return "posts/edit";
        }
//        List<Comment> ncom = new ArrayList<>();
//        if (post.getComments() == null) {
//        post.setComments(ncom);
//        }
        Suser suser = (Suser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setSuser(suser);

        repository.save(post);
        return "redirect:/posts";
    }


    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String delPost(@PathVariable("id") Long id, ModelMap map) {
        repository.remove(id);
        return "redirect:/posts";
    }

}
