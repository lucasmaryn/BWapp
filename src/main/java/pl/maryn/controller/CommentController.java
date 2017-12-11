package pl.maryn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.maryn.entity.Comment;
import pl.maryn.repository.CommentRepository;

import javax.validation.Valid;
import java.util.Date;

public class CommentController {

    @Autowired
    CommentRepository commentRepository;

    //dodawanie - formularz
    @GetMapping("/comment/add")
    public String showAddFormComment(Model model) {
        model.addAttribute("comment", new Comment());
        return "comment/add";
    }

    //dodawanie komentarz
    @PostMapping(path="/comment/add")
    public String addSingleTrainingDay(@ModelAttribute @Valid Comment comment,
                                       BindingResult bresult, Model model) {

        if (bresult.hasErrors()) {
            return "comment/add";
        }
        else {

            comment.setCreated(new Date());
            commentRepository.save(comment);
            return "redirect:..";
        }
    }
}
