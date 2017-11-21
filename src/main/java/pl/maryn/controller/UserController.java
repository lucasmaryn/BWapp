package pl.maryn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.maryn.entity.User;
import pl.maryn.repository.UserRepository;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/login") //later login will be just a part of whole website
    public String showAddUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user/login";
    }

    @PostMapping(path="/user/login")
    public String addUser(@Valid User user, BindingResult bresult) {
        if (bresult.hasErrors()) {
            return "user/login";
        }
        else {
            userRepository.save(user);
            return "redirect:../index";
        }
    }

    @PostConstruct
    public void initExercise() {
        User u1 = new User();
        u1.setName("Krab");
        u1.setEmail("asd@qwe");
        u1.setPassword("fdsaad3");
        u1.setGroupId(1);        userRepository.save(u1);

        User u2 = new User();
        u2.setName("Ryba");
        u2.setEmail("vbnm@mnb");
        u2.setPassword("fdsaad3");
        u2.setGroupId(2);
        userRepository.save(u2);
    }

    //lista ćwiczeń
    @ModelAttribute("userList")
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

}
