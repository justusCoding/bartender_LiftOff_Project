package org.launchcode.bartender_LiftOff_Project.cocktails.models;
import org.launchcode.bartender_LiftOff_Project.models.AbstractEntity;
import org.launchcode.bartender_LiftOff_Project.models.User;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Comment extends AbstractEntity {

    private LocalDateTime dateAdded;

    @OneToOne
    @NotNull
    @Valid
    private User userName;

    @Size(min = 5, max = 500, message = "Comments must be between 5 and 500 characters.")
    private String contents;

    @ManyToOne
    private Recipe recipe;

    public Comment(LocalDateTime dateAdded, User userName, String contents) {
        this.dateAdded = dateAdded;
        this.userName = userName;
        this.contents = contents;
    }

    public Comment(){}

//    TODO: Automatically insert the date added and username who submitted comment
    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDateTime dateAdded) {
        this.dateAdded = dateAdded;
    }

    public User getUserName() {
        return userName;
    }

    public void setUserName(User userName) {
        this.userName = userName;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

}
