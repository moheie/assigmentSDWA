package ui.registration;

import user.BankProvider;
import user.Provider;

import java.util.HashMap;
import java.util.Scanner;

public class BankRegistrationStrategy extends RegistrationStrategy {
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

        providerData.put("accountNumber", accountNumber);
        providerData.put("securityCode", securityCode);

        return providerData;
    }
}
