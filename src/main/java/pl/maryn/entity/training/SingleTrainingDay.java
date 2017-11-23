package pl.maryn.entity.training;

import javax.persistence.*;
import java.util.List;

@Entity
public class SingleTrainingDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Training training;

    private int trainingDayNumber;

    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Exercise> exercises;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTrainingDayNumber() {
        return trainingDayNumber;
    }

    public void setTrainingDayNumber(int trainingDayNumber) {
        this.trainingDayNumber = trainingDayNumber;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }


}
