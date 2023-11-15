package bills;

import provider.client.ProviderClient;
import user.User;
import util.Session;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class GasBillPaymentStrategy implements BillPaymentStrategy {
    private static final String GAS_COMPANY_BANK_ACCOUNT = "95348503484";
    private Session session = Session.getInstance();
    private long amount;
    Random random = new Random();
    int min = 100;
    int max = 700;
    int randomInRange = random.nextInt(max - min + 1) + min;
    public GasBillPaymentStrategy() {
        this.amount = randomInRange;
    }

    @Override
    public void createBill() {
        System.out.println("Gas bill created Details:");
        System.out.println("Billing Period: " + generateBillingPeriod());
        System.out.println("Gas Consumption: " + generateRandomConsumption() + " cubic meters");
        System.out.println("Service Provider: XYZ Gas Company");
        System.out.println("Amount: $" + amount);
    }
    private int generateRandomConsumption() {

        return (int) (Math.random() * 500) + 1;
    }
    private String generateBillingPeriod() {

        return "January 2023";
    }
    private HashMap<String, String> generatePaymentParams() {
        HashMap<String, String> companyTransferParams = new HashMap<>();

        companyTransferParams.put("type", "Bank");
        companyTransferParams.put("amount", Long.toString(amount));
        companyTransferParams.put("account_number", GAS_COMPANY_BANK_ACCOUNT);

        return companyTransferParams;
    }
    @Override
    public void deductFromAccount() {
        User user = session.getUser();

        System.out.println("Do you want to proceed? (Y/N)");

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();

        if (choice.equalsIgnoreCase("y")) {
            System.out.println("Deducting gas bill amount: $" + amount);

            ProviderClient providerClient = user.getProviderClient();
            ProviderClient.TransferStatus status = providerClient.transfer(user.getDetails(), generatePaymentParams());

            switch (status) {
                case Successful -> System.out.printf("Successfully paid gas bill of $%d%n", amount);
                case InsufficientFunds -> System.out.println("Insufficient funds. Payment failed.");
            }
        }
    }
}