package user;

import ui.BankUserView;
import ui.View;

public class BankUser extends User {
    public BankUser(String username, UserDetails userDetails) {
        super(username, userDetails);
    }

    @Override
    public View getView() {
        return new BankUserView();
    }
}
