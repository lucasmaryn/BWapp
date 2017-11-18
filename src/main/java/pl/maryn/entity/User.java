package pl.maryn.entity;

import org.hibernate.validator.constraints.Email;
import pl.maryn.org.mindrot.jbcrypt.BCrypt;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
    private int person_group_id;


    public User() {
        this.id = 0;
        this.name = "";
        this.email = "";
        this.password = "";
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.setPassword(password);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public User(String username, String email, String password, int person_group_id) {
        this.id = 0;
        this.setName(username).setEmail(email).setPassword(password).setPersonGroupId(person_group_id);
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

    public User setPersonGroupId(int id) {
        this.person_group_id = id;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", person_group_id=" + person_group_id +
                '}';
    }
}
