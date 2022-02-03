package ru.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.web.model.User;
import ru.web.service.UserService;


@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping(value="index")
    public String index(Model model){
        model.addAttribute("users", userService.getAll());
        return "index";
    }

    @GetMapping("new")
    public String newPerson(@ModelAttribute("user") User user){
        return "new";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("user", userService.select(id));
        return "/edit";
    }

    @PostMapping("/index")
    public String create(@ModelAttribute("user") User user){
        userService.save(user);
        return "redirect:/index";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.update(id, user);
        return "redirect:/index";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/index";
    }
}
