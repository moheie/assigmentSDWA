package db;

import ui.View;
import user.User;
import user.UserDetails;
import user.UserFactory;

import java.util.HashMap;
public class UserDB {
    private static UserDB instance = null;
    private UserFactory factory = new UserFactory();
    private HashMap<String, User> users = new HashMap<String, User>();

    public static UserDB getInstance() {
        if (instance == null) {
            instance = new UserDB();
        }

        return instance;
    }

    public User get(String username) {
        return users.get(username.toLowerCase());
    }

    public boolean has(String username) {
        return get(username) != null;
    }

    public User add(UserDetails details){
        String username = details.getUsername().toLowerCase();
        User user = factory.createUser(details);

        users.put(username, user);

        return user;
    }

    /* public void updateBalance(long newBalance, String username)
    {
        User user = users.get(username);
        user.updateBalance(newBalance);
    } */
}
