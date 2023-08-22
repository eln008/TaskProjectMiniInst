package Pack;

import java.time.LocalDate;
import java.util.Arrays;

public class DataBase {
    private User [] users;
    private Post[] posts;
    private Profile[] profiles;
    private Comment[] comments;

    private int maxUsers;

    public DataBase(User[] users, Post[] posts, Profile[] profiles, Comment[] comments,  int maxUsers) {
        this.users = users;
        this.posts = posts;
        this.profiles = profiles;
        this.comments = comments;
        this.maxUsers = maxUsers;

    }

    public User[] getUsers() {
        return users;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }

    public Post[] getPosts() {
        return posts;
    }

    public void setPosts(Post[] posts) {
        this.posts = posts;
    }

    public Profile[] getProfiles() {
        return profiles;
    }

    public void setProfiles(Profile[] profiles) {
        this.profiles = profiles;
    }

    public Comment[] getComments() {
        return comments;
    }

    public void setComments(Comment[] comments) {
        this.comments = comments;
    }

    public int getMaxUsers() {
        return maxUsers;
    }

    public void setMaxUsers(int maxUsers) {
        this.maxUsers = maxUsers;
    }

    public User[] saveUser(int idUser, String userName, String userEmail, String userPassword, Profile profile) {
        if (idUser < users.length) {
            User newUser = new User(idUser, userName, userEmail, userPassword, profiles);
            users[idUser] = newUser;
            idUser++;
        } else {
            System.out.println("База данных пользователей полностью заполнена.");
        }

        return Arrays.copyOf(users, idUser);
    }

    public User findUserById(int findId) {
        for (User user : users) {
            if (user.getIdUser() == findId) {
                return user;
            }
        }
        return null;
    }


    public Profile[] updateUserProfile(long userid, Profile[] newProfile){
        for (User user:users) {
            if (user.getIdUser() == userid){
                user.setProfile(newProfile);
                return newProfile;

            }
        }
        return null;
    }


    public boolean deleteUserById(long deleteId) {
        int indexToDelete = -1;

        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && users[i].getIdUser() == deleteId) {
                indexToDelete = i;
                break;
            }
        }
        if (indexToDelete != -1) {
            User[] newUsers = new User[users.length - 1];
            System.arraycopy(users, 0, newUsers, 0, indexToDelete);
            System.arraycopy(users, indexToDelete + 1, newUsers, indexToDelete, users.length - indexToDelete - 1);
            users = newUsers;

            return true;
        }
        return false;
    }




    public Profile[] saveProfile(long saveUserId, Profile newProfile) {
        for (User u : users) {
            if (u.getIdUser() == saveUserId) {
                if (u.getIdUser() < profiles.length) {
                    newProfile.setIdProfile(newProfile.getIdProfile() + 1);
                    profiles[u.getIdUser()] = newProfile;
                    return profiles;
                }
            }
        }
        return null;
    }



    public Profile[] findProfileByUserId(long idFindProfile) {
        for (User u : users) {
            if (u.getIdUser() == idFindProfile) {
                return u.getProfile();
            }
        }
        return null;
    }



    public Profile[] deleteProfileByUserId (long userId){
       boolean found = false;
       Profile[] oldProfiles = Arrays.copyOf(getProfiles(), getProfiles().length);
       Profile[] profiles1 = new Profile[oldProfiles.length-1];
        for (int i = 0; i < oldProfiles.length-1; i++) {
            if(!found && oldProfiles[i].getIdProfile() != userId){
            }else {
                found = true;
            }
            if (found){
                profiles1[i] = oldProfiles[i+1];
            }
            return profiles1;
        }
        return null;
    }


    public Post[] savePost(long userIdPost, Post newPost) {
        for (User u : users) {
            if (u.getIdUser() == userIdPost) {
                if (u.getIdUser() < posts.length) {
                    Post postNew = new Post(newPost.getIdPost(), newPost.getImage(), newPost.getDescription(), newPost.getCreated(), newPost.getComments());
                    posts[u.getIdUser()] = postNew;
                    return posts;
                }
            }
        }
        return null;
    }



    public Comment[] saveComment(long postId, User user, Comment comment) {
        int maxId = -1;

        for (Post p : posts) {
            if (p != null && p.getIdPost() > maxId) {
                maxId = p.getIdPost();
            }
        }
        int newIdPost = maxId + 1;

        for (Post p : posts) {
            if (p.getIdPost() == postId) {
                if (newIdPost < comments.length) {
                    Comment comment1 = new Comment(newIdPost, comment.getText(), comment.getCommentDate());
                    comments[newIdPost] = comment1;
                    return comments;
                }
            }
        }
        return null;
    }



    public Comment[] findCommentByPostId(long postId){
        for (Post p: posts ) {
            if(p.getIdPost() == postId){
                return p.getComments();
            }
        }
        return null;
    }


    public String updateComment (long commentId, String newText){
        for (Comment c: comments) {
           if (c.getIdComment()==commentId){
               c.setText (newText);
               return "Новый текст: "+newText;
           }
        }
        return null;
    }

    public Comment deleteComment (Comment comment) {
        for (int i = 0; i < comments.length; i++) {
            if (comments[i].equals(comment)){

                Comment deletedComment = comments[i];

                for (int j = i; j < comments.length - 1; j++) {
                    comments[j] = comments[j + 1];
                }

                comments[comments.length - 1] = null;

                return deletedComment;
            }
        }
        return null;

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

    @Override
    public String toString() {
        return "DataBase{" +
                "users=" + Arrays.toString(users) +
                ", posts=" + Arrays.toString(posts) +
                ", profiles=" + Arrays.toString(profiles) +
                ", comments=" + Arrays.toString(comments) +
                '}';
    }
}
