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
    private List<SingleTrainingDay> wholeTraining;

    @ManyToOne
    private User user;


    public Training() {
    }

    public Training(String name, String description, List<SingleTrainingDay> wholeTraining) {
        this.name = name;
        this.description = description;
        this.wholeTraining = wholeTraining;
    }

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

    public List<SingleTrainingDay> getWholeTraining() {
        return wholeTraining;
    }

    public void setWholeTraining(List<SingleTrainingDay> wholeTraining) {
        this.wholeTraining = wholeTraining;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Training{" +
                "wholeTraining=" + wholeTraining +
                '}';
    }
}
