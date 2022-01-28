package com.spring.SurveyStorage.controller;

import com.spring.SurveyStorage.entity.User;
import com.spring.SurveyStorage.model.Status;
import com.spring.SurveyStorage.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PreAuthorize("hasAuthority('developers:admin')")
    @RequestMapping("allUsers")
    public String allUsers(Model model) {
        List<User> users = userService.getAllUsers();
        users.removeIf(c -> c.getId().equals(1));
        model.addAttribute("allUsers", users);
        return "all-Nicks";
    }

    @PreAuthorize("hasAuthority('developers:admin')")
    @RequestMapping("/changeStatus")
    public String changeStatus(@RequestParam(value = "user_id") int userId) {
        User user = userService.getUser(userId);
        if (user.getStatus().equals(Status.ACTIVE)) {
            user.setStatus(Status.BANNED);
        } else user.setStatus(Status.ACTIVE);
        userService.saveUser(user);
        return "redirect:allUsers";
    }

    @RequestMapping("userRegistration")
    public String userRegistration(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user_reg";
    }

    @RequestMapping("saveUser")
    public String saveSurvey(@ModelAttribute("user") User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setStatus(Status.ACTIVE);
        userService.saveUser(user);
        return "redirect:/";
    }

    @PreAuthorize("hasAuthority('developers:admin')")
    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam("user_id") int id) {
        userService.deleteUser(id);
        return "redirect:allUsers";
    }

}
