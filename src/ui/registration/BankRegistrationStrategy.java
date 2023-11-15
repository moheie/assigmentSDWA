package ui.registration;

import provider.BankProvider;
import provider.Provider;
import provider.client.ProviderClient;
import provider.client.ProviderClientFactory;
import provider.client.bank.BankClientFactory;

import java.util.HashMap;
import java.util.Scanner;

public class BankRegistrationStrategy extends RegistrationStrategy {
    BankClientFactory clientFactory = new BankClientFactory();

    public BankRegistrationStrategy() {
        providers = BankProvider.values();
    }

    @Override
    public HashMap<String, String> readProviderData() {
        HashMap<String, String> providerData = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        String accountNumber;
        String securityCode;

        System.out.print("Please enter your bank account number: ");

        accountNumber = scanner.next();

        System.out.print("Please enter your bank account security code: ");

        securityCode = scanner.next();

        providerData.put("account_number", accountNumber);
        providerData.put("security_code", securityCode);

        return providerData;
    }

    @Override
    public ProviderClient getProviderClient(Provider provider) {
        return clientFactory.createClient(provider);
    }
}
