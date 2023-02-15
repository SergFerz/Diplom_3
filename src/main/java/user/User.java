package user;

import org.apache.commons.lang3.RandomStringUtils;

public class User {
    private String name;
    private String email;
    private String password;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //создать "случайного" пользователя
    public static User getRandomUser() {
        return new User(
                "GoodUser_" + RandomStringUtils.randomAlphanumeric(4),
                RandomStringUtils.randomAlphanumeric(7) + "@yandex.ru",
                "12345678"
        );
    }

    //создать "случайного" пользователя с некорректным паролем
    public static User getRandomUserWithNonCorrectPassword() {
        return new User(
                "BadUser_" + RandomStringUtils.randomAlphanumeric(4),
                RandomStringUtils.randomAlphanumeric(7) + "@yandex.ru",
                "five1"
        );
    }
}