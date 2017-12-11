package pl.maryn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.maryn.entity.training.Exercise;
import pl.maryn.entity.training.SingleTrainingDay;
import pl.maryn.repository.ExerciseRepository;
import pl.maryn.repository.SingleTrainingDayRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
public class SingleTrainingDayController {

    @Autowired
    SingleTrainingDayRepository singleTrainingDayRepository;

    @Autowired
    ExerciseRepository exerciseRepository;

    //dodawanie - formularz
    @GetMapping("/singleTrainingDay/add")
    public String showAddFormSingleTrainingDay(Model model) {
        model.addAttribute("singleTrainingDay", new SingleTrainingDay());
        return "singleTrainingDay/add";
    }

    //dodawanie singleTrainingDay
    @PostMapping(path="/singleTrainingDay/add")
    public String addSingleTrainingDay(@ModelAttribute @Valid SingleTrainingDay singleTrainingDay,
                                       BindingResult bresult, Model model) {
        if (bresult.hasErrors()) {
            return "singleTrainingDay/add";
        }
        else {
            singleTrainingDayRepository.save(singleTrainingDay);
            return "redirect:all";
        }
    }

    //singleTrainingDay - formularz
    @GetMapping(path="/singleTrainingDay/edit")
    public String showEditFormSingleTrainingDay(@RequestParam(name = "id", required = true) long id, Model model) {
        SingleTrainingDay singleTrainingDay = singleTrainingDayRepository.findOne(id);
        model.addAttribute("singleTrainingDay", singleTrainingDay);
        return "singleTrainingDay/edit";
    }

    //edycja singleTrainingDay
    @PostMapping(path="/singleTrainingDay/edit")
    public String editSingleTrainingDay(@Valid SingleTrainingDay singleTrainingDay, BindingResult bresult) {
        if (bresult.hasErrors()) {
            return "singleTrainingDay/edit";
        }
        else {
            singleTrainingDayRepository.save(singleTrainingDay);
            return "redirect:all";
        }
    }

    //usuwanie singleTrainingDay
    @GetMapping(path="/singleTrainingDay/delete")
    public String deleteSingleTrainingDay(@RequestParam(name = "id") long id) {
        singleTrainingDayRepository.delete(id);
        return "redirect:all";
    }

    //lista dni treningowych - tylko lista z tabeli singletrainingday
    @GetMapping("/singleTrainingDay/all") //   > /singleTrainingDay/all
    public String showAllSingleTrainingDay( Long id,Model model) {

            List<SingleTrainingDay> singleTrainingDays = singleTrainingDayRepository.findAll();
            model.addAttribute("singleTrainingDays", singleTrainingDays);
            return "singleTrainingDay/all";

    }

    //lista ćwiczeń
    @ModelAttribute("exerciseList")
    public List<Exercise> findAllExercise() {
        return exerciseRepository.findAll();
    }


    //lista ćwiczeń wg id dnia treningowego
    @GetMapping("/showExercises/{id}")
    public String showExercises(@PathVariable long id,  Model model) {
        SingleTrainingDay std = singleTrainingDayRepository.findById(id);
        model.addAttribute("exercisesById", std.getExercises());


        return "singleTrainingDay/another";
    }



}
