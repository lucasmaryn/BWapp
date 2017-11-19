package pl.maryn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.maryn.entity.User;
import pl.maryn.repository.UserRepository;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/login") //later login will be just a part of whole website
    public String showAddForm(Model model) {
        model.addAttribute("user", new User());
        return "user/login";
    }

    @PostMapping(path="/user/login")
    public String addBook(@Valid User user, BindingResult bresult) {
        if (bresult.hasErrors()) {
            return "user/login";
        }
        else {
            userRepository.save(user);
            return "redirect:../index";
        }
    }
}
