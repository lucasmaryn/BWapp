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

    @OneToMany
    private List<Exercise> exercises;

    private int trainingDay;

    public SingleTrainingDay( List<Exercise> exercises, int trainingDay) {
        this.exercises = exercises;
        this.trainingDay = trainingDay;
    }

    public SingleTrainingDay() {
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

    public int getTrainingDay() {
        return trainingDay;
    }

    public void setTrainingDay(int trainingDays) {
        this.trainingDay = trainingDays;
    }

    @Override
    public String toString() {
        return "SingleTrainingDay{" +
                "exercises=" + exercises +
                ", trainingDay=" + trainingDay +
                "\\n}";
    }
}
