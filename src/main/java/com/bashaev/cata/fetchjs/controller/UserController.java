package com.bashaev.cata.fetchjs.controller;


import com.bashaev.cata.fetchjs.model.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Рустам
 */

@Controller
public class UserController {

    @GetMapping(value = "/user")
    public String userInfo(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", user.getRoles());
        return "userpage";
    }
}
