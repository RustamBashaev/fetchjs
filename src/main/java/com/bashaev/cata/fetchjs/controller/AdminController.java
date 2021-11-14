package com.bashaev.cata.fetchjs.controller;


import com.bashaev.cata.fetchjs.model.Role;
import com.bashaev.cata.fetchjs.model.User;
import com.bashaev.cata.fetchjs.service.RoleService;
import com.bashaev.cata.fetchjs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Рустам
 */

@Controller
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/")
    public String main() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "loginpage";
    }


    @GetMapping("/admin")
    public String getAll(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("users", userService.getAll());
        model.addAttribute("allRoles", roleService.allRoles());
        return "adminpage";
    }

}
