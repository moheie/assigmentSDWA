package ui.registration;

import db.UserDB;
import ui.View;
import user.Provider;
import user.User;
import user.UserDetails;
import user.UserType;

import java.util.HashMap;
import java.util.Scanner;
public class SignUpView extends View {
    private final UserDB userDB = UserDB.getInstance();
    Scanner scanner = new Scanner(System.in);
    Provider provider;
    HashMap<String, String> providerData;
    @Override
    public void display() {
        System.out.println("Please specify how you'd like to register your account:");
        System.out.println("1. Bank Account");
        System.out.println("2. E-Wallet");
        System.out.println("0. Exit");
        int input;
        RegistrationStrategy strategy;
        UserType type;
        while (true) {
            input = scanner.nextInt();

            switch (input) {
                case 1:
                    strategy = new BankRegistrationStrategy();
                    type = UserType.Bank;
                    break;
                case 2:
                    strategy = new WalletRegistrationStrategy();
                    type = UserType.Wallet;
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid input. Please enter a valid option.");
                    continue;
            }
            provider = strategy.readProvider();
            providerData = strategy.readProviderData();
            // check if provider data is valid by calling the appropriate API
            // if valid:
            // create user details & new user with UserFactory
            // maybe auto-login by calling user.getView().display();
            // after checking asks user for username/pass/phone number
            UserDetails details = readUserDetails(provider,providerData,type); // todo: make sure this always collects a valid username & password before returning
            userDB.insertUser(details);
            System.out.println("account Created");
            break;
        }
    }

    // todo: please don't forget to add phone input here (and OTP verification if needed) <-(moheie note: its in API)
    public UserDetails readUserDetails(Provider provider, HashMap<String,String> providerData,UserType type) {
        UserDetails userDetails;
        while(true) {
            System.out.print("Enter your username: ");
            String username = scanner.next();
            if (!userDB.has(username)) { // in here we will check if the username exist
                while(true) {
                    System.out.print("Enter your user password: ");
                    String password = scanner.next();
                    System.out.print("Confirm your password: ");
                    String confirmPassword = scanner.next();
                    if (password.equals(confirmPassword)) {
                        System.out.println("Enter phone number");
                        String phone = scanner.next();
                        userDetails = new UserDetails(username,password,phone,type,provider,providerData);
                        return userDetails;
                    } else {
                        System.out.println("Passwords arent matching");
                    }
                }
            } else {
                System.out.println("Username is already in use");
            }
        }
    }
}
