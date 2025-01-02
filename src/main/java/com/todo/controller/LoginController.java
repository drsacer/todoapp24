package com.todo.controller;

import com.todo.model.User;
import com.todo.model.UserRepositoryMem;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    UserRepositoryMem userRepo;

    @GetMapping("/login")
    public String login() {
        return "login.html";
    }

    @GetMapping("/")
    public String loginIndex() {
        return "redirect:/login";
    }

    @GetMapping("/loginProcess")
    public String loginProcess(@RequestParam("email") String email, @RequestParam("password") String password,
                               Model model, HttpSession session) {
        User user = null;

        for (User u : userRepo.getUserList()) {
            if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
                user = u;
            }
        }
        if (user == null) {
            return "login.html";
        } else {
            System.out.println("User logged in: " + user);
            if (user.getType() == 1) {
                session.setAttribute("user", user);
                return "redirect:/employees";
            } else if (user.getType() == 0) {
                session.setAttribute("user", user);
                return "redirect:/todos";
            }
        }
        return "";
    }
}
