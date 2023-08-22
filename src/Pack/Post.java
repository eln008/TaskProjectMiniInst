package Pack;

import java.time.LocalDate;
import java.util.Arrays;

public class Post {
    private int idPost;

    private String image;
    private String description;
    private LocalDate created;
    private Comment[] comments;


    public Post(int idPost, String image, String description, LocalDate created, Comment[] comments) {
        this.idPost = idPost;
        this.image = image;
        this.description = description;
        this.created = created;
        this.comments = comments;
    }

    public Post() {

    }

    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public Comment[] getComments() {
        return comments;
    }

    public void setComment(Comment[] comment) {
        this.comments = comments;
    }




    @Override
    public String toString() {
        return "Post" +
                "\nidPost=" + idPost +
                ",\nimage='" + image + '\'' +
                ",\ndescription='" + description + '\'' +
                ",\ncreated=" + created +
                ",\n \ncomment=" + Arrays.toString(comments);
    }


}
