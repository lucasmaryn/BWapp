package pl.maryn.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity

public class Diet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String name;
}