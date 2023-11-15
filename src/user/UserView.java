package user;

import bills.BillView;
import db.UserDB;
import provider.client.ProviderClient;
import ui.View;
import util.Session;

import java.util.HashMap;
import java.util.Scanner;

public abstract class UserView extends View {
    protected UserDB userDB = UserDB.getInstance();
    protected Session session = Session.getInstance();
    protected Scanner scanner = new Scanner(System.in);

    protected void showBalance() {
        User user = session.getUser();

        System.out.println("Your bank account balance: $" + user.getBalance());
    }

    protected void payBills(){
        View view = new BillView();

        view.display();
    }

    protected boolean transferTo(String target, long amount, String transferType) {
        HashMap<String, String> targetParameters = new HashMap<>();

        targetParameters.put("type", transferType);
        targetParameters.put("amount", Long.toString(amount));
        targetParameters.put("target", target);

        User user = session.getUser();
        ProviderClient providerClient = user.getProviderClient();

        switch (providerClient.transfer(user.getDetails(), targetParameters)) {
            case Successful:
                return true;
            case InsufficientFunds:
                System.out.println("You do not have enough funds to complete this transaction.");
                break;
            case TargetNotFound:
                System.out.println("No account was found at the target you provided.");
                break;
        }

        return false;
    }

    protected void transferToAccount() {
        System.out.print("Enter the username you want to send the money to: ");
        String username = scanner.next();

        User targetUser = userDB.get(username);

        if (targetUser == null) {
            System.out.println("This user doesn't exist");

            return;
        }

        UserDetails targetUserDetails = targetUser.getDetails();
        HashMap<String, String> targetUserProviderData = targetUserDetails.getProviderData();

        System.out.print("Enter the amount of money you want to send: ");

        long amount = scanner.nextLong();
        boolean success = transferTo(
                targetUserProviderData.get("account_number"),
                amount,
                targetUserDetails.getType().name()
        );

        if (success) {
            System.out.printf("Successfully transferred $%d to %s.%n", amount, targetUserDetails.getUsername());
        }
    }

    protected void transferToWallet() {
        System.out.print("Enter the phone number of the wallet you want to send the money to: ");
        String phone = scanner.next();

        System.out.print("Enter the amount of money you want to send: ");
        long amount = scanner.nextLong();
        boolean success = transferTo(phone, amount, "Wallet");

        if (success) {
            System.out.printf("Successfully transferred $%d to %s.%n", amount, phone);
        }
    }
}
