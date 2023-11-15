package ui.registration;

import db.UserDB;
import provider.client.ProviderClient;
import provider.client.ProviderClientFactory;
import ui.View;
import provider.Provider;
import user.User;
import user.UserDetails;
import user.UserType;
import util.OTPService;

import java.util.HashMap;
import java.util.Scanner;
public class SignUpView extends View {
    private final UserDB userDB = UserDB.getInstance();
    private final OTPService otpService = OTPService.getInstance();

    private Scanner scanner = new Scanner(System.in);
    private UserDetails userDetails = new UserDetails();

    // todo: please don't forget to add phone input here (and OTP verification if needed) <-(moheie note: its in API)
    private void readUserInfo() {
        String username;

        while (true) {
            System.out.print("Enter your username: ");
            username = scanner.next();

            if (userDB.has(username)) { // in here we will check if the username exist
                System.out.println("Username is already in use");
            } else {
                break;
            }
        }

        while (true) {
            System.out.print("Enter your user password: ");
            String password = scanner.next();

            System.out.print("Confirm your password: ");
            String confirmPassword = scanner.next();

            if (password.equals(confirmPassword)) {
                userDetails.setUsername(username);
                userDetails.setPassword(password);

                break;
            } else {
                System.out.println("Passwords arent matching");
            }
        }
    }

    private void validateNumber(String phone) {
        otpService.sendOTP(phone);

        String otp;

        while (true) {
            System.out.print("Please enter the OTP you just received over SMS: ");
            otp = scanner.next();

            if (otpService.verifyOTP(phone, otp)) {
                System.out.println("Phone number validated successfully");
                break;
            } else {
                System.out.println("Invalid OTP. Please try again.");
            }
        }
    }

    @Override
    public void display() {
        System.out.println("Please specify how you'd like to register your account:");
        System.out.println("1. Bank Account");
        System.out.println("2. E-Wallet");
        System.out.println("0. Exit");

        int input = 0;
        boolean skipInput = false;

        RegistrationStrategy strategy;

        while (true) {
            if (!skipInput) {
                input = scanner.nextInt();
            } else {
                skipInput = false;
            }

            switch (input) {
                case 1:
                    strategy = new BankRegistrationStrategy();

                    userDetails.setType(UserType.Bank);
                    break;
                case 2:
                    strategy = new WalletRegistrationStrategy();

                    userDetails.setType(UserType.Wallet);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid input. Please enter a valid option.");
                    continue;
            }

            System.out.print("Enter your phone number: ");
            String phone = scanner.next();

            userDetails.setPhone(phone);

            Provider provider = strategy.readProvider();

            userDetails.setProvider(provider);

            strategy.readProviderData(userDetails);

            // check if provider data is valid by calling the appropriate API
            ProviderClient providerClient = strategy.getProviderClient(provider);

            if (!providerClient.verify(userDetails)) {
                System.out.println("Provider verification failed. Please check your credentials.");

                skipInput = true;
                continue;
            }

            System.out.println("Provider verification successful.");

            validateNumber(phone);

            // by this point, we are sure that the user-provided bank/wallet information is valid
            readUserInfo();

            User user = userDB.add(userDetails);

            System.out.println("Account created successfully");
            break;
        }
    }
}
