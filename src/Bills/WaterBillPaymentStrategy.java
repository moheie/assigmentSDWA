package Bills;


import user.User;
import user.UserDetails;
import util.Session;


import java.util.Random;
import java.util.Scanner;


public class WaterBillPaymentStrategy implements BillPaymentStrategy {
        private long amount;
        protected Session session =Session.getInstance();
        protected Scanner scanner =new Scanner(System.in);
        protected User user = session.getUser();
        protected UserDetails userDetails = user.getDetails();
        Random random = new Random();
        int min = 100;
        int max = 1000;
        int randomInRange = random.nextInt(max - min + 1) + min;


        public WaterBillPaymentStrategy() {
            this.amount = randomInRange;
        }

        @Override
        public void createBill(){
            System.out.println("Water bill created. Details:");
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

        @Override
        public void deductFromAccount() {

            Session session =Session.getInstance();
            User user = session.getUser();
            UserDetails userDetails = user.getDetails();
            System.out.println("Deducting Water bill amount: $" + amount);
            if(true) {
                if(userDetails.getBalance()<amount){
                    System.out.println("You don't have this amount");
                    return;
                }
                long newBalance = userDetails.getBalance() - amount;
                userDetails.setBalance(userDetails.getBalance()-newBalance);
            }
        }
}