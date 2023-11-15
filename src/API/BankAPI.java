package API;
import java.util.Scanner;
import java.util.HashMap;
public class BankAPI extends API {
    HashMap <String , Long>userBalance = new HashMap<String, Long>();
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


    public void transfer() {
        long amt;
        System.out.println("Enter the amount you want to transfer: ");
        amt = sc.nextLong();
        if (userBalance >= amt) {
            userBalance = userBalance - amt;
            System.out.println("Balance after transfer: " + userBalance);
        } else {
            System.out.println("Your balance is less than " + amt + "\tTransaction failed...!!" );
        }
    }
    public void verifyaccount(int mobilephone)
    {

    }

    public boolean search(String ac_no) {
        if (accno.equals(ac_no)) {
            return (true);
        }
        return (false);
    }
}