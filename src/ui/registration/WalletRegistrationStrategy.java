package ui.registration;

import provider.Provider;
import provider.WalletProvider;
import provider.client.ProviderClient;
import provider.client.ProviderClientFactory;
import provider.client.wallet.WalletClientFactory;
import user.UserDetails;

import java.util.HashMap;
import java.util.Scanner;

public class WalletRegistrationStrategy extends RegistrationStrategy {
    private WalletClientFactory clientFactory = new WalletClientFactory();

    public WalletRegistrationStrategy() {
        providers = WalletProvider.values();
    }

    @Override
    public HashMap<String, String> readProviderData(UserDetails userDetails) {
        HashMap<String, String> providerData = new HashMap<>();

        Scanner scanner = new Scanner(System.in);
        String pinCode;

        System.out.print("Please enter your wallet PIN code: ");

        pinCode = scanner.next();

        providerData.put("account_number", userDetails.getPhone());
        providerData.put("pin_code", pinCode);

        userDetails.setProviderData(providerData);

        return providerData;
    }

    @Override
    public ProviderClient getProviderClient(Provider provider) {
        return clientFactory.createClient(provider);
    }
}
