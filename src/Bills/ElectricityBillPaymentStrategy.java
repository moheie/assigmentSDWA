package Bills;
import user.User;
import user.UserDetails;
import util.Session;

import java.util.Random;
import java.util.Scanner;

public class ElectricityBillPaymentStrategy implements BillPaymentStrategy {
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