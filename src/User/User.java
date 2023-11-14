package User;

public class User {
    private String userName;
    private userdetails userdetails;

    public User() {
        userName = "";
        userdetails = new userdetails();
    }

    public User(String name, userdetails details) {
        this.userName = name;
        this.userdetails = details;
    }

    public String getUserName()
    {
        return userName;
    }

    public userdetails getUserdetails()
    {
        return userdetails;
    }
}
