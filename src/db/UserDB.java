package db;

import ui.View;
import user.User;
import user.UserDetails;
import user.UserFactory;

import java.util.HashMap;
public class UserDB {
    UserFactory factory;
    private static UserDB instance = null;
    private HashMap<String,User> users = new HashMap<String, User>();

    public static UserDB getInstance() {
        if (instance == null) {
            instance = new UserDB();
        }

        return instance;
    }

    private UserDB() {}
    
    public User get(String username) {
        return users.get(username.toLowerCase());
    }

    public boolean has(String username) {
        return get(username) != null;
    }

    /* public void updateBalance(long newBalance, String username)
    {
        User user = users.get(username);
        user.updateBalance(newBalance);
    } */

    public void insertUser(UserDetails details, String username){
        users.put(username,factory.createUser(username,details));

    }
}
