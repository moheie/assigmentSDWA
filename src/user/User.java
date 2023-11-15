package user;

import provider.client.ProviderClient;
import ui.View;

public abstract class User {
    private UserDetails userDetails;

    public User() {
        userDetails = new UserDetails();
    }

    public User(UserDetails details) {
        this.userDetails = details;
    }


    public UserDetails getDetails() {
        return userDetails;
    }

    public long getBalance() {
        ProviderClient client = getProviderClient();

        return client.getBalance(userDetails);
    }
    
    public abstract View getView();

    public boolean checkPassword(String inputPassword) {
        String password = getDetails().getPassword();

        return password.equals(inputPassword);
    }
    public abstract ProviderClient getProviderClient();
}
