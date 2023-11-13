import java.util.Scanner;

public class WalletAPI extends API {
    private String walletId;
    private String ownerName;
    private long walletBalance;

    Scanner scanner = new Scanner(System.in);

    @Override
    public void processTransaction() {
        System.out.println("Processing bank transaction...");
        transferFromWallet();
    }

    /*public void openWallet() {
        System.out.print("Enter Wallet ID: ");
        walletId = scanner.next();
        System.out.print("Enter Owner Name: ");
        ownerName = scanner.next();
        System.out.print("Enter Initial Wallet Balance: ");
        walletBalance = scanner.nextLong();
    }
*/
    public void transferFromWallet() {
        long amount;
        System.out.print("Enter the amount you want to transfer from your wallet: ");
        amount = scanner.nextLong();
        if (walletBalance >= amount) {
            walletBalance -= amount;
            System.out.println("Balance after transfer: " + walletBalance);
        } else {
            System.out.println("Insufficient funds. transformation failed.");
        }
    }

    public void showWalletDetails() {
        System.out.println("Owner of the wallet: " + ownerName);
        System.out.println("Wallet ID: " + walletId);
        System.out.println("Wallet Balance: " + walletBalance);
    }

    public boolean searchWallet(String searchId) {
        return walletId.equals(searchId);
    }

}
