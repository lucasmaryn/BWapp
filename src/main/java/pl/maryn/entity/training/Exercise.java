package pl.maryn.entity.training;


import javax.persistence.*;
import java.util.List;

@Entity

public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@NotNull
    private String name;

    private String description;

    private int setNumber;

    private int rep;

    @ManyToMany(mappedBy = "exercises")
    private List<SingleTrainingDay> singleTrainingDays;

    public List<SingleTrainingDay> getSingleTrainingDays() {
        return singleTrainingDays;
    }

    public void setSingleTrainingDays(List<SingleTrainingDay> singleTrainingDays) {
        this.singleTrainingDays = singleTrainingDays;
    }

    public String getFullDescription() {
        return this.name + " " + this.description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public int getSetNumber() {
        return setNumber;
    }

    public void setSetNumber(int setNumber) {
        this.setNumber = setNumber;
    }

    public int getRep() {
        return rep;
    }

    public void setRep(int rep) {
        this.rep = rep;
    }


}
