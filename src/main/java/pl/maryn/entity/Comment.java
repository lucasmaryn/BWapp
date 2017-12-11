package pl.maryn.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String message;

    private String messageTyp;

    @ManyToOne
    private User user;

    private Date created;

    private long ratingCounter;

    private long ratingSum;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessageTyp() {
        return messageTyp;
    }

    public void setMessageTyp(String messageTyp) {
        this.messageTyp = messageTyp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public long getRatingCounter() {
        return ratingCounter;
    }

    public void setRatingCounter(long ratingCounter) {
        this.ratingCounter = ratingCounter;
    }

    public long getRatingSum() {
        return ratingSum;
    }

    public void setRatingSum(long ratingSum) {
        this.ratingSum = ratingSum;
    }
}
