package di;

import com.google.inject.AbstractModule;
import data.User;
import java.util.Properties;
import lombok.SneakyThrows;

public class PropertiesModule extends AbstractModule {
    private static final String PROPERTIES_PATH = "/data/usercredentials.properties";

    @Override
    protected void configure() {
        var user = readUserFromProperties();
        bind(User.class)
            .toInstance(user);
    }

    @SneakyThrows
    private User readUserFromProperties() {
        Properties prop = new Properties();
        prop.load(this.getClass().getResourceAsStream(PROPERTIES_PATH));
        return new User(
            prop.getProperty("login"),
            prop.getProperty("username"),
            prop.getProperty("password")
        );
    }

}
