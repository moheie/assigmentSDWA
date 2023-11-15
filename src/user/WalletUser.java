package user;

import provider.client.ProviderClient;
import provider.client.wallet.WalletClientFactory;
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

    @Override
    public ProviderClient getProviderClient() {
        WalletClientFactory clientFactory = new WalletClientFactory();

        return clientFactory.createClient(getDetails().getProvider());
    }

}
