package Pack;


public class User {
    private int idUser;
    private String userName;
    private String userEmail;
    private String userPassword;
    private Profile profile;


    public User(int idUser, String userName, String userEmail, String userPassword, Profile profile) {
        this.idUser = idUser;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.profile = profile;
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

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }





    @Override
    public String toString() {
        return "User" +
                "idUser=" + idUser +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", \n \nprofile=" + profile +
                '\n';
    }
}
