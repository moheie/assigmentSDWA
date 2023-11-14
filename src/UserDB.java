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


}
