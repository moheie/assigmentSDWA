package ui.registration;

import db.UserDB;
import ui.View;
import user.Provider;

import java.util.HashMap;
import java.util.Scanner;
public class SignUpView extends View {
    private final UserDB userDB = UserDB.getInstance();
    Scanner scanner = new Scanner(System.in);

    String username;
    String password;
    String phone;
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

        while (true) {
            input = scanner.nextInt();

            switch (input) {
                case 1:
                    strategy = new BankRegistrationStrategy();
                    break;
                case 2:
                    strategy = new WalletRegistrationStrategy();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid input. Please enter a valid option.");
                    continue;
            }

            readUserInfo(); // todo: make sure this always collects a valid username & password before returning

            provider = strategy.readProvider();
            providerData = strategy.readProviderData();

            // check if provider data is valid by calling the appropriate API
            // if valid:
            // create user details & new user with UserFactory
            // maybe auto-login by calling user.getView().display();

            break;
        }
    }

    // todo: please don't forget to add phone input here (and OTP verification if needed) <-(moheie note: its in API)
    public void readUserInfo() {
        System.out.print("Enter your username: ");
        String username = scanner.next();

        if (!userDB.has(username)) { // in here we will check if the username exist
            System.out.print("Enter your user password: ");
            String password = scanner.next();

            System.out.print("Confirm your password: ");
            String confirmPassword = scanner.next();

            if (password.equals(confirmPassword)) {
            //    userDB.insertUser(username); mesh mafrood tkon hena cause it takes userdetials and the details aren
            }
        }  else {
            System.out.println("Username is already in use");
        }
    }
}
