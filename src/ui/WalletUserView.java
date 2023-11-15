package ui;

import user.User;
import user.UserDetails;
import user.UserView;
import util.Session;

import java.util.Scanner;

public class WalletUserView extends UserView {
    private final Session session =Session.getInstance();
    @Override
    public void display() {
        System.out.println("Welcome to the Wallet User View!");
        // Display relevant options or information for a user with a wallet
        while(true) {
            System.out.println("1. Transfer to Another Instapay Account");
            System.out.println("2. Transfer to Wallet ");
            System.out.println("3. Inquire about Balance");
            System.out.println("4. Pay Bills");
            System.out.println("0. Logout");
            User user = session.getUser();
            UserDetails userDetails = user.getDetails();

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    transferToAccount();
                    break;
                case 2:
                    transferToWallet();
                    break;
                case 3:
                    showBalance();
                    break;
                case 4:
                    payBills();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
