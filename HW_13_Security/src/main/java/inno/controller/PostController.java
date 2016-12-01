package inno.controller;

import inno.model.Post;
import inno.model.Student;
import inno.model.SubjektType;
import inno.repository.PostReepository;
import inno.util.validators.PostValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Альберт on 13.11.2016.
 */
@Controller
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostReepository repository;

    @Autowired
    PostValidator validator;

    @RequestMapping
    public String getAllPosts(@RequestParam(value = "phraze", required = false) String phraze, ModelMap map) {
        List<Post> posts = new ArrayList<>();
        for (Post postN : repository.findAll()) {
            posts.add(postN);
        }

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

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public String getAllStudents(@RequestParam(value = "phraze", required = false) String phraze, ModelMap map) {
        List<Student> students = new ArrayList<>();
//        List<Student> scores = new ArrayList<>();
        Map<Student, Long> sumMap = new HashMap<>();
        Map<Student, Long> avgMap = new HashMap<>();
        Map<Student, Long> avgPMap = new HashMap<>();
        SubjektType sbj = SubjektType.Философия;

        for (Student studentN : repository.findAllS()) {
            students.add(studentN);
            sumMap.put(studentN, repository.sumScore(studentN.getId()));
            avgMap.put(studentN, repository.avgScore(studentN.getId()));
            avgPMap.put(studentN, repository.avgScoreP(studentN.getId(), sbj));
        }

        if (phraze != null) {
            int l = students.size();
            for (int i = 0; i < l; i++) {
                if (!(students.get(i).getSurname().contains(phraze))) {
                    students.remove(i);
                    i--;
                    l--;
                }
            }
        }
        map.addAttribute("students", students);
        map.addAttribute("summap", sumMap);
        map.addAttribute("avgmap", avgMap);
        map.addAttribute("avgpmap", avgPMap);
        map.addAttribute("sbj", sbj);

//        List<Student> students = new ArrayList<>();
//        for (Student studentN : repository.findAllS()) {
//            students.add(studentN);
//        }
//        System.out.println("Сумма оценок студента 1 = " + );
//        String sumS = repository.sumScore(idd)
//
//        Long idd= 1L;
//        String sbj = "Философия";
//        System.out.println("Среднее оценок студента 1 = " + repository.avgScore(idd));
//        System.out.println("Среднее оценок студента 1 по Философии = " + repository.avfScoreP(idd,sbj));
        return "students/indexs";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addNewPostPage(ModelMap map) {
        map.addAttribute(new Post());
//        return "redirect:/autorizatetest";
        return "posts/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addNewPost(@ModelAttribute Post post, BindingResult rezult) {
        validator.validate(post, rezult);
        if (rezult.hasErrors()) return "/posts/add";
        Authentication auth =  SecurityContextHolder. getContext (). getAuthentication ();
        String name = auth.getName();
        post.setAuthor(name);
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
        return "/posts/edit";
    }


    @RequestMapping(value = "/{id}/save", method = RequestMethod.POST)
    public String savePost(@ModelAttribute @Valid Post post, BindingResult result) {
        if (result.hasErrors()) {
            return "posts/edit";
        }
        repository.save(post);
        return "redirect:/posts";
    }


    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
//    @PreAuthorize("#postAuthor = prilcipal.")
    public String delPost(@PathVariable("id") Long id, ModelMap map) {
        repository.remove(id);
        return "redirect:/posts";
    }

}
