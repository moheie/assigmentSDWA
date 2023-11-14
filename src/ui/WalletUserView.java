package ui;

import java.util.Scanner;

public class WalletUserView extends View {
    @Override
    public void display() {
        System.out.println("Welcome to the Wallet User View!");

        // Display relevant options or information for a user with a wallet
        System.out.println("1. Transfer to Another Instapay Account");
        System.out.println("2. Transfer to Wallet ");
        System.out.println("3. Inquire about Balance");
        System.out.println("4. Pay Bills");
        System.out.println("0. Logout");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                // Implement transfer to another Instapay account
                break;
            case 2:
                // Implement transfer to Wallet
                break;
            case 3:
                // Implement balance inquiry
                break;
            case 4:
                // Implement bill payment
                break;
            case 0:
                // Implement logout
                break;
            default:
                System.out.println("Invalid choice. Please enter a valid option.");
        }
    }
}
