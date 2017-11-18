package pl.maryn.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class TrainingExerciseSet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private long user_id;

    private long training_id;

    private long exercise_id;

//    inserting list of days or multiple boolean?
//    private List<> days;

    private boolean monday;

    private boolean tuesday;

    private boolean wednesday;

    private boolean thursday;

    private boolean friday;

    private boolean saturday;

    private boolean sunday;

}
