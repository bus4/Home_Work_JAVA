package inno.controller;

import inno.model.Suser;
import inno.service.UserService;
import inno.util.form.UserForm;
import inno.util.validators.SuserValidator;
import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;
import java.util.Calendar;

@Controller
public class AuthController {

    final Logger log = LogManager.getLogger(AuthController.class.getName());

    @Autowired
    UserService userService;

    @Autowired
    SuserValidator suserValidator;

    public AuthController() throws UnsupportedEncodingException, FileNotFoundException {
    }

    @RequestMapping("/junior-3")
    public String jun() {
        return "redirect:/junior-3/welcome";
    }

    @RequestMapping("/junior-3/welcome")
    public String welcome(@RequestParam(value = "error", required = false) Boolean error,
                          ModelMap map, HttpServletResponse response) {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        String timesOfDay;
        if (hour > 5 & hour < 10) {
            timesOfDay = "Доброе утро";
        } else if (hour > 9 & hour < 18) {
            timesOfDay = "Добрый день";
        } else if (hour > 17 & hour < 22) {
            timesOfDay = "Добрый вечер";
        } else {
            timesOfDay = "Доброй ночи";
        }
        map.addAttribute("timesOfDay", timesOfDay);
        Suser suser = (Suser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        response.addCookie(new Cookie("defaultSuser", suser.getMail()));
        return "/junior-3/welcome";
    }

    @RequestMapping("/junior-3/sign-in")
    public String loginPage(@RequestParam(value = "error", required = false) Boolean error, ModelMap map,
                            @CookieValue(value = "defaultSuser", defaultValue = "") String defaultSuser) {
        if (error == Boolean.TRUE) {
            map.addAttribute("error", true);
        }
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal().getClass().equals(Suser.class)) {
            return "redirect:/junior-3/welcome";
        }
        map.addAttribute("defaultSuser", defaultSuser);
        return "/junior-3/sign-in";
    }

    @RequestMapping("/logout")
    public String logOut(@RequestParam(value = "error", required = false) Boolean error, ModelMap map) {
        if (error == Boolean.TRUE) {
            map.addAttribute("error", true);
        }
        SecurityContextHolder.clearContext();
        return "redirect:/junior-3";
    }


    @RequestMapping(value = "/junior-3/sign-up", method = RequestMethod.GET)
    public String addNewUserPage(ModelMap map) {
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal().getClass().equals(Suser.class)) {
            return "redirect:/junior-3/welcome";
        }
        map.addAttribute("userForm", new UserForm());
        return "junior-3/sign-up";
    }

    @RequestMapping(value = "/junior-3/sign-up", method = RequestMethod.POST)
    public String addNewUser(@ModelAttribute("userForm") @Valid UserForm form, BindingResult rezult, ModelMap map) {
        String mail = form.getMail().trim();
        form.setMail(mail);
        suserValidator.validate(form, rezult);
        if (rezult.hasErrors()) return "junior-3/sign-up";
        userService.saveUser(form);
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(form.getMail(), form.getPassword()));
        return "redirect:/junior-3/welcome";
    }

    @RequestMapping(value = "/runtimeException", method = RequestMethod.GET)
    public void throwException( ) {
        throw new RuntimeException();
    }

    @ExceptionHandler(Exception.class)
    public String exeptionHand() {
        log.error("Unexpected error!");
        return "junior-3/error";
    }


}
