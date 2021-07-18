package ru.training.at.hw7.providers;

import static com.google.inject.Guice.createInjector;

import di.PropertiesModule;
import ru.training.at.hw7.dto.User;

public class UsersProvider {

    public static User ROMAN = new User().set((user) -> {
        data.User roman = getUserFromProperties("Roman Iovlev");
        user.name = roman.getLogin();
        user.password = roman.getPassword();
    });

    private static data.User getUserFromProperties(String username) {
        data.User userFromProperties = createInjector(new PropertiesModule()).getInstance(data.User.class);
        if (userFromProperties.getUsername().equals(username)) {
            return userFromProperties;
        }
        throw new IllegalArgumentException("No such user in the database");
    }
}
