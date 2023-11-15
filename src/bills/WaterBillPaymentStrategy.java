package bills;


import provider.client.ProviderClient;
import user.User;
import util.Session;


import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;


public class WaterBillPaymentStrategy implements BillPaymentStrategy {
    private static final String WATER_COMPANY_BANK_ACCOUNT = "31023094242";
    private Session session = Session.getInstance();
    protected Scanner scanner = new Scanner(System.in);

    private long amount;
    Random random = new Random();
    int min = 100;
    int max = 1000;
    int randomInRange = random.nextInt(max - min + 1) + min;

    public WaterBillPaymentStrategy() {
        this.amount = randomInRange;
    }

    @Override
    public void createBill(){
        System.out.println("Water bill created Details:");
        System.out.println("Billing Period: " + generateBillingPeriod());
        System.out.println("Liters Consumed: " + generateRandomLiters() + " liters");
        System.out.println("Service Provider: UVW Water Services");
        System.out.println("Amount: $" + amount);
    }

    private int generateRandomLiters(){
        return (int) (Math.random() * 4001) + 1000;
    }

    private String generateBillingPeriod() {
    return "March 2023";
    }

    private HashMap<String, String> generatePaymentParams() {
        HashMap<String, String> companyTransferParams = new HashMap<>();

        companyTransferParams.put("type", "Bank");
        companyTransferParams.put("amount", Long.toString(amount));
        companyTransferParams.put("account_number", WATER_COMPANY_BANK_ACCOUNT);

        return companyTransferParams;
    }
    @Override
    public void deductFromAccount() {
        User user = session.getUser();

        System.out.println("Do you want to proceed? (Y/N)");

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();

        if (choice.equalsIgnoreCase("y")) {
            System.out.println("Deducting water bill amount: $" + amount);

            ProviderClient providerClient = user.getProviderClient();
            ProviderClient.TransferStatus status = providerClient.transfer(user.getDetails(), generatePaymentParams());

            switch (status) {
                case Successful -> System.out.printf("Successfully paid water bill of $%d%n", amount);
                case InsufficientFunds -> System.out.println("Insufficient funds. Payment failed.");
            }
        }
    }
}