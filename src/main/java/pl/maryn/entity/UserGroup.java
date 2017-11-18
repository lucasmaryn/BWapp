package pl.maryn.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class UserGroup {
    //user, moderator, admin
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String name;

    private boolean isModerator;
    private boolean isAdmin;

    // superAdmin -> (isModerator and isAdmin) == true
    // user ->  (isModerator or isAdmin) == false
}
