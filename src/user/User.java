package user;

import ui.View;

public abstract class User {
    private UserDetails userDetails;

    public User() {
        userDetails = new UserDetails();
    }

    public User(UserDetails details) {
        this.userDetails = details;
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
