package pl.maryn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.maryn.entity.User;
import pl.maryn.entity.training.SingleTrainingDay;
import pl.maryn.entity.training.Training;
import pl.maryn.repository.SingleTrainingDayRepository;
import pl.maryn.repository.TrainingRepository;
import pl.maryn.repository.UserRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
public class TrainingController {

    @Autowired
    TrainingRepository trainingRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    SingleTrainingDayRepository singleTrainingDayRepository;

    //dodawanie - formularz
    @GetMapping("/training/add")
    public String showAddFormTraining(Model model) {
        model.addAttribute("training", new Training());
        return "training/add";
    }

    //dodawanie training
    @PostMapping(path="/training/add")
    public String addTraining(@Valid Training training, BindingResult bresult) {
        if (bresult.hasErrors()) {
            return "training/add";
        }
        else {
            trainingRepository.save(training);
            return "redirect:..";
        }
    }

    //training - formularz
    @GetMapping(path="/training/edit")
    public String showEditFormTraining(@RequestParam(name = "id", required = true) long id, Model model) {
        Training training = trainingRepository.findOne(id);
        model.addAttribute("training", training);
        return "training/edit";
    }

    //edycja training
    @PostMapping(path="/training/edit")
    public String editTraining(@Valid Training training, BindingResult bresult) {
        if (bresult.hasErrors()) {
            return "training/edit";
        }
        else {
            trainingRepository.save(training);
            return "redirect:..";
        }
    }

    //usuwanie training
    @GetMapping(path="/training/delete")
    public String deleteTraining(@RequestParam(name = "id", required = true) long id) {
        trainingRepository.delete(id);
        return "redirect:..";
    }

    //lista treningów
    @GetMapping("/training/all")
    public String showAllTraining(Model model) {
        List<Training> trainingList = trainingRepository.findAll();
        model.addAttribute("trainingList", trainingList);
        return "training/all";
    }

    //lista użytkowników
    @ModelAttribute("userList")
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    //lista dni treningowych - form
    @ModelAttribute("singleTrainingDayList")
    public List<SingleTrainingDay> findAllSingleTrainingDay() {
        return singleTrainingDayRepository.findAll();
    }

//    @PostConstruct
//    public void initTraining() {
//        Training t1 = new Training();
//        t1.setName("trening01");
//        t1.setDescription("Zacznij na czworakach z kolanami uniesionymi " +
//                "kilka centymetrów nad podłożem. Ręce proste w łokciach rozstaw " +
//                "na szerokość barków.");
//    }


}
