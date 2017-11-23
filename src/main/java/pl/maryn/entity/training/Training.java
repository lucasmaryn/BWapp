package pl.maryn.entity.training;

import pl.maryn.entity.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity

public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String name;

    private String description;

    @OneToMany//(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<SingleTrainingDay> trainingDaysList;

    @ManyToOne
    private User user;

//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
//    private LocalDate created;


    public Training() {
    }

    public Training(String name, String description, List<SingleTrainingDay> trainingDaysList) {
        this.name = name;
        this.description = description;
        this.trainingDaysList = trainingDaysList;
    }

//    public LocalDate getCreated() {
//        return created;
//    }
//
//    public void setCreated(LocalDate created) {
//        this.created = created;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<SingleTrainingDay> getTrainingDaysList() {
        return trainingDaysList;
    }

    public void setTrainingDaysList(List<SingleTrainingDay> trainingDaysList) {
        this.trainingDaysList = trainingDaysList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
