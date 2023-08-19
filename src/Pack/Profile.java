package Pack;

import java.time.LocalDate;
import java.util.Arrays;

public class Profile {
    private int idProfile;
    private String fullName;
    private LocalDate dateOfBirth;
    private String gender;
    private String bio;
    private Post[] post;



    public Profile(int idProfile, String fullName, LocalDate dateOfBirth, String gender, String bio, Post[] post) {
        this.idProfile = idProfile;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.bio = bio;
        this.post = post;
    }

    public Profile() {

    }

    public int getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(int idProfile) {
        this.idProfile = idProfile;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Post[] getPost() {
        return post;
    }

    public void setPost(Post[] post) {
        this.post = post;
    }

    public Post searchPost(String query, Profile[] profiles) {
        for (Profile profile : profiles) {
            for (Post post : profile.getPost()) {
                if (post.getDescription().contains(query)) {
                    return post;
                }
            }
        }
        return null;
    }

    public boolean deletePostById(long id) {
        boolean deletePost = false;
        Post[] oldPosts = Arrays.copyOf(getPost(), getPost().length);
        Post[] posts = new Post[oldPosts.length-1];
        for (int i = 0; i < oldPosts.length-1; i++) {
            if (!deletePost && oldPosts[i].getIdPost() != id){
                posts[i] = oldPosts[i];
            }else {
                deletePost = true;
            }
            if (deletePost){
                posts[i] = oldPosts[i+1];
            }
        }
        setPost(posts);

        return deletePost;
    }






    @Override
    public String toString() {
        return "Profile" +
                "\nidProfile=" + idProfile +
                ",\nfullName='" + fullName + '\'' +
                ",\ndateOfBirth=" + dateOfBirth +
                ",\ngender='" + gender + '\'' +
                ",\nbio='" + bio + '\'' +
                ",\n \npost=" + post +
                '\n';
    }
}
