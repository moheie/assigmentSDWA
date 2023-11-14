package user;

import ui.View;

public abstract class User {
    private String userName;
    private UserDetails userDetails;

    public User() {
        userName = "";
        userDetails = new UserDetails();
    }

    public User(String name, UserDetails details) {
        this.userName = name;
        this.userDetails = details;
    }

    public String getUserName()
    {
        return userName;
    }

    public UserDetails getDetails()
    {
        return userDetails;
    }
    
    public abstract View getView();

    public void updateBalance(long balance)
    {
        userDetails.setBalance(balance);
    }

    public boolean checkPassword(String inputPassword) {
        String password = getDetails().getPassword();

        return password.equals(inputPassword);
    }
}
