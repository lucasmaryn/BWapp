package pl.maryn.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity

public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String name;

//    list for trained bodyparts or set of booleans?
    private boolean arms;

    private boolean legs;
//    ...


//    list -> set / reps
//    private ;



}
