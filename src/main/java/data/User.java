package data;

import lombok.Getter;

@Getter
public class User {
    private final String login;
    private final String username;
    private final String password;

    public User(String login, String username, String password) {
        this.login = login;
        this.username = username;
        this.password = password;
    }
}
