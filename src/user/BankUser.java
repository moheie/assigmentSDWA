package user;

import provider.client.ProviderClient;
import provider.client.bank.BankClientFactory;
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
    @Override
    public ProviderClient getProviderClient() {
        BankClientFactory clientFactory = new BankClientFactory();

        return clientFactory.createClient(getDetails().getProvider());
    }

}
