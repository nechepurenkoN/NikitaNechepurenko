package ru.training.at.hw7.providers;

import static di.PropertiesModule.PROPERTIES_PATH;

import java.io.IOException;
import java.util.Properties;
import ru.training.at.hw7.dto.User;

public class UsersProvider {

    private static final Properties props;

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

}
