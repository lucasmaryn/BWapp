package pl.maryn.entity;

import javax.persistence.*;

@Entity
public class UserGroup {
    //user, moderator, admin
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userClass;

//    @OneToOne
//    private User userId;

}
