package Entity;

import java.util.Date;

public class Post {
    private int ID_publication;
    private String description;
    private Date date_creation;
    private int count_like;
    private int count_comment;
    private String last_name;
    private String first_name;
    private String pseudo;

    public int getID_publication() { return ID_publication; }

    public void setID_publication(int ID_publication) {
        this.ID_publication = ID_publication;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    public int getCount_like() {
        return count_like;
    }

    public void setCount_like(int count_like) {
        this.count_like = count_like;
    }

    public int getCount_comment() {
        return count_comment;
    }

    public void setCount_comment(int count_comment) {
        this.count_comment = count_comment;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
}
