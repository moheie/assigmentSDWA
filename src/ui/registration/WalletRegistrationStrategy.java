package ui.registration;

import user.BankProvider;
import user.WalletProvider;
import user.Provider;

import java.util.HashMap;
import java.util.Scanner;

public class WalletRegistrationStrategy extends RegistrationStrategy {
    public WalletRegistrationStrategy() {
        providers = WalletProvider.values();
    }

    @Override
    public HashMap<String, String> readProviderData() {
        HashMap<String, String> providerData = new HashMap<>();

        Scanner scanner = new Scanner(System.in);
        String pinCode;

        System.out.print("Please enter your wallet PIN code: ");

        pinCode = scanner.next();

        providerData.put("pinCode", pinCode);

        return providerData;
    }
}
