package org.launchcode.bartender_LiftOff_Project.cocktails.models;
import org.launchcode.bartender_LiftOff_Project.models.User;
import java.time.LocalDateTime;
import java.util.Objects;

public class Comment {

    private int id;
    private int nextId = 1;
    private LocalDateTime dateAdded;
    private User userName;
    private String contents;

    public Comment(int id, LocalDateTime dateAdded, User userName, String contents) {
        this.id = nextId;
        nextId++;
        this.dateAdded = dateAdded;
        this.userName = userName;
        this.contents = contents;
    }
//    TODO: Automatically insert the date added and username who submitted comment

    public int getId() {
        return id;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return id == comment.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
