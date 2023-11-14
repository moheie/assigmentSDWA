import User.User;
import java.util.HashMap;
public class UserDB {
    private static UserDB instance = null;
    private HashMap<String, User> users = new HashMap<String, User>();

    public static UserDB getInstance() {
        if (instance == null) {
            instance = new UserDB();
        }

        return instance;
    }
    public boolean check(String username)
    {
        if(users.get(username) == null)
        {
            return true;
        }
        return false;
    }

    public void updateBalance(long newBalance, String username)
    {
        User user = users.get(username);
        user.updateBalance(newBalance);
    }
}
