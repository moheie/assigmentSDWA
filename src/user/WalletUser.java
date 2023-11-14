package user;

import ui.View;
import ui.WalletUserView;

public class WalletUser extends User {
    public WalletUser(String username, UserDetails userDetails) {
        super(username, userDetails);
    }
    
    @Override
    public View getView() {
        return new WalletUserView();
    }
}
