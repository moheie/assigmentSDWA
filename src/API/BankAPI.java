package API;
import java.util.Scanner;

public class BankAPI extends API {
    private String accno;
    private String name;
    private String acc_type;
    private long balance;

    Scanner sc = new Scanner(System.in);

    @Override
    public void processTransaction(String to,long balance) {
        System.out.println("Processing bank transaction...");
        transfer();

        // handel API URL
        String apiUrl = "https://bankapi.com/transfer";
        String method = "POST";
        String requestBody = "from=" + accno + "&to=" + to + "&amount=" + balance;
        String response = callExternalApi(apiUrl, method, requestBody);
        System.out.println("Bank API Response: " + response);
    }

    public void openAccount() {
        System.out.print("Enter Account No: ");
        accno = sc.next();
        System.out.print("Enter Account type: ");
        acc_type = sc.next();
        System.out.print("Enter Name: ");
        name = sc.next();
        System.out.print("Enter Balance: ");
        balance = sc.nextLong();
    }
    public void showAccount() {
        System.out.println("Name of account holder: " + name);
        System.out.println("Account no.: " + accno);
        System.out.println("Account type: " + acc_type);
        System.out.println("Balance: " + balance);
    }

    public void transfer() {
        long amt;
        System.out.println("Enter the amount you want to transfer: ");
        amt = sc.nextLong();
        if (balance >= amt) {
            balance = balance - amt;
            System.out.println("Balance after transfer: " + balance);
        } else {
            System.out.println("Your balance is less than " + amt + "\tTransaction failed...!!" );
        }
    }
    public void verifyaccount(int user_id, int bank_account)
    {

    }

    public boolean search(String ac_no) {
        if (accno.equals(ac_no)) {
            showAccount();
            return (true);
        }
        return (false);
    }
}