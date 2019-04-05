package com.codegym.controllers;

import com.codegym.dao.UserDao.UserDao;
import com.codegym.model.Login.Login;
import com.codegym.model.User.User;
import org.springframework.asm.Handle;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

@Controller
public class UserController {
    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("login",new Login());
        return "home";
    }
    @PostMapping("/login")
    public String login(@ModelAttribute("login") Login login , Model model) {
       UserDao userDao = new UserDao();
       User user = userDao.checkLogin(login);
       if (user == null) {
           return "error";
       }else {
           model.addAttribute("user", user);
           return "user";
       }
    }



}
