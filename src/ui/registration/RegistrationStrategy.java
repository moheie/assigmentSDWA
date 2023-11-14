package ui.registration;

import user.Provider;

import java.util.HashMap;
import java.util.Scanner;

public abstract class RegistrationStrategy {
    protected Scanner scanner = new Scanner(System.in);
    protected Provider[] providers;
    
    public Provider readProvider() {
        Provider provider = null;

        System.out.println("Please choose your provider:");

        while (provider == null) {
            for (int i = 0; i < providers.length; i++) {
                System.out.println(
                        String.format(
                                "%d. %s",
                                i + 1,
                                providers[i].getLabel()
                        )
                );
            }

            try {
                provider = providers[scanner.nextInt()];
            } catch(Exception exception) {
                System.out.println("Invalid provider. Please try again.");
            }
        }

        return provider;
    }

    public abstract HashMap<String, String> readProviderData();
}
