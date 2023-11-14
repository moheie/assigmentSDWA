package ui;

import java.util.Scanner;

public class BankUserView extends View {
    @Override
    public void display() {
        System.out.println("Welcome to the Bank User View!");
        Scanner scanner = new Scanner(System.in);
        // Display relevant options or information for a user with a bank account
        System.out.println("1. Transfer to Another Instapay Account");
        System.out.println("2. Transfer to Bank Account");
        System.out.println("3. Transfer to Wallet");
        System.out.println("4. Inquire about Balance");
        System.out.println("5. Pay Bills");
        System.out.println("0. Logout");

        int choice = scanner.nextInt();

        // Handle user's choice
        switch (choice) {
            case 1:
                // Implement transfer to another Instapay account
                break;
            case 2:
                // Implement transfer to bank account
                break;
            case 3:
                // Implement transfer to wallet
                break;
            case 4:
                // Implement balance inquiry
                break;
            case 5:
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
