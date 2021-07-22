package ru.training.at.hw7.providers;

import static di.PropertiesModule.PROPERTIES_PATH;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import ru.training.at.hw7.dto.User;

public class UsersProvider {

    private static final Properties props;

    public static final String DEFAULT_USERNAME = "Roman Iovlev";

    static {
        props = new Properties();
        try {
            props.load(UsersProvider.class.getResourceAsStream(PROPERTIES_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static User DEFAULT_USER = new User().set(user -> {
        user.name = props.getProperty("login");
        user.password = props.getProperty("password");
    });

    private static final Map<String, User> usernameToUser;

    static {
        usernameToUser = new HashMap<>();
        usernameToUser.put(DEFAULT_USERNAME, DEFAULT_USER);
    }

    public static User getUserByUsername(String username) {
        if (!usernameToUser.containsKey(username)) {
            throw new IllegalArgumentException(
                String.format("User with username %s is not specified", username)
            );
        }
        return usernameToUser.get(username);
    }
}
