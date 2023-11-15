package user;

import ui.BankUserView;
import ui.View;

public class BankUser extends User {
    public BankUser(UserDetails userDetails) {
        super(userDetails);
    }

    @Override
    public View getView() {
        return new BankUserView();
    }
}
