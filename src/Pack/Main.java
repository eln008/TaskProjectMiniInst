package Pack;

import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Comment comment1 = new Comment(1, "comment 1 ", LocalDate.of(2023, 6, 23));
        Comment comment2 = new Comment(2, "comment 2 ", LocalDate.of(2023, 7, 4));
        Comment comment3 = new Comment(3, "comment 3 ", LocalDate.of(2023, 4, 17));
        Comment comment4 = new Comment(4, "comment 4 ", LocalDate.of(2023, 7, 15));
        Comment comment5 = new Comment(5, "comment 5 ", LocalDate.of(2023, 5, 20));
        Comment comment6 = new Comment(6, "comment 6 ", LocalDate.of(2023, 4, 2));
        Comment comment7 = new Comment(7, "comment 7 ", LocalDate.of(2023, 1, 25));
        Comment[] comments1 = {comment7, comment6,comment1};
        Comment[] comments2 = {comment4, comment5};
        Comment[] comments3 = {comment2, comment3};
        Comment[] comments4 = {comment3, comment5};
        Comment[] comments5 = {comment7, comment1};

        Comment[] comments = {comment1,comment2,comment3,comment4,comment5};


        Post post = new Post();
        Post post1 = new Post(1, "image1.jpg", "Description 1", LocalDate.of(2023, 7, 6), comments1);
        Post post2 = new Post(2, "image2.jpg", "Description 2", LocalDate.of(2023, 8, 10),comments2);
        Post post3 = new Post(3, "image3.jpg", "Description 3", LocalDate.of(2023, 1, 12), comments3);
        Post post4 = new Post(4, "image4.jpg", "Description fir 4", LocalDate.of(2023, 5, 17), comments4);
        Post post5 = new Post(5, "image5.jpg", "Description 5", LocalDate.of(2023, 6, 20), comments5);
        Post[] posts1 = {post1};
        Post[] posts2 = {post2,post4};
        Post[] posts3 = {post3};
        Post[] posts4 = {post4,post1};
        Post[] posts5 = {post5,post2};
        Post[] posts = {post1,post2,post3, post4, post5};

        Profile profile = new Profile();
        Profile profile1 = new Profile(1, "full name1", LocalDate.of(2000, 9, 12), "Female", "Bio  1", posts1);
        Profile profile2 = new Profile(2, "full name2", LocalDate.of(2001, 12, 23), "Male", "Bio  2", posts2);
        Profile profile3 = new Profile(3, "full name3", LocalDate.of(2009, 8, 3), "Female", "Bio  3", posts3);
        Profile profile4 = new Profile(4, "full name4", LocalDate.of(1999, 4, 28), "Male", "Bio  4", posts4);
        Profile profile5 = new Profile(5, "full name5", LocalDate.of(1998, 7, 17), "Female", "Bio  5", posts5);
        Profile[] profiles1 = {profile1};
        Profile[] profiles2 = {profile2, profile4};
        Profile[] profiles3 = {profile5, profile1};
        Profile[] profiles4 = {profile3};
        Profile[] profiles5 = {profile4};

        Profile[] profiles = {profile1, profile2, profile3 ,profile4, profile5};

        User user1 = new User(1, "User name1", "email1", "ty7ty", profiles1);
        User user2 = new User(2, "User name2", "email2", "4rtt3", profiles2);
        User user3 = new User(3, "User name3", "email3", "7y6g2", profiles3);
        User user4 = new User(4, "User name4", "email4", "0p9o1", profiles4);
        User user5 = new User(5, "User name5", "email5", "0p4ld", profiles5);
        User[] users = {user1, user2, user3, user4, user5};

        DataBase dataBase = new DataBase(users,posts, profiles, comments,100);

        int choice;
        do {
            System.out.println("Выберите операцию:");
            System.out.println("1. Добавить пользователя");
            System.out.println("2. Найти пользователя по ID");
            System.out.println("3. Обновить профиль пользователя");
            System.out.println("4. Удалить пользователя по ID");
            System.out.println("5. Сохранить профиль");
            System.out.println("6. Найти профиль по ID пользователя");
            System.out.println("7. Удалить профиль по ID пользователя");
            System.out.println("8. Сохранить пост");
            System.out.println("9. Получить посты по ID пользователя");
            System.out.println("10. Поиск постов по ключевому слову");
            System.out.println("11. Удалить пост по ID");
            System.out.println("12. Добавить комментарий");
            System.out.println("13. Найти комментарии к посту");
            System.out.println("14. Обновить комментарий");
            System.out.println("15. Удалить комментарий");
            System.out.println("0. Выход");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    User[] updatedUsers = dataBase.saveUser(6, "New User", "newemail@example.com", "newpassword", profile2);
                    System.out.println("Новый пользователь добвален! ");
                    for (User user : updatedUsers) {
                        if (user != null) {
                            System.out.println(user);
                        }
                    }
                    break;
                case 2:
                    User foundUser = dataBase.findUserById(4);
                    if (foundUser != null){
                        System.out.println(foundUser);
                    }else {
                        System.out.println("пользователь с таким ID не найден");
                    }
                    break;
                case 3:
                    System.out.println(dataBase.updateUserProfile(4, profiles1));
                    break;
                case 4:
                    System.out.println(dataBase.deleteUserById(3));
                    break;
                case 5:
                    System.out.println(Arrays.toString(dataBase.saveProfile(3, new Profile(6, "new full name", LocalDate.of(1999, 7, 17), "Female", "Bio  5", posts5))));
                    break;
                case 6:
                    System.out.println(Arrays.toString(dataBase.findProfileByUserId(4)));
                    break;
                case 7:
                    System.out.println(Arrays.toString(dataBase.deleteProfileByUserId(5)));

                case 8:
                    System.out.println(Arrays.toString(dataBase.savePost(6, new Post(6,"image 6 new ", "description example new", LocalDate.of(2023, 12, 19), comments4))));
                    break;
                case 9:
                    System.out.println("Удаленный профиль: "+Arrays.toString(profile.getPostsByUserId(1)));
                    break;
                case 10:
                    System.out.println(dataBase.searchPost("fir",profiles));
                    break;
                case 11:
                    System.out.println(profile.deletePostById(1));
                    break;
                case 12:
                    System.out.println(Arrays.toString(dataBase.saveComment(3,user1,comment1)));
                    break;
                case 13:
                    System.out.println(Arrays.toString(dataBase.findCommentByPostId(2)));
                    break;
                case 14:
                    System.out.println(dataBase.updateComment(3,"new text comment"));
                    break;
                case 15:
                    System.out.println("удаленный коммент:  \n"+dataBase.deleteComment(comment1));
                    break;
                case 0:
                    System.out.println("Программа завершена.");
                    break;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, выберите существующий вариант.");
            }
        } while (choice != 0);

        scanner.close();











    }
}