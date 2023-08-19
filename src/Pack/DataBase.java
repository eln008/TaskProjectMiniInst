package Pack;

import java.time.LocalDate;
import java.util.Arrays;

public class DataBase {
    private User [] users;
    private Post[] posts;
    private Profile[] profiles;
    private Comment[] comments;

    private int userCount;
    private int maxUsers;

    public DataBase(User[] users, Post[] posts, Profile[] profiles, Comment[] comments, int userCount, int maxUsers) {
        this.users = users;
        this.posts = posts;
        this.profiles = profiles;
        this.comments = comments;
        this.userCount = 0;
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

    public int getUserCount() {
        return userCount;
    }

    public void setUserCount(int userCount) {
        this.userCount = userCount;
    }

    public int getMaxUsers() {
        return maxUsers;
    }

    public void setMaxUsers(int maxUsers) {
        this.maxUsers = maxUsers;
    }

    public User[] saveUser(int idUser, String userName, String userEmail, String userPassword, Profile profile) {
        if (userCount < users.length) {
            User newUser = new User(idUser, userName, userEmail, userPassword, profile);
            users[userCount] = newUser;
            userCount++;
        } else {
            System.out.println("База данных пользователей полностью заполнена.");
        }

        return Arrays.copyOf(users, userCount);
    }

    public User findUserById(int findId) {
        for (User user : users) {
            if (user.getIdUser() == findId) {
                return user;
            }
        }
        return null;
    }


    public Profile updateUserProfile(long userid, Profile newProfile){
        for (User user:users) {
            if (user.getIdUser() == userid){
                user.setProfile(newProfile);
                return newProfile;

            }
        }
        return null;
    }


    public User deleteUserById(long deleteId) {
        User deletedUser = null;
        for (int i = 0; i < users.length; i++) {
            if (users[i].getIdUser() == deleteId) {
                deletedUser = users[i];
                users[i] = null;
                return deletedUser;
            }
        }
        return null;
    }

    public Profile[] saveProfile (long saveUserId, Profile newPro){
        for (User u: users) {
            if (u.getIdUser() == saveUserId) {
                if (userCount < profiles.length) {
                    Profile newProfile = new Profile(newPro.getIdProfile(), newPro.getFullName(), newPro.getDateOfBirth(), newPro.getGender(), newPro.getBio(), newPro.getPost());
                      profiles[userCount] = newProfile;
                      userCount++;
                      return profiles;
                }
            }
        }
        return null;
    }


    public Profile findProfileByUserId (long idFindProfile, Profile profile){
        for (User u: users) {
            if (u.getIdUser()==idFindProfile){
                u.getProfile();
                return profile;
            }
        }
        return null;
    }


    public Profile deleteProfileByUserId (long userId){
        for (User u : users) {
            if(u.getIdUser() == userId){
                u.setProfile(null);
            }
        }
        return null;
    }

    public Post[] savePost (long userIdPost, Post newPost){
        for (User u: users) {
            if (u.getIdUser() == userIdPost) {
                if (userCount < posts.length) {
                    Post postNew = new Post(newPost.getIdPost(), newPost.getImage(), newPost.getDescription(), newPost.getCreated(), newPost.getComment());
                    posts[userCount] = postNew;
                    userCount++;
                    return posts;
                }
            }
        }
        return null;
    }


    public Post[] getPostsByUserId (long userId){
        for (User u: users) {
          if (  u.getIdUser()== userId){
              Profile profile = u.getProfile();
              if (profile!=null) {
                  return getPosts();
              }
          }
        }
        return null;
    }

    public Comment[] saveComment(long postId, User user, Comment comment) {
        for (Post p : posts) {
            if (p.getIdPost() == postId) {
                if(userCount < comments.length) {
                    Comment comment1 = new Comment(6,"new Text", LocalDate.of(2023,3,5));
                    comments[userCount]=comment1;
                    userCount++;
                    return comments;
                }
            }
        }
        return null;
    }


        public Comment findCommentByPostId(long postId){
        for (Post p: posts ) {
            if(p.getIdPost() == postId){
                return p.getComment();
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

    @Override
    public String toString() {
        return "DataBase{" +
                "users=" + Arrays.toString(users) +
                ", posts=" + Arrays.toString(posts) +
                ", profiles=" + Arrays.toString(profiles) +
                ", comments=" + Arrays.toString(comments) +
                ", userCount=" + userCount +
                '}';
    }
}
