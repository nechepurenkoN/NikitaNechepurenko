package data;

import lombok.Value;

@Value
public class User {
    String login;
    String username;
    String password;

    public User(String login, String username, String password) {
        this.login = login;
        this.username = username;
        this.password = password;
    }
}
