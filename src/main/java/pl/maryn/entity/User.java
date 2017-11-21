package pl.maryn.entity;

import org.hibernate.validator.constraints.Email;
import pl.maryn.entity.training.Training;
import pl.maryn.org.mindrot.jbcrypt.BCrypt;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String name;

    @Email
    @Column(nullable = false, unique = true)
    private String email;

    private String salt;

    @NotNull
    private String password;
    private int group_id;

    @OneToMany
    private List<Training> trainings;


    public User() {

        this.name = "";
        this.email = "";
        this.password = "";
    }

    public User(String name, String email, String password, int group_id, List<Training> trainings) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.group_id = group_id;
        this.trainings = trainings;
    }

    public User(String username, String email, String password, int person_group_id) {

        this.setName(username).setEmail(email).setPassword(password).setGroupId(person_group_id);
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public List<Training> getTrainings() {
        return trainings;
    }

    public void setTrainings(List<Training> trainings) {
        this.trainings = trainings;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public User setName(String username) {
        this.name = username;
        return this;
    }
    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.salt = BCrypt.gensalt();
        this.password = BCrypt.hashpw(password, this.salt);
        return this;
    }

    public User setGroupId(int id) {
        this.group_id = id;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", person_group_id=" + group_id +
                '}';
    }


}
