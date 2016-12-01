package inno.controller;

import inno.model.Suser;
import inno.repository.PostReepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Controller
public class AuthController {

    @Autowired
    PostReepository repository;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/login")
    public String loginPage(@RequestParam (value = "error", required = false)Boolean error, ModelMap map){
        if(error==Boolean.TRUE){
            map.addAttribute("error", true);
        }
        return "login";
    }

    @RequestMapping("/logout")
    public String logOut(@RequestParam (value = "error", required = false)Boolean error, ModelMap map){
        if(error==Boolean.TRUE){
            map.addAttribute("error", true);
        }
        SecurityContextHolder.clearContext();
        return "redirect:/posts";
    }


    @RequestMapping(value = "/addsuser", method = RequestMethod.GET)
    public String addNewUserPage(ModelMap map) {
        map.addAttribute(new Suser());
        return "addsuser";
    }


    @RequestMapping(value = "/addsuser", method = RequestMethod.POST)
    public String addNewUser(@ModelAttribute Suser suser, BindingResult rezult) {
//        validator.validate(post, rezult);
        if (rezult.hasErrors()) return "addsuser";

        String pass = BCrypt.hashpw(suser.getPassword(), BCrypt.gensalt());
        suser.setPassword(pass);

        repository.addSuser(suser);
        return "redirect:/login";
    }

}
