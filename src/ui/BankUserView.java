package ui;

import Bills.BillPaymentStrategy;
import db.UserDB;
import provider.client.ProviderClient;
import provider.client.bank.BankProviderClient;
import provider.client.bank.HSBCBankClient;
import provider.client.bank.MISRBankClient;
import provider.client.bank.NBEBankClient;
import user.User;
import user.UserDetails;
import user.UserView;
import util.Session;

import java.util.HashMap;
import java.util.Scanner;

public class BankUserView extends UserView {
    public void transferToBank(){
        System.out.print("Enter the account number of the bank account you want to send the money to: ");
        String accountNumber = scanner.next();

        System.out.print("Enter the amount of money you want to send: ");
        long amount = scanner.nextLong();
        boolean success = transferTo(accountNumber, amount, "Bank");

        if (success) {
            System.out.printf("Successfully transferred $%d to %s.%n", amount, accountNumber);
        }
    }
    @Override
    public void display() {
        System.out.println("Welcome to the Bank User View!");
        Scanner scanner = new Scanner(System.in);

        // Display relevant options or information for a user with a bank account
        while(true) {
            System.out.println("1. Transfer to Another Instapay Account");
            System.out.println("2. Transfer to Bank Account");
            System.out.println("3. Transfer to Wallet");
            System.out.println("4. Inquire about Balance");
            System.out.println("5. Pay Bills");
            System.out.println("0. Logout");


            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    transferToAccount();
                    break;
                case 2:
                    transferToBank();
                    break;
                case 3:
                    transferToWallet();
                    break;
                case 4:
                    showBalance();
                    break;
                case 5:
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
