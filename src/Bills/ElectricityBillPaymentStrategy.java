package Bills;

public class ElectricityBillPaymentStrategy implements BillPaymentStrategy {
    @Override
    public void processBillPayment(long amount) {
        System.out.println("Processing Electricity Bill Payment: $" + amount);
    }
}