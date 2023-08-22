package Pack;


import java.util.Arrays;

public class User {
    private int idUser;
    private String userName;
    private String userEmail;
    private String userPassword;
    private Profile[] profiles;


    public User(int idUser, String userName, String userEmail, String userPassword, Profile[] profiles) {
        this.idUser = idUser;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.profiles = profiles;
    }

    public User() {

    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Profile[] getProfile() {
        return profiles;
    }

    public void setProfile(Profile[] profile) {
        this.profiles = profiles;
    }





    @Override
    public String toString() {
        return "User" +
                "idUser=" + idUser +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", \n \nprofile=" + Arrays.toString(profiles) +
                '\n';
    }


}
