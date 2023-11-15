package user;

import ui.View;
import ui.WalletUserView;

public class WalletUser extends User {
    public WalletUser(UserDetails userDetails) {
        super(userDetails);
    }
    
    @Override
    public View getView() {
        return new WalletUserView();
    }
}
