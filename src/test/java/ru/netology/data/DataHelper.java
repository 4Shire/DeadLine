package ru.netology.data;

import com.github.javafaker.Faker;

public class DataHelper {
    public DataHelper() {
    }

    public static UserInfo generateUserInfo() {
        String login = "ivan";
        String password = "qwerty12345";
        return new UserInfo("ivan", "qwerty12345");
    }

    public static UserInfo getInvalidLogin() {
        Faker faker = new Faker();
        return new UserInfo(faker.name().firstName(), "qwerty12345");
    }

    public static UserInfo getInvalidPassword() {
        Faker faker = new Faker();
        return new UserInfo("ivan", faker.internet().password());
    }
}
