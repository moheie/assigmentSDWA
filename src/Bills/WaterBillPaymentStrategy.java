package Bills;

public class WaterBillPaymentStrategy implements BillPaymentStrategy {
    @Override
    public void processBillPayment(long amount) {
        System.out.println("Processing Water Bill Payment: $" + amount);
    }
}