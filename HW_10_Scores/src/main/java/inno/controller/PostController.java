package inno.controller;

import inno.model.Student;
import inno.model.SubjektType;
import inno.repository.PostReepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostReepository repository;

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

        return "students/indexs";
    }
}
