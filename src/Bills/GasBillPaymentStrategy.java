package Bills;

import user.User;
import user.UserDetails;
import util.Session;

import java.util.Random;
import java.util.Scanner;

public class GasBillPaymentStrategy implements BillPaymentStrategy {
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
    @Override
    public void deductFromAccount() {
        Session session =Session.getInstance();
        User user = session.getUser();
        UserDetails userDetails = user.getDetails();
        System.out.println("do you want to proceed? (Y/N)");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();
        if(choice.equals("y")||choice.equals("Y") ) {
            System.out.println("Deducting Water bill amount: $" + amount);
            if(userDetails.getBalance()<amount){
                System.out.println("You don't have this amount");
                return;
            }
            long newBalance = userDetails.getBalance() - amount;
            userDetails.setBalance(newBalance);
        }
        return;
    }
}