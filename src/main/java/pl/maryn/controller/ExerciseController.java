package pl.maryn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.maryn.entity.training.Exercise;
import pl.maryn.repository.ExerciseRepository;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.List;

@Controller
public class ExerciseController {

    @Autowired
    ExerciseRepository exerciseRepository;

    //dodawanie - formularz
    @GetMapping("/exercise/add")
    public String showAddFormExercise(Model model) {
        model.addAttribute("exercise", new Exercise());

        List<Exercise> exercises = exerciseRepository.findAll();
        model.addAttribute("exercises", exercises);
        return "/exercise/add";
    }

    //dodawanie ćwiczenia
    @PostMapping(path="/exercise/add")
    public String addExercise(@Valid Exercise exercise, BindingResult bresult) {
        if (bresult.hasErrors()) {
            return "/exercise/add";
        }
        else {
            exerciseRepository.save(exercise);
            return "redirect:all";
        }
    }

    //edycja - formularz
    @GetMapping(path="/exercise/edit")
    public String showEditFormExercise(@RequestParam(name = "id", required = true) long id, Model model) {
        Exercise exercise = exerciseRepository.findOne(id);
        model.addAttribute("exercise", exercise);
        return "/exercise/edit";
    }

    //edycja ćwiczenia
    @PostMapping(path="/exercise/edit")
    public String editExercise(@Valid Exercise exercise, BindingResult bresult) {
        if (bresult.hasErrors()) {
            return "/exercise/edit";
        }
        else {
            exerciseRepository.save(exercise);
            return "redirect:all";
        }
    }

    //usuwanie ćwiczenia
    @GetMapping(path="/exercise/delete")
    public String deleteExercise(@RequestParam(name = "id", required = true) long id) {
        exerciseRepository.delete(id);
        return "redirect:all";
    }

    //lista ćwiczeń
    @GetMapping("/exercise/all")
    public String showAllExercise(Model model) {
        List<Exercise> exercises = exerciseRepository.findAll();
        model.addAttribute("exercises", exercises);
        return "exercise/all";
    }


    @PostConstruct
    public void initExercise() {
        Exercise e1 = new Exercise();
        e1.setName("Krab");
        e1.setDescription("Zacznij na czworakach z kolanami uniesionymi " +
                "kilka centymetrów nad podłożem. Ręce proste w łokciach rozstaw " +
                "na szerokość barków.");
        e1.setSetNumber(3);
        e1.setRep(10);
        exerciseRepository.save(e1);

        Exercise e2 = new Exercise();
        e2.setName("Krokodylek");
        e2.setDescription("Wyprostuj nogi w kolanach, by przyjąć pozycję do pompki. " +
                "Zginając ręce w łokciach, zrób pompkę." +
                "Przyciągnij nogi do klatki, aż przejdziesz do przysiadu podpartego.");
        e2.setSetNumber(2);
        e2.setRep(8);
        exerciseRepository.save(e2);

        Exercise e3 = new Exercise();
        e3.setName("Podciąganie nachwytem");
        e3.setDescription("Wstań i podskocz, by drążek złapać nachwytem trochę szerszym " +
                "niż na szerokość barków. Nogi ugnij w kolanach i skrzyżuj w kostkach. " +
                "Podciągnij się, aż brodą miniesz drążek. Próbę możesz uznać za zaliczoną " +
                "również wtedy, gdy klatką dotkniesz drążka.");
        e3.setSetNumber(4);
        e3.setRep(5);
        exerciseRepository.save(e3);
    }


}
