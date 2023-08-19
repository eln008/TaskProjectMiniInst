package Pack;

import java.time.LocalDate;

public class Comment {

    private int idComment;
    private String text;
    private LocalDate commentDate;

    public Comment(int idComment, String text, LocalDate commentDate) {
        this.idComment = idComment;
        this.text = text;
        this.commentDate = commentDate;
    }

    public int getIdComment() {
        return idComment;
    }

    public void setIdComment(int idComment) {
        this.idComment = idComment;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(LocalDate commentDate) {
        this.commentDate = commentDate;
    }

    @Override
    public String toString() {
        return "Comment" +
                "\nidComment=" + idComment +
                ",\ntext='" + text + '\'' +
                ",\ncommentDate=" + commentDate ;
    }

}
