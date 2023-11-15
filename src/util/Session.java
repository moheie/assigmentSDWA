package util;
import user.User;

public class Session {
    private User user = null;
    private static Session instance = null;

    public static Session getInstance()
    {
        if(instance == null)
            instance = new Session();
        return instance;
    }

    public void setUser(User user){
        this.user = user;
    }

    public User getUser(){
        return user;
    }


}
