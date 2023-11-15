package bills;
import provider.client.ProviderClient;
import user.User;
import util.Session;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class ElectricityBillPaymentStrategy implements BillPaymentStrategy {
    private static final String ELECTRICITY_COMPANY_BANK_ACCOUNT = "12492187323";
    private Session session = Session.getInstance();
    private long amount;
    Random random = new Random();
    int min = 100;
    int max = 1500;
    int randomInRange = random.nextInt(max - min + 1) + min;
    public ElectricityBillPaymentStrategy() {
        this.amount = randomInRange;
    }

    @Override
    public void createBill() {
        System.out.println("Electricity bill created Details:");
        System.out.println("Billing Period: " + generateBillingPeriod());
        System.out.println("Units Consumed: " + generateRandomUnits() + " kWh");
        System.out.println("Service Provider: ABC Electric Company");
        System.out.println("Amount: $" + amount);
    }
    private String generateBillingPeriod() {
        return "February 2023";
    }
    private int generateRandomUnits() {

        return (int) (Math.random() * 451) + 50;
    }
    private HashMap<String, String> generatePaymentParams() {
        HashMap<String, String> companyTransferParams = new HashMap<>();

        companyTransferParams.put("type", "Bank");
        companyTransferParams.put("amount", Long.toString(amount));
        companyTransferParams.put("account_number", ELECTRICITY_COMPANY_BANK_ACCOUNT);

        return companyTransferParams;
    }
    @Override
    public void deductFromAccount() {
        User user = session.getUser();

        System.out.println("Do you want to proceed? (Y/N)");

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();

        if (choice.equalsIgnoreCase("y")) {
            System.out.println("Deducting electricity bill amount: $" + amount);

            ProviderClient providerClient = user.getProviderClient();
            ProviderClient.TransferStatus status = providerClient.transfer(user.getDetails(), generatePaymentParams());

            switch (status) {
                case Successful -> System.out.printf("Successfully paid electricity bill of $%d%n", amount);
                case InsufficientFunds -> System.out.println("Insufficient funds. Payment failed.");
            }
        }
    }
}